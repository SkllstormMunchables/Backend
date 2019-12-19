package com.skillstorm.munchables.RecipeController;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.skillstorm.munchables.beans.RecipeIngredients;

//@RestController
@RequestMapping(value = "/recipeIngredients")
public class RecipeIngredientsController {

	//@Autowired
	//private RecipeIngredientsRepository recipeIngredientsRepository;	

//Get requests
	@GetMapping(value = "/recipeIngredientsAll", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<RecipeIngredients>> findAll() {
		return null;
		//return new ResponseEntity<List<RecipeIngredients>>(recipeIngredientsRepository.findAll(), HttpStatus.OK);
	}

	
}
