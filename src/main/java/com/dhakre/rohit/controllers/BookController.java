package com.dhakre.rohit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dhakre.rohit.models.Book;
import com.dhakre.rohit.responses.BookResponse;
import com.dhakre.rohit.responses.GetAllBookResponse;
import com.dhakre.rohit.services.IBookService;

@RestController
@RequestMapping("/api/books")
public class BookController {

	@Autowired
	@Qualifier("bookService")
	private IBookService bookService;

	@RequestMapping(value = "/category/{id}", method = RequestMethod.GET)
	public GetAllBookResponse getAllBooksByCategoryId(@PathVariable("id") Integer id) {
		return bookService.getAllBooksByCategoryId(id);
	}

	@RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
	public BookResponse getBookById(@PathVariable("id") Integer id) {
		return bookService.getBookById(id);
	}

	@RequestMapping(value = "/book", method = RequestMethod.POST)
	public BookResponse addNewBook(@RequestBody Book book) {
		return bookService.addBook(book);
	}

	@RequestMapping(value = "/book/{id}", method = RequestMethod.PUT)
	public BookResponse updateById(@PathVariable("id") Integer id, @RequestBody Book book) {
		return bookService.updateBookById(id, book);
	}

	@RequestMapping(value = "/book/{id}", method = RequestMethod.DELETE)
	public GetAllBookResponse deleteById(@PathVariable("id") Integer id) {
		return bookService.deleteBookById(id);
	}

}
