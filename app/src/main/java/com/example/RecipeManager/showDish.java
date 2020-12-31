package com.example.RecipeManager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class showDish extends AppCompatActivity {

    ImageView image;
    TextView title;
    TextView serves;
    TextView difficulty;
    TextView type;
    TextView ingredients;
    TextView preparation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_dish);


        image = findViewById(R.id.mImage);
        title = findViewById(R.id.mDish);
        serves = findViewById(R.id.mServes);
        difficulty = findViewById(R.id.mDifficulty);
        type = findViewById(R.id.mType);
        ingredients = findViewById(R.id.mIngredients);
        preparation = findViewById(R.id.mPreparation);

        Intent intent = getIntent();
        Data data = (Data) intent.getSerializableExtra("data");

        String servesText = "Serves : " + String.valueOf(data.getServes());
        String difficultyText = "Difficulty : " + data.getDifficulty();

        image.setImageURI(Uri.parse(data.getImageUri()));
        title.setText(data.getTitle());
        serves.setText(servesText);
        difficulty.setText(difficultyText);
        type.setText(data.getType());
        ingredients.setText(data.getIngredients());
        preparation.setText(data.getPreparation());
    }
}