package org.launchcode.recipeapp.models;

import java.util.Objects;

public class Recipes {

    private int id;
    private static int nextId = 1;

    private String name;
    private String about;
    private String ingr;
    private String direc;

    public Recipes(String name, String about, String ingr, String direc) {
        this.name = name;
        this.about = about;
        this.ingr = ingr;
        this.direc = direc;
        this.id = nextId;
        nextId++;
    }
    public int getId() {
        return id;
    }
    public String getDirec() {
        return direc;
    }

    public void setDirec(String direc) {
        this.direc = direc;
    }

    public String getIngr() {
        return ingr;
    }

    public void setIngr(String ingr) {
        this.ingr = ingr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipes recipes = (Recipes) o;
        return id == recipes.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}