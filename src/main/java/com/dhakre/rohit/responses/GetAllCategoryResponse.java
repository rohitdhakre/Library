package com.dhakre.rohit.responses;

import java.util.List;

import com.dhakre.rohit.models.Category;

public class GetAllCategoryResponse extends BaseResponse {

	private List<Category> categoryList;

	public GetAllCategoryResponse() {
		super();
	}

	public GetAllCategoryResponse(boolean isSuccessful, String message) {
		super(isSuccessful, message);
	}

	public GetAllCategoryResponse(boolean isSuccessful, List<Category> categoryList) {
		super(isSuccessful, null);
		this.categoryList = categoryList;
	}

	public List<Category> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<Category> categoryList) {
		this.categoryList = categoryList;
	}

	@Override
	public String toString() {
		return "CategoryResponse [categoryList=" + categoryList + "]";
	}

}
