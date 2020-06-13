package com.example.terrariapotions.Model;

import java.io.Serializable;
import java.util.List;

public class Potion implements Serializable {
    private int id;
    private String name;
    private String description;
    private String imgId;
    private List<Ingredient> ingredients;

    public Potion(int id, String name, String description, String imgId, List<Ingredient> ingredients) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imgId = imgId;
        this.ingredients = ingredients;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgId() {
        return imgId;
    }

    public void setImgId(String imgId) {
        this.imgId = imgId;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public String toString() {
        return "Potion{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", imgId='" + imgId + '\'' +
                ", ingredients=" + ingredients +
                '}';
    }
}
