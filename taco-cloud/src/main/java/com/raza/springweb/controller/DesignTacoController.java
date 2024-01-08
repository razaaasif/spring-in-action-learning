package com.raza.springweb.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.raza.common.Constants.IngredientType;
import com.raza.model.Ingredient;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("tacoOrder")
public class DesignTacoController {
	public void addIngredientsToModel(Model model) {
		List<Ingredient> ingredients = Arrays.asList(
				new Ingredient("FLTO", "Flour Tortilla", IngredientType.WRAP),
				new Ingredient("COTO", "Corn Tortilla", IngredientType.WRAP),
				new Ingredient("GRBF", "Ground Beef", IngredientType.PROTEIN),
				new Ingredient("CARN", "Carnitas", IngredientType.PROTEIN),
				new Ingredient("TMTO", "Diced Tomatoes", IngredientType.VEGGIES),
				new Ingredient("LETC", "Lettuce", IngredientType.VEGGIES),
				new Ingredient("CHED", "Cheddar", IngredientType.CHEESE),
				new Ingredient("JACK", "Monterrey Jack", IngredientType.CHEESE),
				new Ingredient("SLSA", "Salsa", IngredientType.SAUCE),
				new Ingredient("SRCR", "Sour Cream", IngredientType.SAUCE));
		
		for (IngredientType type : IngredientType.values()) {
			model.addAttribute(type.toString().toLowerCase(),
			filterByIngredientType(ingredients, type));
		}
	}

	private List<Ingredient> filterByIngredientType(List<Ingredient> ingredients, IngredientType type) {
		return ingredients
				.stream()
				.filter(t -> type.equals(t.getType()))
				.collect(Collectors.toList());
	}
}
