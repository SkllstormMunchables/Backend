package com.skillstorm.munchables.Data;


import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.skillstorm.munchables.beans.Recipe;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Integer>{
 
	

	
}