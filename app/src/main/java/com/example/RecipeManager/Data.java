package com.example.RecipeManager;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class Data implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int ID;

    @ColumnInfo(name = "title")
    String title;

    @ColumnInfo(name = "type")
    String type;

    @ColumnInfo(name = "serves")
    int serves;

    @ColumnInfo(name = "difficulty")
    String difficulty;

    @ColumnInfo(name = "ingredients")
    String ingredients;

    @ColumnInfo(name = "preparation")
    String preparation;

    @ColumnInfo(name = "image")
    String imageUri;

    public Data(String title, String type, int serves, String difficulty, String ingredients, String preparation, String imageUri) {
        this.title = title;
        this.type = type;
        this.serves = serves;
        this.difficulty = difficulty;
        this.ingredients = ingredients;
        this.preparation = preparation;
        this.imageUri = imageUri;

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getPreparation() {
        return preparation;
    }

    public void setPreparation(String preparation) {
        this.preparation = preparation;
    }

    public String getImageUri() {
        return imageUri;
    }

    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getServes() {
        return serves;
    }

    public void setServes(int serves) {
        this.serves = serves;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }
}
