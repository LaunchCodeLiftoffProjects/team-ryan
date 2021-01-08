package org.launchcode.recipeapp.models;

public enum IngredientCategory {
    VEGETABLE("Vegetable"),
    FRUIT("Fruit"),
    GRAIN("Grain"),
    PROTEIN("Protein"),
    DAIRY("Dairy"),
    OIL("Oil"),
    OTHER("Other");

    private final String displayName;

    IngredientCategory(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
