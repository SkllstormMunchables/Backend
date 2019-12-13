package com.skillstorm.munchables.Data;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.skillstorm.munchables.beans.Ingredients;
import com.skillstorm.munchables.beans.Measurements;
import com.skillstorm.munchables.beans.Recipe;
import com.skillstorm.munchables.beans.Steps;

public interface RecipeRepository extends JpaRepository<Recipe, Integer> {

//Add recipe
	@Query("insert into RECIPES(RECIPE_NAME) values ?")
	public Recipe addRecipe();
	
	@Query("select * from RECIPES where RECIPE_ID = ?")
	public Recipe findById();
	
	
}

	

