package org.launchcode.recipeapp.models;

import java.util.Objects;

public class Search {
    private int id;

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Search search = (Search) o;
        return id == search.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    //    private String title;
//
//    public Search(String title) {
//        this.title = title;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    @Override
//    public String toString() {
//        return title;
//    }
}
