package org.launchcode.recipeapp.models;

public enum IngredientToList {
    ADDTOSHOPPINGLIST("Add to Shopping List"),
    DONOTADDTOSHOPPINGLIST("Do not Add to Shopping List");

    private final String displayName;

    IngredientToList(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
