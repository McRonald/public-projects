package com.team6.paf2.model.service;

import java.util.ArrayList;

import com.team6.paf2.model.Category;
import com.team6.paf2.model.Pattern;

public class PatternService implements PatternServiceImpl {
	private ArrayList<Category> categories = new ArrayList<Category>();
	private ArrayList<Pattern> patterns = new ArrayList<Pattern>();
	protected static PatternService instance;
	protected int patternIdCounter = 0;
	
	public static PatternService getInstance() {
		if (instance == null) {
			instance = new PatternService();
		}
		return instance;
	}

	@Override
	public ArrayList<Category> getAllCategories() {
		return this.categories;
	}
	
	@Override
	public void addCategory(String name) {
		Category category = new Category(name);
		this.categories.add(category);
	}
	
	@Override
	public void addSubCategoryToCategory(Category category, String name) {
		Category subCategory = new Category(name);
		category.setSubCategory(subCategory);
	}
	
	@Override
	public ArrayList<Pattern> getAllPatterns() {
		return this.patterns;
	}
	
	@Override
	public boolean addPattern(Pattern pattern) {
		if (patternsContainsName(pattern.getName())) {;
			return false;
		}
		if (!this.patterns.add(pattern)) {
			return false;
		}
		this.patternIdCounter++;
		return true;
	}

	@Override
	public void removeSubCategoryFromCategory(Category category) {
		category.setSubCategory(new Category());
	}
	
	private boolean patternsContainsName(String name) {
		String iteratorName = "";
		for(Pattern pattern : patterns) {
			iteratorName = pattern.getName();
			if (iteratorName.equals(name)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int getNewId() {
		return this.patternIdCounter;
	}

	@Override
	public Pattern getPatternById(int id) {
		for(Pattern pattern : patterns) {
			if (pattern.getId() == id) {
				return pattern;
			}
		}
		return new Pattern();
	}

	@Override
	public boolean removePatternById(int id) {
		Pattern pattern = this.getPatternById(id);
		return this.patterns.remove(pattern);
	}
}