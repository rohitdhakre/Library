package com.dhakre.rohit.models;

import java.util.Date;

public class Book {

	private int id;
	private String name;
	private String author;
	private Date publishedDate;
	private String description;
	private int categoryId;

	public Book() {
		super();
	}

	public Book(int id, String name, String author, Date publishedDate, String description, int categoryId) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.publishedDate = publishedDate;
		this.description = description;
		this.categoryId = categoryId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", author=" + author + ", publishedDate=" + publishedDate + ", description=" + description + ", categoryId=" + categoryId + "]";
	}

}
