package com.raza.model;

import com.raza.common.Constants.IngredientType;

public class Ingredient {
	private final String id;
	private final String name;
	private final IngredientType type;

	public Ingredient(String id, String name, IngredientType type) {
		this.id = id;
		this.name = name;
		this.type = type;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public IngredientType getType() {
		return type;
	}

}
