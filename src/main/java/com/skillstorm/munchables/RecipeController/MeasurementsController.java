package com.skillstorm.munchables.RecipeController;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.munchables.Data.MeasurementsRepository;
import com.skillstorm.munchables.Data.RecipeRepository;
import com.skillstorm.munchables.Service.RecipeService;
import com.skillstorm.munchables.beans.Measurements;
import com.skillstorm.munchables.beans.Recipe;

@RestController
@RequestMapping(value = "api/measurements")
public class MeasurementsController {

	public static final Logger logger = Logger.getLogger(RecipeController.class);

	@Autowired
	private MeasurementsRepository measurementRepository;

	// Get requests
	@GetMapping(value = "/measurementsall", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Measurements>> findAllRecipe() {
		return new ResponseEntity<List<Measurements>>(measurementRepository.findAll(), HttpStatus.OK);
	}

	// get by ID
	@GetMapping(value = "/measurements/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Measurements findByid(@PathVariable int id) {
		Optional<Measurements> opt = measurementRepository.findById(id);
		if (opt.isPresent()) {
			return opt.get();
		} else {
			return new Measurements();
		}
	}
	// Post Request

	@PostMapping(value = "/measurements", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	// @Transactional(propagation = Propagation.REQUIRES_NEW)
	public ResponseEntity<Measurements> save(@Valid @RequestBody Measurements measurements) {
		ResponseEntity<Measurements> response = new ResponseEntity<Measurements>(measurementRepository.save(measurements), HttpStatus.CREATED);
		return response;
	}

	// Put Request

	@PutMapping(value = "/measurements/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Measurements> update(@Valid @RequestBody Measurements measurement, @PathVariable int id) {
		if (!measurementRepository.existsById(id) || measurement.getMeasurementId()== 0) {
			return new ResponseEntity<Measurements>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Measurements>(measurementRepository.save(measurement), HttpStatus.NO_CONTENT);
	}
	
}
