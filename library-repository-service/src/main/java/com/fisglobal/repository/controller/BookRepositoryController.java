package com.fisglobal.repository.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fisglobal.repository.data.BookRepository;
import com.fisglobal.repository.entity.Book;
import com.fisglobal.repository.exception.GenericObjectNotFoundException;

@RestController
@RequestMapping("/repository/book/")
public class BookRepositoryController {
	
	@Autowired
	private BookRepository bookRepository;

	@RequestMapping(value="retrieveAvailableBooks", method = RequestMethod.GET)
	public List<Book> retrieveAvailableBooks(){
		List<Book> bookList = bookRepository.findAll();
		return bookList;
	}
	
	@RequestMapping(value = "add", method = {RequestMethod.POST})
	public ResponseEntity<Book> addBook(@Valid @RequestBody final Book book)  {
		Book book1 = bookRepository.save(book);
		return new ResponseEntity<Book>(book1, HttpStatus.OK);
	}
	
	@RequestMapping(value = "search/{id}", method = {RequestMethod.GET})
	public  ResponseEntity<Book> getBookById(@PathVariable("id") String id)  {
		Optional<Book> book = bookRepository.findById(Long.valueOf(id));
		if (!book.isPresent())
			throw new GenericObjectNotFoundException("No book available with ID - " + id);
		else
			return new ResponseEntity<Book>(book.get(), HttpStatus.OK);
		
		
	}
	
	@RequestMapping(value = "lend/{id}", method = {RequestMethod.POST})
	public Integer lendBookById(@PathVariable("id") String id)  {
		 return bookRepository.lendAvailableBook(Long.valueOf(id));
	}
	
	@RequestMapping(value = "return/{id}", method = {RequestMethod.POST})
	public Integer returnBookById(@PathVariable("id") String id)  {
		 return bookRepository.returnBook(Long.valueOf(id));
	}
	
}
