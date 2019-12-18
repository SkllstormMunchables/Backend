package com.skillstorm.munchables.beans;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "Recipe")
public class Recipe {
	
	@Id
	@Column(name = "RecipeId")
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	public int recipeId;
	
	@Column(name = "RecipeName")
	public String recipeName;

	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "RecipeIngredients", 
        joinColumns = { @JoinColumn(name = "RecipeId") }, 
        inverseJoinColumns = { @JoinColumn(name = "IngredientId") })
	@JsonManagedReference(value = "recipeJoin")
	private Set<Ingredients> ingredients;
	
	@OneToMany(mappedBy = "recipe")
	@JsonManagedReference(value = "recipeSteps")
	private Set<Steps>steps;
	
	public Recipe() {
		super();
	}
	public Set<Ingredients> getIngredients() {
		return ingredients;
	}
	
	public void setIngredients(Set<Ingredients> ingredients) {
		this.ingredients = ingredients;
	}
	public Set<Steps> getSteps() {
		return steps;
	}

	public void setSteps(Set<Steps> steps) {
		this.steps = steps;
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
	
	@Override
	public String toString() {
		return "Recipe [recipeId=" + recipeId + ", recipeName=" + recipeName + "]";
	}
	
	
}
