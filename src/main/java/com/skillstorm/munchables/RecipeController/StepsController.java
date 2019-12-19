package com.skillstorm.munchables.RecipeController;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.munchables.Data.RecipeRepository;
import com.skillstorm.munchables.Data.StepsRepository;
import com.skillstorm.munchables.Service.RecipeService;
import com.skillstorm.munchables.beans.Recipe;
import com.skillstorm.munchables.beans.Steps;

@RestController
@RequestMapping(value = "/steps")
@CrossOrigin(origins = "http://localhost:4200")
public class StepsController {

	
	public static final Logger logger = Logger.getLogger(RecipeController.class);

	@Autowired
	private StepsRepository stepsRepository;

	// Get requests
	@GetMapping(value = "/stepsall", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Steps>> findAllRecipe() {
		return new ResponseEntity<List<Steps>>(stepsRepository.findAll(), HttpStatus.OK);
	}

	// get by ID
	@GetMapping(value = "/steps/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Steps findByid(@PathVariable int id) {
		Optional<Steps> opt = stepsRepository.findById(id);
		if (opt.isPresent()) {
			return opt.get();
		} else {
			return new Steps();
		}
	}
	// Post Request

	@PostMapping(value = "/stepsadd", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public ResponseEntity<Steps> create(@Valid @RequestBody Steps step) {
	return new ResponseEntity<Steps>(stepsRepository.save(step), HttpStatus.CREATED);
		
	}

	// Put Request

	@PutMapping(value = "/steps/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Steps> update(@Valid @RequestBody Steps step, @PathVariable int id) {
		if (!stepsRepository.existsById(id) || step.getRecipeId() == 0) {
			return new ResponseEntity<Steps>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Steps>(stepsRepository.save(step), HttpStatus.NO_CONTENT);
	}
}
