package com.recipe.recipeApi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.recipe.recipeApi.models.Recipe;

@Repository
public interface RecipeRepo extends JpaRepository<Recipe, Integer>{

}
