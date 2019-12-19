package com.skillstorm.munchables.RecipeController;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.munchables.Data.RecipeRepository;
import com.skillstorm.munchables.Service.RecipeService;
import com.skillstorm.munchables.beans.Recipe;

@RestController
@RequestMapping(value = "/recipe")
@CrossOrigin(origins = "http://localhost:4200")
public class RecipeController {

	public static final Logger logger = Logger.getLogger(RecipeController.class);

	@Autowired
	private RecipeRepository recipeRepository;

	// Get requests
	@GetMapping(value = "/recipesall", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Recipe>> findAllRecipe() {
		return new ResponseEntity<List<Recipe>>(recipeRepository.findAll(), HttpStatus.OK);
	}

	// get by ID
	@GetMapping(value = "/recipes/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Recipe findByid(@PathVariable int id) {
		Optional<Recipe> opt = recipeRepository.findById(id);
		if (opt.isPresent()) {
			return opt.get();
		} else {
			return new Recipe();
		}
	}
	// Post Request

	@PostMapping(value = "/recipe", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	// @Transactional(propagation = Propagation.REQUIRES_NEW)
	public ResponseEntity<Recipe> save(@Valid @RequestBody Recipe recipe) {
		ResponseEntity<Recipe> response = new ResponseEntity<Recipe>(recipeRepository.save(recipe), HttpStatus.CREATED);
		return response;
	}

	// Put Request

	@PutMapping(value = "/recipe/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Recipe> update(@Valid @RequestBody Recipe recipe, @PathVariable int id) {
		if (!recipeRepository.existsById(id) || recipe.getRecipeId() == 0) {
			return new ResponseEntity<Recipe>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Recipe>(recipeRepository.save(recipe), HttpStatus.NO_CONTENT);
	}

}