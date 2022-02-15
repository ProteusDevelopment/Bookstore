package com.devcher.bookstore.books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BooksController
{
	@Autowired
	private BooksRepository booksRepository;

	@GetMapping("/")
	public List<Books> getAllBooks()
	{
		return booksRepository.findAll();
	}

	@PostMapping("/")
	public void createNewBook(@RequestBody Books book)
	{
		booksRepository.save(book);
	}
}
