package com.hu.jdbc;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import com.hu.bean.Book;

import javafx.geometry.Side;



public class service {

	private static Map<String, Book> books= new HashMap<>();
	
	public static Map<String, Book> findBooksAll() 
	{
		Connection connection;
		try {
			connection = jdbcuntil.getConnetion();
			String sql="select * from t_books";
			PreparedStatement statement=connection.prepareStatement(sql);
			ResultSet rSet=statement.executeQuery();
			while(rSet.next())
			{
				Book book= new Book();
				book.setId(Integer.parseInt(rSet.getString("id")) );
				book.setName(rSet.getString("name"));
				book.setAuthor(rSet.getString("author"));
				book.setPrice(new BigDecimal(rSet.getString("price"))  );
				books.put(rSet.getString("id"), book);
				
			//	System.out.println(rSet.getString("name"));
			}
			rSet.close();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		 
		
		
		return books;
	}
	
	
	public static Book FindBookById(String id)
	{
		
		System.out.println(id);
		Connection connection;
		Book  book= new Book();
		try {
			connection = jdbcuntil.getConnetion();
			String sql="select * from t_books where id=?";
			PreparedStatement statement=connection.prepareStatement(sql);
			statement.setString(1, id);
			ResultSet rSet=statement.executeQuery();
			while(rSet.next())
			{
				
				book.setId(Integer.parseInt(rSet.getString("id")) );
				book.setName(rSet.getString("name"));
				book.setAuthor(rSet.getString("author"));
				book.setPrice(new BigDecimal(rSet.getString("price"))  );
				books.put(rSet.getString("id"), book);
				
			System.out.println(rSet.getString("name")+id);
			}
			rSet.close();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return book;
	}
}
