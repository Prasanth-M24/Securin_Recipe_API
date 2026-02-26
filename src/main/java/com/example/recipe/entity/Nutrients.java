package com.example.recipe.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Column;

@Embeddable
public class Nutrients {

    @Column(name = "calories")
    private String calories;

    @Column(name = "carbohydrate_content")
    private String carbohydrateContent;

    @Column(name = "protein_content")
    private String proteinContent;

    @Column(name = "fat_content")
    private String fatContent;

    public String getCalories() {
        return calories;
    }

    public void setCalories(String calories) {
        this.calories = calories;
    }

    public String getCarbohydrateContent() {
        return carbohydrateContent;
    }

    public void setCarbohydrateContent(String carbohydrateContent) {
        this.carbohydrateContent = carbohydrateContent;
    }

    public String getProteinContent() {
        return proteinContent;
    }

    public void setProteinContent(String proteinContent) {
        this.proteinContent = proteinContent;
    }

    public String getFatContent() {
        return fatContent;
    }

    public void setFatContent(String fatContent) {
        this.fatContent = fatContent;
    }

    public Nutrients() {}

    public Nutrients(String calories, String carbohydrateContent,
                     String proteinContent, String fatContent) {
        this.calories = calories;
        this.carbohydrateContent = carbohydrateContent;
        this.proteinContent = proteinContent;
        this.fatContent = fatContent;
    }
}