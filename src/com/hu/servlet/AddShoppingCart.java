package com.hu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AddShoppingCart
 */
public class AddShoppingCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Content-type", "text/html;charset=UTF-8");

		response.setCharacterEncoding("UTF-8");
		
		String id= request.getParameter("id");
		HttpSession session = request.getSession();
		Map<String, Integer> map =	 (Map<String, Integer>) session.getAttribute("ShoppingCart");
		if (map==null) {
			 
			map = new HashMap<>();
			
				
		}
		if (map.get(id)==null) {
			System.out.println(id+"-------------");
			map.put(id, 1);
		}
		else
		{
			System.out.println(id+"**************");
			map.put(id, map.get(id)+1);
		}
		session.setAttribute("ShoppingCart", map);
		PrintWriter out= response.getWriter();
		out.write("添加购物车成功");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
