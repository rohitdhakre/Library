package com.dhakre.rohit.services;

import com.dhakre.rohit.models.Category;
import com.dhakre.rohit.responses.CategoryResponse;
import com.dhakre.rohit.responses.GetAllCategoryResponse;

public interface ICategoryService {

	public GetAllCategoryResponse getAllCategories();

	public CategoryResponse getCategoryById(Integer id);

	public CategoryResponse addCategory(Category category);

	public CategoryResponse updateCategoryById(Integer id, Category category);

	public GetAllCategoryResponse deleteCategoryById(Integer id);

}
