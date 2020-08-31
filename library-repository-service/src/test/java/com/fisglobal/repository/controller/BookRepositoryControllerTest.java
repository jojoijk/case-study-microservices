package com.fisglobal.repository.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.ResponseEntity;

import com.fisglobal.repository.entity.Book;

@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BookRepositoryControllerTest {
	
	@Autowired 
	BookRepositoryController controller;

	
	@Test
	@Order(1)
	public void testAddBook() {
		Book book = new Book();
		book.setName("Microservices");
		book.setAUTHOR("Java Microservices");
		book.setAVAILABLE_COPIES(new Long(100));
		book.setTOTAL_COPIES(new Long(100));
		ResponseEntity<Book> books = this.controller.addBook(book);
		assertThat(books.getBody()).isNotNull();
	}
	
	@Test
	@Order(2)
	public void testGetBooks() {
		List<Book> books = this.controller.retrieveAvailableBooks();
		assertThat(books).isNotNull();
	}
	
	@Test
	@Order(3)
	public void testGetBookById() {
		ResponseEntity<Book> book = this.controller.getBookById("2");
		assertThat(book.getBody()).isNotNull();
	}
	
	@Test
	@Order(4)
	public void testLendBookById() {
		Integer bookId = this.controller.lendBookById("2");
		assertThat(bookId).isNotNull();
	}
	
	@Test
	@Order(4)
	public void testReturnBookById() {
		Integer bookId = this.controller.returnBookById("2");
		assertThat(bookId).isNotNull();
	}
}

