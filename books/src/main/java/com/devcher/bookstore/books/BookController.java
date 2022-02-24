package com.devcher.bookstore.books;

import com.devcher.bookstore.books.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@RestController
public class BookController
{
	@Autowired
	private BookRepository booksRepository;

	@GetMapping("/user/books")
	public List<Book> getAllBooks()
	{
		return booksRepository.findAll();
	}

	@PostMapping("/admin/books")
	public void createNewBook(@RequestBody Book book)
	{
		booksRepository.save(book);
	}

	@GetMapping("/user/books/{id}")
	public Book getBook(@PathParam("id") Long id)
	{
		return booksRepository.findById(id).orElse(null);
	}

	@PatchMapping("/admin/books/{id}")
	public void patchBook(@PathParam("id") Long id,
	                      @RequestBody Book book)
	{
		Optional<Book> optionalBook = booksRepository.findById(id);

		if (optionalBook.isPresent())
		{
			Book existBook = optionalBook.get();

			boolean needUpdate = false;

			if (StringUtils.hasLength(book.getName()))
			{
				existBook.setName(book.getName());
				needUpdate = true;
			}

			if (StringUtils.hasLength(book.getDescription()))
			{
				existBook.setDescription(book.getDescription());
				needUpdate = true;
			}

			if (book.getPrice() > 0)
			{
				existBook.setPrice(book.getPrice());
				needUpdate = true;
			}

			if (StringUtils.hasLength(book.getImgUrl()))
			{
				existBook.setImgUrl(book.getImgUrl());
				needUpdate = true;
			}

			if (book.getAuthor() != null)
			{
				existBook.setAuthor(book.getAuthor());
				needUpdate = true;
			}

			if (book.getTheme() != null)
			{
				existBook.setTheme(book.getTheme());
				needUpdate = true;
			}

			if (needUpdate)
			{
				booksRepository.save(existBook);
			}
		}
	}

	@DeleteMapping("/admin/books/{id}")
	public void deleteBook(@PathParam("id") Long id)
	{
		booksRepository.deleteById(id);
	}
}
