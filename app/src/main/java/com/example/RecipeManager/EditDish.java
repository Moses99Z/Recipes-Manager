package com.example.RecipeManager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class EditDish extends AppCompatActivity {

    View view;
    View scrollView;

    EditText title;
    EditText serves;
    EditText ingredients;
    EditText preparation;

    RadioGroup difficulty;
    String theDifficulty;

    Button submit;
    Button choose;

    Uri selectedImage;
    String myImage;
    ImageView thisImage;

    ArrayList<String> list;
    ArrayAdapter<String> arrayAdapter;
    AutoCompleteTextView autoCompleteTextView;
    TextInputLayout type;
    String item;

    Data mData;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_dish);

        theDifficulty = "Easy";

        view = findViewById(R.id.context_edit);
        scrollView = findViewById(R.id.scroll_edit);

        title = findViewById(R.id.titleAdd);
        serves = findViewById(R.id.servesAdd);
        difficulty = findViewById(R.id.difficultyAdd);
        ingredients = findViewById(R.id.ingredientsAdd);
        preparation = findViewById(R.id.preparationAdd);
        thisImage = findViewById(R.id.thisImage);

        choose = findViewById(R.id.choose);
        submit = findViewById(R.id.submitBtn);

        autoCompleteTextView = findViewById(R.id.autoComplete);
        type = findViewById(R.id.type);
        list = new ArrayList<>();

        list.add("Breakfast");
        list.add("Lunch");
        list.add("Dinner");
        list.add("Collation");

        arrayAdapter = new ArrayAdapter<>(getApplicationContext(), R.layout.list_item, list);
        autoCompleteTextView.setAdapter(arrayAdapter);

        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                item = parent.getItemAtPosition(position).toString();
            }
        });

        Intent intent = getIntent();
        mData = (Data) intent.getSerializableExtra("data");

        autoCompleteTextView.setText(mData.getType(), false);
        thisImage.setImageURI(Uri.parse(mData.getImageUri()));
        title.setText(mData.getTitle());
        serves.setText(String.valueOf(mData.getServes()));
        difficulty.check(R.id.easy);
        ingredients.setText(mData.getIngredients());
        preparation.setText(mData.getPreparation());

        myImage = mData.getImageUri();

        difficulty.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                    case R.id.easy:
                        theDifficulty = "Easy";
                        break;
                    case R.id.medium:
                        theDifficulty = "Medium";
                        break;
                    case R.id.hard:
                        theDifficulty = "Hard";
                        break;
                }
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (title.getText().toString().isEmpty()) {
                    title.setError(getString(R.string.shr_error_password));
                    scrollView.scrollTo(0, title.getTop());
                }
                else if (autoCompleteTextView.getText().toString().isEmpty()) {
                    type.setError(getString(R.string.shr_error_password));
                    scrollView.scrollTo(0, type.getTop());
                }
                else if (serves.getText().toString().isEmpty()) {
                    serves.setError(getString(R.string.shr_error_password));
                    scrollView.scrollTo(0, serves.getTop());
                }
                else if (ingredients.getText().toString().isEmpty()) {
                    ingredients.setError(getString(R.string.shr_error_password));
                    scrollView.scrollTo(0, ingredients.getTop());
                }
                else if (preparation.getText().toString().isEmpty()) {
                    preparation.setError(getString(R.string.shr_error_password));
                    scrollView.scrollTo(0, preparation.getTop());
                }
                else {
                    title.setError(null);
                    serves.setError(null);
                    ingredients.setError(null);
                    preparation.setError(null);
                    type.setError(null);
                    updateData(title.getText().toString(), item, Integer.parseInt(serves.getText().toString()), theDifficulty, ingredients.getText().toString(), preparation.getText().toString(), myImage);
                    startActivity(new Intent(EditDish.this, MainActivity.class));
                }
            }
        });

        choose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pickPhoto = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(pickPhoto , 1);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        assert data != null;
        selectedImage = data.getData();
        myImage = selectedImage.toString();
        thisImage.setImageURI(selectedImage);
        Snackbar.make(view, R.string.imageMsg, Snackbar.LENGTH_SHORT).setAction(R.string.dismiss_text, new View.OnClickListener() {
            @Override
            public void onClick(View v) {}
        }).show();

    }

    private void updateData(String title, String type, int serves, String difficulty, String ingredients, String preparation, String imageUri) {
        RoomDB db = RoomDB.getInstance(this.getApplicationContext());

        Data data = new Data(title, type, serves, difficulty, ingredients, preparation, imageUri);
        data.setID(mData.getID());
        db.DataDao().update(data);
    }

}
