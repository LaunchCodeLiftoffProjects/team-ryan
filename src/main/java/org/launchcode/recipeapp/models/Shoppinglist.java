package org.launchcode.recipeapp.models;

import org.launchcode.recipeapp.User;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Objects;

@Entity
public class Shoppinglist {
    @Id
    @GeneratedValue
    private int id;


    //@OneToMany(mappedBy = "shoppingList")
    //private final List<Recipe> recipes = new ArrayList<>();




    public Shoppinglist(){}

    public int getId() {
        return id;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shoppinglist that = (Shoppinglist) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
