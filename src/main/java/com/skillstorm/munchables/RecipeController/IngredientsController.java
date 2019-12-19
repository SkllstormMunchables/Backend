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

import com.skillstorm.munchables.Data.IngredientsRepository;
import com.skillstorm.munchables.Data.RecipeRepository;
import com.skillstorm.munchables.Service.RecipeService;
import com.skillstorm.munchables.beans.Ingredients;
import com.skillstorm.munchables.beans.Recipe;


@RestController
@RequestMapping(value = "/ingredients")
@CrossOrigin(origins = "http://localhost:4200")
public class IngredientsController {
	
	public static final Logger logger = Logger.getLogger(IngredientsController.class);

	@Autowired
	private IngredientsRepository ingredientRepository;

	// Get requests
	@GetMapping(value = "/ingredientall", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Ingredients>> findAllRecipe() {
		return new ResponseEntity<List<Ingredients>>(ingredientRepository.findAll(), HttpStatus.OK);
	}

	// get by ID
	@GetMapping(value = "/ingredient/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Ingredients findByid(@PathVariable int id) {
		Optional<Ingredients> opt = ingredientRepository.findById(id);
		if (opt.isPresent()) {
			return opt.get();
		} else {
			return new Ingredients ();
		}
	}
	// Post Request

	@PostMapping(value = "/ingredient", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	// @Transactional(propagation = Propagation.REQUIRES_NEW)
	public ResponseEntity<Ingredients> save(@Valid @RequestBody Ingredients ingredient) {
		ResponseEntity<Ingredients> response = new ResponseEntity<Ingredients>(ingredientRepository.save(ingredient), HttpStatus.CREATED);
		return response;
	}

	// Put Request

	@PutMapping(value = "/ingredient/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Ingredients> update(@Valid @RequestBody Ingredients ingredient, @PathVariable int id) {
		if (!ingredientRepository.existsById(id) || ingredient.ingredientId == 0) {
			return new ResponseEntity<Ingredients>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Ingredients>(ingredientRepository.save(ingredient), HttpStatus.NO_CONTENT);
	}

}
