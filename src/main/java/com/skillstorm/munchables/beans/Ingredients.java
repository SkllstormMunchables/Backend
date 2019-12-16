package com.skillstorm.munchables.beans;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "Ingredients")
public class Ingredients {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IngredientId")
	public int ingredientId;
	
	@Column(name="IngredientName")
	public String name;
	
	@ManyToMany(mappedBy = "ingredients")
	@JsonBackReference(value = "ingredientsJoin")
	private Set<Recipe> recipe;
		
	public Set<Recipe> getRecipe() {
		return recipe;
	}

	public void setRecipe(Set<Recipe> recipe) {
		this.recipe = recipe;
	}

	public Ingredients() {
		super();
	}

	public Ingredients(int ingredientId, String name) {
		this.ingredientId = ingredientId;
		this.name = name;
		
	}

	public int getIngredientId() {
		return ingredientId;
	}

	public void setIngredientId(int ingredientId) {
		this.ingredientId = ingredientId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Ingredients [ingredientId=" + ingredientId + ", name=" + name + "]";
	}

}
