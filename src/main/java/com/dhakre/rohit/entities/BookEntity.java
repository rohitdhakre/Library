package com.dhakre.rohit.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "book")
public class BookEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	@NotNull
	private String name;

	@Column(name = "author")
	private String author;

	@Column(name = "published_date")
	private Date publishedDate;

	@Column(name = "description")
	private String description;

	@Column(name = "category_id")
	private int categoryId;

	public BookEntity() {
		super();
	}

	public BookEntity(int id, String name, String author, Date publishedDate, String description, int categoryId) {
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
		return "BookEntity [id=" + id + ", name=" + name + ", author=" + author + ", publishedDate=" + publishedDate + ", description=" + description + ", categoryId=" + categoryId + "]";
	}

}
