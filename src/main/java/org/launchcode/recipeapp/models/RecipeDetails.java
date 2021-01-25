package org.launchcode.recipeapp.models;

import org.launchcode.recipeapp.AbstractEntity;

import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class RecipeDetails extends AbstractEntity {
    @Size(max = 500, message = "Description too long!")
    private String description;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid Email. Try again.")
    private String contactEmail;

    public RecipeDetails(@Size(max = 500, message = "Description too long!") String description, @NotBlank(message = "Email is required") @Email(message = "Invalid Email. Try again.") String contactEmail) {
        this.description = description;
        this.contactEmail = contactEmail;
    }
    public RecipeDetails(){}

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }
}
