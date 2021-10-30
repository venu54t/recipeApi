package com.recipe.recipeApi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recipe.recipeApi.models.Recipe;
import com.recipe.recipeApi.repositories.RecipeRepo;

@Service
public class RecipeService {

	@Autowired
	private RecipeRepo recipeRepo;
	
	
	public Recipe getById(int id)
	{
		return recipeRepo.findById(id).get();
	}
	
	public List<Recipe> getAllRecipes()
	{
		return recipeRepo.findAll();
	}
	public List<Recipe> dumpRecipe(List<Recipe> recipes)
	{
		return recipeRepo.saveAll(recipes);
	}
	
	public Recipe saveRecipe(Recipe recipe)
	{
		return recipeRepo.save(recipe);
	}
}
