package com.skillstorm.munchables.beans;

import javax.persistence.EmbeddedId;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;


//@Embeddable
//@Entity
//@Table(name = "RecipeIngredients")
public class JoinTable {
	
	@EmbeddedId
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "JoinTableId")
	private int joinTableId;
	
	
	//@Column(name = "RecipeId")
	private int RecipeId;
	
	
	//@Column(name = "IngredientId")
	private int IngredientId;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "RecipeId")
	@JsonBackReference(value = "recipeJoin")
	private Recipe recipe;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "IngredientId")
	@JsonBackReference(value = "ingredientsJoin")
	private Ingredients ingredients;
	
	public Recipe getRecipe() {
		return recipe;
	}

	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}

	public Ingredients getIngredients() {
		return ingredients;
	}

	public void setIngredients(Ingredients ingredients) {
		this.ingredients = ingredients;
	}

	public JoinTable() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getJoinTableId() {
		return joinTableId;
	}

	public void setJoinTableId(int joinTableId) {
		this.joinTableId = joinTableId;
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
