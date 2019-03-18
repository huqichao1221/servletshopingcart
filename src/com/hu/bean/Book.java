package com.hu.bean;

import java.math.BigDecimal;

public class Book {

	
		 private int id;
		 private String name;
		 private String author;
		 private BigDecimal price;
			public int getId() {
				return id;
			}
			public void setId(int id) {
				this.id = id;
			}
			public String getName() {
				return name;
			}
			public void setName(String name) {
				this.name = name;
			}
			public String getAuthor() {
				return author;
			}
			public void setAuthor(String author) {
				this.author = author;
			}
			
			
			
			public BigDecimal getPrice() {
				return price;
			}
			public void setPrice(BigDecimal price) {
				this.price = price;
			}
			@Override
			public String toString() {
				return "Book [id=" + id + ", name=" + name + ", author=" + author + "]";
			}
	 
	 
}
