package com.devcher.bookstore.books;

import javax.persistence.*;

@Entity
public class Books
{
	@Id
	private Long id;

	private String name;

	@ManyToOne
	@JoinColumn(name = "author", table = "authors")
	private Authors author;

	private String imgUrl;

	private Integer price;

	private String description;

	@ManyToOne
	@JoinColumn(name = "theme", table = "themes")
	private Themes theme;

	public Books()
	{
	}

	public Books(Long id, String name, Authors author, String imgUrl, Integer price, String description, Themes theme)
	{
		this.id = id;
		this.name = name;
		this.author = author;
		this.imgUrl = imgUrl;
		this.price = price;
		this.description = description;
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

	public Authors getAuthor()
	{
		return author;
	}

	public void setAuthor(Authors author)
	{
		this.author = author;
	}

	public String getImgUrl()
	{
		return imgUrl;
	}

	public void setImgUrl(String imgUrl)
	{
		this.imgUrl = imgUrl;
	}

	public Integer getPrice()
	{
		return price;
	}

	public void setPrice(Integer price)
	{
		this.price = price;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public Themes getTheme()
	{
		return theme;
	}

	public void setTheme(Themes theme)
	{
		this.theme = theme;
	}
}
