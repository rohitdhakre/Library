package com.dhakre.rohit.responses;

import java.util.List;

import com.dhakre.rohit.models.Book;

public class GetAllBookResponse extends BaseResponse {

	private List<Book> bookList;

	public GetAllBookResponse() {
		super();
	}

	public GetAllBookResponse(boolean isSuccessful, String message) {
		super(isSuccessful, message);
	}

	public GetAllBookResponse(boolean isSuccessful, List<Book> bookList) {
		super(isSuccessful, null);
		this.bookList = bookList;
	}

	public List<Book> getBookList() {
		return bookList;
	}

	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}

}
