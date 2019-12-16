package com.skillstorm.munchables.beans;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name= "Steps")
public class Steps {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "StepId")
	public int stepId;
	
	@Column(name = "step")
	public String step;
	
//	@Column(name = "RECIPE_ID")
//	public int recipeId;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "RecipeId")
	@JsonBackReference(value = "recipeSteps")
	private Recipe recipe;
	
	
	public Recipe getRecipe() {
		return recipe;
	}

	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}

	public Steps() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Steps(int stepId, String step, int recipeId) {
		super();
		this.stepId = stepId;
		this.step = step;
//		this.recipeId = recipeId;
	}

	public int getRecipeId() {
		return stepId;
	}

	public void setRecipeId(int stepId) {
		this.stepId = stepId;
	}

	public String getStep() {
		return step;
	}

	public void setStep(String step) {
		this.step = step;
	}

//	public int getRecipeId() {
//		return recipeId;
//	}
//
//	public void setRecipeId(int recipeId) {
//		this.recipeId = recipeId;
//	}

	@Override
	public String toString() {
		return "Steps [stepId=" + stepId + ", step=" + step + "]";
	}

}
