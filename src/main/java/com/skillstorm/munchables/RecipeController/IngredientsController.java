package com.skillstorm.munchables.RecipeController;
import java.util.List;

import javax.validation.Valid;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.munchables.Data.RecipeRepository;
import com.skillstorm.munchables.Service.RecipeService;
import com.skillstorm.munchables.beans.Ingredients;
import com.skillstorm.munchables.beans.Measurements;
import com.skillstorm.munchables.beans.Recipe;


@RestController
@RequestMapping(value = "/ingredients")
public class IngredientsController {
	
	public static final Logger logger = Logger.getLogger(IngredientsController.class);

	@Autowired
	private RecipeRepository recipeRepository;

	@Autowired
	private RecipeService service;

	// Get requests
	@GetMapping
	public ResponseEntity<List<Ingredients>> findAllRecipe() {
		return new ResponseEntity<List<Ingredients>>(recipeRepository.findAllIngredients(), HttpStatus.OK);
	}

	// Post Request

	@PostMapping(value = "/ingredients", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public ResponseEntity<Ingredients> save(@Valid @RequestBody Ingredients ingredient) {
		ResponseEntity<Ingredient> response = 
				new ResponseEntity<Ingredient>(recipeRepository.(artist), HttpStatus.CREATED); 
		// HttpStatus.CREATED === 201 
		return response;
	}
	

	// Put Request

	@PutMapping(value = "/ingredients/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Ingredients> update(@Valid @RequestBody Ingredients ingredient, @PathVariable int id) {
		return new ResponseEntity<Ingredients>(service.save(ingredient), HttpStatus.NO_CONTENT);

		// Delete REquest
	}

}
