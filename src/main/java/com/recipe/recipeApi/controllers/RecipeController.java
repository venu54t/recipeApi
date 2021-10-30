package com.recipe.recipeApi.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.recipe.recipeApi.models.Recipe;
import com.recipe.recipeApi.services.RecipeService;

@RestController
public class RecipeController {

	@Autowired
	private RecipeService recipeService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/")
	public List<Recipe> getAllRecipes()
	{
		return recipeService.getAllRecipes();
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	public Recipe getById(@RequestBody @PathVariable("id") int id)
	{
		return recipeService.getById(id);
	}
	
	
	@PostMapping("/dump")
	@ResponseBody
	public List<Recipe> dumpRecipes()
	{
		ResponseEntity<Recipe[]> res=  restTemplate.getForEntity("https://s3-ap-southeast-1.amazonaws.com/he-public-data/reciped9d7b8c.json", Recipe[].class);
		Recipe[] recipeList= res.getBody();		
		return recipeService.dumpRecipe(Arrays.asList(recipeList));
	}
	
	
	@PostMapping("/")
	@ResponseBody
	public Recipe saveRecipe(@RequestBody Recipe recipe)
	{
		return recipeService.saveRecipe(recipe);
	}
	
	@GetMapping("/{id}/show")
	public String getImage(@RequestBody @PathVariable("id") int id)
	{
		return recipeService.getById(id).getImage();
	}
	
	
	
}
