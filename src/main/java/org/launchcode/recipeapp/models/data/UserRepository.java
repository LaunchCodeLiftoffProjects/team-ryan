package org.launchcode.recipeapp.models.data;

import org.launchcode.recipeapp.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Integer> {
    User findByUsername(String username);
}
