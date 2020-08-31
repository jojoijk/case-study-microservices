package com.fisglobal.repository.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.fisglobal.repository.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
	
	@Transactional
	@Modifying
	@Query(value="UPDATE BOOK SET AVAILABLE_COPIES=(SELECT * FROM (SELECT AVAILABLE_COPIES FROM BOOK WHERE BOOK_ID = :bookId) as t) - 1   where BOOK_ID = :bookId ", nativeQuery=true)
	Integer lendAvailableBook(@Param("bookId") Long bookId);
	
	
	@Transactional
	@Modifying
	@Query(value="UPDATE BOOK SET AVAILABLE_COPIES=(SELECT * FROM (SELECT AVAILABLE_COPIES FROM BOOK WHERE BOOK_ID = :bookId) as t) + 1   where BOOK_ID = :bookId ", nativeQuery=true)
	Integer returnBook(@Param("bookId") Long bookId);
}
