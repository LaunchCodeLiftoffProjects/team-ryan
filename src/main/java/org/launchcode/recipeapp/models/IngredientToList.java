package org.launchcode.recipeapp.models;

public enum IngredientToList {
    ADDTOSHOPPINGLIST("Yes"),
    DONOTADDTOSHOPPINGLIST("No");

    private final String displayName;

    IngredientToList(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
