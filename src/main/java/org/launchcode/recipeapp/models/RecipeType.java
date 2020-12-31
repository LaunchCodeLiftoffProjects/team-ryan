package org.launchcode.recipeapp.models;

public enum RecipeType {

    BREAKFAST("Breakfast"),
    LUNCH("Lunch"),
    DINNER("Dinner"),
    DESERT("Desert");

    private final String displayName;

    RecipeType(String displayName)    {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}

