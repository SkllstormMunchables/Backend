package com.skillstorm.munchables.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;

@Entity
public class JoinTable {
	
	@Id
	@Column(name = "RECIPE ID")
	private int RecipeId;
	
	@Column(name = "INGREDIENT ID")
	private int IngredientId;
	public JoinTable() {
		super();
		// TODO Auto-generated constructor stub
	}
	public JoinTable(int recipeId, int ingredientId) {
		super();
		RecipeId = recipeId;
		IngredientId = ingredientId;
	}
	public int getRecipeId() {
		return RecipeId;
	}
	public void setRecipeId(int recipeId) {
		RecipeId = recipeId;
	}
	public int getIngredientId() {
		return IngredientId;
	}
	public void setIngredientId(int ingredientId) {
		IngredientId = ingredientId;
	}
	@Override
	public String toString() {
		return "JointTable [RecipeId=" + RecipeId + ", IngredientId=" + IngredientId + "]";
	}
	
	
}
