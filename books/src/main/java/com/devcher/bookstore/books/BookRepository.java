package com.devcher.bookstore.books;

import com.devcher.bookstore.books.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends
		JpaRepository<Book, Long>
{

}
