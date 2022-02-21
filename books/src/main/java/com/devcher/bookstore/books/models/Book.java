package com.devcher.bookstore.books.models;

import javax.persistence.*;

@Entity
public class Book
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private String description;
	private Integer price;
	private String imgUrl;

	@ManyToOne
	@JoinColumn(name = "author")
	private Author author;

	@ManyToOne
	@JoinColumn(name = "theme")
	private Theme theme;


	public Book()
	{
	}

	public Book(Long id, String name, String description, Integer price, String imgUrl, Author author, Theme theme)
	{
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.imgUrl = imgUrl;
		this.author = author;
		this.theme = theme;
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public Integer getPrice()
	{
		return price;
	}

	public void setPrice(Integer price)
	{
		this.price = price;
	}

	public String getImgUrl()
	{
		return imgUrl;
	}

	public void setImgUrl(String imgUrl)
	{
		this.imgUrl = imgUrl;
	}

	public Author getAuthor()
	{
		return author;
	}

	public void setAuthor(Author author)
	{
		this.author = author;
	}

	public Theme getTheme()
	{
		return theme;
	}

	public void setTheme(Theme theme)
	{
		this.theme = theme;
	}
}
