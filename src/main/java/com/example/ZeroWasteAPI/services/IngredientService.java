package com.example.ZeroWasteAPI.services;

import com.example.ZeroWasteAPI.models.Ingredient;
import com.example.ZeroWasteAPI.models.Recipe;
import com.example.ZeroWasteAPI.models.User;
import com.example.ZeroWasteAPI.repositories.IngredientRepository;
import com.example.ZeroWasteAPI.repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientService {

    @Autowired
    IngredientRepository ingredientRepository;

    @Autowired
    RecipeRepository recipeRepository;

    public List<Ingredient> getAllIngredients() {
        return ingredientRepository.findAll();
    }

    public Ingredient getIngredientById(long id){
        return ingredientRepository.findById(id).get();
    }


//    public Ingredient getIngredientsByRecipe(Recipe recipe) {
//        return ingredientRepository.findByRecipe(recipe).get();
//
//    }

    public Ingredient addNewIngredient(Ingredient ingredient) {
        ingredientRepository.save(ingredient);
        return ingredient;
    }

    public void addRecipe(Recipe recipe){
        this.addRecipe(recipe);
    }

    public Ingredient updateIngredient(Ingredient ingredient, Long id) {
        //Find recipe, add by id
        Ingredient ingredientToUpdate = ingredientRepository.findById(id).get();
        //Take each property and update it
        ingredientToUpdate.setName(ingredient.getName());

        //Save recipe to database

        //Return the recipe

        ingredientRepository.save(ingredientToUpdate);
        return ingredientToUpdate;
    }

    //DELETE recipe
    public void deleteIngredient(Long id) {
        ingredientRepository.deleteById(id);
    }

}

