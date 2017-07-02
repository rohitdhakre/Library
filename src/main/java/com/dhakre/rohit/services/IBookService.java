package com.dhakre.rohit.services;

import com.dhakre.rohit.models.Book;
import com.dhakre.rohit.responses.BookResponse;
import com.dhakre.rohit.responses.GetAllBookResponse;

public interface IBookService {

	public GetAllBookResponse getAllBooksByCategoryId(int id);

	public BookResponse getBookById(int id);

	public BookResponse addBook(Book book);

	public BookResponse updateBookById(int id, Book book);

	public GetAllBookResponse deleteBookById(int id);

}
