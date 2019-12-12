package com.skillstorm.munchables.Service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.skillstorm.munchables.Data.RecipeRepository;
import com.skillstorm.munchables.beans.Ingredients;
import com.skillstorm.munchables.beans.Measurements;
import com.skillstorm.munchables.beans.Recipe;
import com.skillstorm.munchables.beans.Steps;

@Scope
@Service
@Component(value = "recipeService")
public class RecipeService {

	@Autowired
	private RecipeRepository recipeRepository;
//	private Recipe newRecipe = new Recipe();
	private Measurements measurement = new Measurements();
	private Ingredients ingredient = new Ingredients();
	private Steps step = new Steps();

	public Recipe save(Recipe recipe) {
		recipe = new Recipe();
		recipeRepository.save(recipe);
		return recipe;
	}
	
	
	
}
