package com.team6.paf2.model;

import java.util.ArrayList;

public class Category {
	private String name;
	private Category subCategory = null;
	private ArrayList<Pattern> patterns = new ArrayList<Pattern>();

	public Category() {}
	
	public Category(String name) {
		this.name = name;
	}
	
	public void addPattern(Pattern pattern) {
		this.patterns.add(pattern);
	}
	
	public void removePattern(Pattern pattern) {
		this.patterns.remove(pattern);
	}

	// getters and setters
	
	public String getName() {
		return name;
	}

	public Category getSubCategory() {
		return subCategory;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSubCategory(Category subCategory) {
		this.subCategory = subCategory;
	}
}