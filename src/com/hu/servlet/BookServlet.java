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
		out.print("ȫ���鼮<br/>");
		
		for (Map.Entry<String, Book> book: books.entrySet()) {
			
			String url=request.getContextPath()+"/AddShoppingCart?id="+book.getKey();
			out.write("<a href='"+ url+"'>"+book.getValue().getName()+"   "+book.getValue().getAuthor()+"  "+book.getValue().getPrice()+"</a><br/>");
			
			
		}
		String loourl=request.getContextPath()+"/LookCart";
		out.write("<a href=''>��ӹ��ﳵ</a><br>");
		out.write("<a href='"+loourl+"'>�鿴���ﳵ</a><br>");
		out.write("<a href=''>ɾ�����ﳵ</a>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
