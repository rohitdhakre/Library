package com.dhakre.rohit.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dhakre.rohit.entities.CategoryEntity;
import com.dhakre.rohit.models.Category;
import com.dhakre.rohit.repositories.ICategoryRepository;
import com.dhakre.rohit.responses.CategoryResponse;
import com.dhakre.rohit.responses.GetAllCategoryResponse;
import com.dhakre.rohit.services.ICategoryService;

@Service("categoryService")
public class CategoryServiceImpl implements ICategoryService {

	@Autowired
	private ICategoryRepository categoryRepo;

	@Override
	public GetAllCategoryResponse getAllCategories() {
		GetAllCategoryResponse categoryResponse = new GetAllCategoryResponse();
		List<Category> list = new ArrayList<>();
		Iterable<CategoryEntity> itr = categoryRepo.findAll();
		for (CategoryEntity data : itr) {
			Category category = new Category(data.getId(), data.getName());
			list.add(category);
		}
		categoryResponse.setSuccessful(true);
		categoryResponse.setCategoryList(list);
		return categoryResponse;
	}

	@Override
	public CategoryResponse getCategoryById(Integer id) {
		CategoryResponse categoryResponse = new CategoryResponse();
		try {
			CategoryEntity categoryEntity = categoryRepo.findOne(id);
			Category category = new Category(categoryEntity.getId(), categoryEntity.getName());
			categoryResponse.setSuccessful(true);
			categoryResponse.setCategory(category);
		} catch (Exception e) {
			categoryResponse.setSuccessful(true);
			categoryResponse.setMessage(null);
		}
		return categoryResponse;
	}

	@Override
	public CategoryResponse addCategory(Category category) {
		CategoryResponse categoryResponse = new CategoryResponse();
		try {
			CategoryEntity categoryEntity = new CategoryEntity(0, category.getName());
			categoryEntity = categoryRepo.save(categoryEntity);
			category.setId(categoryEntity.getId());
			categoryResponse.setSuccessful(true);
			categoryResponse.setMessage("Successfully added");
			categoryResponse.setCategory(category);
		} catch (Exception e) {
			categoryResponse.setSuccessful(false);
			categoryResponse.setMessage("Can't add - category already exists");
		}
		return categoryResponse;
	}

	@Override
	public CategoryResponse updateCategoryById(Integer id, Category category) {
		CategoryResponse categoryResponse = new CategoryResponse();
		if (categoryRepo.exists(id)) {
			CategoryEntity categoryEntity = new CategoryEntity(id, category.getName());
			categoryEntity = categoryRepo.save(categoryEntity);
			category.setId(categoryEntity.getId());
			categoryResponse.setSuccessful(true);
			categoryResponse.setCategory(category);
		} else {
			categoryResponse.setSuccessful(false);
			categoryResponse.setMessage("Can't update - category id doesn't exists");
		}
		return categoryResponse;
	}

	@Override
	public GetAllCategoryResponse deleteCategoryById(Integer id) {
		GetAllCategoryResponse categoryResponse = new GetAllCategoryResponse();
		try {
			categoryRepo.delete(id);
			categoryResponse.setSuccessful(true);
		} catch (Exception e) {
			categoryResponse.setSuccessful(false);
			categoryResponse.setMessage("Can't delete - category id doesn't exists");
		}
		return categoryResponse;
	}

}
