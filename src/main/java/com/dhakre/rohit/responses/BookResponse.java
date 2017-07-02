package com.dhakre.rohit.responses;

import com.dhakre.rohit.models.Book;

public class BookResponse extends BaseResponse {

	private Book book;

	public BookResponse() {
		super();
	}

	public BookResponse(boolean isSuccessful, String message) {
		super(isSuccessful, message);
	}

	public BookResponse(boolean isSuccessful, String message, Book book) {
		super(isSuccessful, null);
		this.book = book;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	@Override
	public String toString() {
		return "BookResponse [book=" + book + "]";
	}

}
