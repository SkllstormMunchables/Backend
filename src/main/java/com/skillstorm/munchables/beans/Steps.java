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

@Entity
@Table(name = "STEPS")
public class Steps {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "STEP_ID")
	public int stepId;
	
	@Column(name = "STEP")
	public String step;
	
////	@Column(name = "RECIPE_ID")
//	public int recipeId;

	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "RECIPE_ID")
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

	public int getStepId() {
		return stepId;
	}

	public void setStepId(int stepId) {
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
