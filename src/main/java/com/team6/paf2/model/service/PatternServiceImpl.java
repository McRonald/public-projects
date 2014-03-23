package com.team6.paf2.model.service;

import java.util.ArrayList;

import com.team6.paf2.model.Category;
import com.team6.paf2.model.Pattern;

public interface PatternServiceImpl {
	public void addCategory(String name);
	public void addSubCategoryToCategory(Category category, String name);
	public void removeSubCategoryFromCategory(Category category);
	public boolean addPattern(Pattern pattern);
	public boolean removePatternById(int id);
	public int getNewId();
	public ArrayList<Category> getAllCategories();
	public ArrayList<Pattern> getAllPatterns();
	public Pattern getPatternById(int id);
}
