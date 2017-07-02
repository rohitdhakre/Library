package com.dhakre.rohit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dhakre.rohit.models.Category;
import com.dhakre.rohit.responses.CategoryResponse;
import com.dhakre.rohit.responses.GetAllCategoryResponse;
import com.dhakre.rohit.services.ICategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

	@Autowired
	@Qualifier("categoryService")
	private ICategoryService categoryService;

	@RequestMapping(value = "/category", method = RequestMethod.GET)
	public GetAllCategoryResponse getAllCategory() {
		return categoryService.getAllCategories();
	}

	@RequestMapping(value = "/category/{id}", method = RequestMethod.GET)
	public CategoryResponse getCategoryById(@PathVariable("id") Integer id) {
		return categoryService.getCategoryById(id);
	}

	@RequestMapping(value = "/category", method = RequestMethod.POST)
	public CategoryResponse addCategory(@RequestBody Category category) {
		return categoryService.addCategory(category);
	}

	@RequestMapping(value = "/category/{id}", method = RequestMethod.PUT)
	public CategoryResponse updateCategory(@PathVariable("id") Integer id, @RequestBody Category category) {
		return categoryService.updateCategoryById(id, category);
	}

	@RequestMapping(value = "/category/{id}", method = RequestMethod.DELETE)
	public GetAllCategoryResponse deleteById(@PathVariable("id") Integer id) {
		return categoryService.deleteCategoryById(id);
	}

}
