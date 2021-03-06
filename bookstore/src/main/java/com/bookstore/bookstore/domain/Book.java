package com.bookstore.bookstore.domain;
import javax.persistence.Entity;	
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Book {
		//Generates ID automatically
		@Id
	    @GeneratedValue(strategy=GenerationType.AUTO)
		//Creates attributes ID, ISBN, Price, Year, Author, Title
	    private Long id;
	 	private String isbn;
	    private int price;
	    private int year;
	    private String author;
	    private String title;
	    
	    //Set Many to One relationship in H2/DB 
	    @ManyToOne
		// ignore one to many links in repository
	    @JsonIgnore
	    //create join column with category id
	    @JoinColumn(name = "categoryid")
	    private Category category;
	    
	    //Book class methods
	    public Book() {}

		public Book(String title, String author, int year, String isbn, int price, Category category) {
			super();
			this.isbn = isbn;
			this.price = price;
			this.year = year;
			this.author = author;
			this.title = title;
			this.category = category;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getIsbn() {
			return isbn;
		}
		public void setIsbn(String isbn) {
			this.isbn = isbn;
		}
		public int getPrice() {
			return price;
		}
		public void setPrice(int price) {
			this.price = price;
		}
		public int getYear() {
			return year;
		}
		public void setYear(int year) {
			this.year = year;
		}
		public String getAuthor() {
			return author;
		}
		public void setAuthor(String author) {
			this.author = author;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		
		public Category getCategory() {
			return category;
		}

		public void setCategory(Category category) {
			this.category = category;
		}
		
		@Override
		public String toString() {
			if (this.category != null)
			return "Book [id=" + id + ", isbn=" + isbn + ", price=" + price + ", year=" + year + ", author=" + author
					+ ", title=" + title + ", category=" + this.getCategory() + "]";
			else
			    return "Book [id=" + id + ", isbn=" + isbn + ", price=" + price + ", year=" + year + ", author=" + author
			         + ", title=" + title + "]";
		}
		
}
