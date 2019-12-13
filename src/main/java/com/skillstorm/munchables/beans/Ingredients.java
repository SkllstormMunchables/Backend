package com.skillstorm.munchables.beans;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "INGREDIENTS")

public class Ingredients {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "INGREDIENT_ID")
	public int ingredientId;
	
	@Column(name="INGREDIENT_NAME")
	public String name;
	
	@ManyToMany(mappedBy = "Ingredient")
	private Set<Recipe> recipe;
		
	public Set<Recipe> getRecipe() {
		return recipe;
	}

	public void setRecipe(Set<Recipe> recipe) {
		this.recipe = recipe;
	}

	public Ingredients() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ingredients(int ingredientId, String name) {
		super();
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
