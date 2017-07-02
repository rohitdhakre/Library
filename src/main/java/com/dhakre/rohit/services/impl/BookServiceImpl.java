package com.dhakre.rohit.services.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dhakre.rohit.entities.BookEntity;
import com.dhakre.rohit.models.Book;
import com.dhakre.rohit.repositories.IBookRepository;
import com.dhakre.rohit.responses.BookResponse;
import com.dhakre.rohit.responses.GetAllBookResponse;
import com.dhakre.rohit.services.IBookService;

@Service("bookService")
public class BookServiceImpl implements IBookService {

	@Autowired
	private IBookRepository bookRepo;

	@Override
	public GetAllBookResponse getAllBooksByCategoryId(int id) {
		GetAllBookResponse bookResponse;
		List<Book> list = new ArrayList<>();
		Iterable<BookEntity> itr = bookRepo.findById(id);
		for (BookEntity data : itr) {
			Book book = new Book(data.getId(), data.getName(), data.getAuthor(), data.getPublishedDate(), data.getDescription(), data.getCategoryId());
			list.add(book);
		}
		bookResponse = new GetAllBookResponse(true, list);
		return bookResponse;
	}

	@Override
	public BookResponse getBookById(int id) {
		BookResponse bookResponse = new BookResponse();
		try {
			BookEntity bookEntity = bookRepo.findOne(id);
			Book book = new Book(bookEntity.getId(), bookEntity.getName(), bookEntity.getAuthor(), bookEntity.getPublishedDate(), bookEntity.getDescription(), bookEntity.getCategoryId());
			bookResponse.setSuccessful(true);
			bookResponse.setBook(book);
		} catch (Exception e) {
			bookResponse.setSuccessful(true);
			bookResponse.setMessage(null);
		}
		return bookResponse;
	}

	@Override
	public BookResponse addBook(Book book) {
		BookResponse bookResponse = new BookResponse();
		try {
			BookEntity bookEntity = new BookEntity(0, book.getName(), book.getAuthor(), new Date(book.getPublishedDate().getTime()), book.getDescription(), book.getCategoryId());
			bookEntity = bookRepo.save(bookEntity);
			book.setId(bookEntity.getId());
			bookResponse.setSuccessful(true);
			bookResponse.setBook(book);
		} catch (Exception e) {
			bookResponse.setSuccessful(false);
			bookResponse.setMessage("Can't add - book already exists");
		}
		return bookResponse;
	}

	@Override
	public BookResponse updateBookById(int id, Book book) {
		BookResponse bookResponse = new BookResponse();
		if (bookRepo.exists(id)) {
			BookEntity bookEntity = new BookEntity(id, book.getName(), book.getAuthor(), new Date(book.getPublishedDate().getTime()), book.getDescription(), book.getCategoryId());
			bookEntity = bookRepo.save(bookEntity);
			book.setId(bookEntity.getId());
			bookResponse.setSuccessful(true);
			bookResponse.setBook(book);
		} else {
			bookResponse.setSuccessful(false);
			bookResponse.setMessage("Can't update - book id doesn't exists");
		}
		return bookResponse;
	}

	@Override
	public GetAllBookResponse deleteBookById(int id) {
		GetAllBookResponse bookResponse = new GetAllBookResponse();
		try {
			bookRepo.delete(id);
			bookResponse.setSuccessful(true);
		} catch (Exception e) {
			bookResponse.setSuccessful(false);
			bookResponse.setMessage("Can't delete - book id doesn't exists");
		}
		return bookResponse;
	}

}
