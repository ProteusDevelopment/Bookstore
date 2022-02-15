package com.devcher.bookstore.books;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepository extends
		JpaRepository<Books, Long>
{

}
