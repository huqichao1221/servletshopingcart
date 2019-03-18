package com.hu.servlet;

import java.io.IOException;
import java.io.ObjectOutput;
import java.io.PrintWriter;
import java.util.Map;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

import com.hu.jdbc.service;
import com.hu.bean.Book;

/**
 * Servlet implementation class BookServlet
 */
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Content-type", "text/html;charset=UTF-8");

		response.setCharacterEncoding("UTF-8");
		Map<String, Book> books= service.findBooksAll();
		
		PrintWriter out= response.getWriter();
		out.print("全部书籍<br/>");
		
		for (Map.Entry<String, Book> book: books.entrySet()) {
			
			String url=request.getContextPath()+"/AddShoppingCart?id="+book.getKey();
			out.write("<a href='"+ url+"'>"+book.getValue().getName()+"   "+book.getValue().getAuthor()+"  "+book.getValue().getPrice()+"</a><br/>");
			
			
		}
		String loourl=request.getContextPath()+"/LookCart";
		out.write("<a href=''>添加购物车</a><br>");
		out.write("<a href='"+loourl+"'>查看购物车</a><br>");
		out.write("<a href=''>删除购物车</a>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
