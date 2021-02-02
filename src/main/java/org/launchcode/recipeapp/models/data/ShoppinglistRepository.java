package org.launchcode.recipeapp.models.data;

import org.launchcode.recipeapp.models.Shoppinglist;
import org.springframework.data.repository.CrudRepository;

public interface ShoppinglistRepository extends CrudRepository<Shoppinglist, Integer> {
}
