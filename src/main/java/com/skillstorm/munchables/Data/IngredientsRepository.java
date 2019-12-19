package com.skillstorm.munchables.Data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skillstorm.munchables.beans.Ingredients;

public interface IngredientsRepository extends JpaRepository<Ingredients, Integer> {

}
