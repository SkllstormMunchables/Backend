package com.skillstorm.munchables.beans;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "RECIPES")
public class Recipe {
	
	@Id
	@Column(name = "RECIPE_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	public int recipeId;
	
	@Column(name = "RECIPE_NAME")
	public String recipeName;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "RECIPE_INGREDIENTS", joinColumns = @JoinColumn(name = "RECIPE_ID"), inverseJoinColumns = @JoinColumn(name ="INGREDIENT_ID"))
	private Set<Ingredients> ingredients;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "recipe")
	private Set<Steps>steps;
	
	public void setSteps(Set<Steps> steps) {
		this.steps = steps;
	}
	public Recipe() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Recipe(int recipeId, String recipeName) {
		super();
		this.recipeId = recipeId;
		this.recipeName = recipeName;
	}
	public int getRecipeId() {
		return recipeId;
	}
	public void setRecipeId(int recipeId) {
		this.recipeId = recipeId;
	}
	public String getRecipeName() {
		return recipeName;
	}
	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}
	public Set<Ingredients> getIngredients() {
		return ingredients;
	}
	public void setIngredients(Set<Ingredients> ingredients) {
		this.ingredients = ingredients;
	}
	
	@Override
	public String toString() {
		return "Recipe [recipeId=" + recipeId + ", recipeName=" + recipeName + "]";
	}
	
	
}
