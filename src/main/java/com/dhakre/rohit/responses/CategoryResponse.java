package com.dhakre.rohit.responses;

import com.dhakre.rohit.models.Category;

public class CategoryResponse extends BaseResponse {

	private Category category;

	public CategoryResponse() {
		super();
	}

	public CategoryResponse(boolean isSuccessful, String message) {
		super(isSuccessful, message);
	}

	public CategoryResponse(boolean isSuccessful, Category category) {
		super(isSuccessful, null);
		this.category = category;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "CategoryResponse [category=" + category + "]";
	}

}
