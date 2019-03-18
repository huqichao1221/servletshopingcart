package com.hu.servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hu.bean.Book;
import com.hu.jdbc.service;
/**
 * Servlet implementation class LookCart
 */
public class LookCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Content-type", "text/html;charset=UTF-8");

		response.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		
		Map<String, Integer> books=(Map<String, Integer>) session.getAttribute("ShoppingCart");
		if (books==null) {
			
			response.setHeader("refresh", "2;url="+request.getContextPath()+"/BookServlet");
			return;
		}
			
		for(Map.Entry<String, Integer> book:books.entrySet() )
		{
			Book bookk=new Book();
			bookk=service.FindBookById(book.getKey());
			System.out.println(book.getKey());
			PrintWriter out= response.getWriter();
			out.write("书名"+bookk.getName()+"数量"+book.getValue()+"<br/>");
			out.write("购物车");
			
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
