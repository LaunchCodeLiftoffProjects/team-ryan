package org.launchcode.recipeapp;

import org.launchcode.recipeapp.models.Shoppinglist;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class User extends AbstractEntity {

        @NotNull
        private String username;

        @NotNull
        private String pwHash;

        @OneToOne
        private Shoppinglist shoppinglist;

        private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        public User() {}

        public User(String username, String password) {
            this.username = username;
            this.pwHash = encoder.encode(password);
        }

        public String getUsername() {
            return username;
        }

        public boolean isMatchingPassword(String password){
            return encoder.matches(password,pwHash);
        }
    }