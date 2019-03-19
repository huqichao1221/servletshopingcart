<%@page import="java.util.ArrayList"%>
<%@page import="com.hu.bean.Student"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jstl核心标签库</title>
</head>
<body>
 		<%
 			pageContext.setAttribute("name", "husir");
 		%>
 		el:${name}
 		<c:out value="${name}"></c:out>
 		
 		<%
 			
 			Map<Integer,String> map=new HashMap<Integer,String>();
 			map.put(1, "hu");
 			map.put(2, "wang");
 			map.put(3, "zhang");
 			map.put(4, "zhou");
 			
 			request.setAttribute("map", map);
 		%>
 		
 		<c:forEach items="${map}" var="map">
 		key:${map.key}--user:${map.value}<br/>
 		</c:forEach>
 		
 		<%
 		
 			List<Student> list=new ArrayList<>();
 		
 			list.add(new Student("hu","28"));
 			list.add(new Student("zhang","36"));
 			list.add(new Student("zhang","32"));
 			list.add(new Student("wang","30"));
 			pageContext.setAttribute("list", list);
 		
 		%>
 		<table border="2">
 		<tr>
 			<td>序列</td>
 			<td>姓名</td>
 			<td>年纪</td>
 		</tr>
 		<c:forEach  items="${list}" var="student" varStatus="obj">
 		<tr style="background-color: ${obj.index%2==0?'orange':'green'}">
 			<td>${obj.count}</td>
 			<td>${student.name}</td>
 			<td>${student.age}</td>
 		</tr>
 		</c:forEach>
 		</table>
 		
 		
</body>
</html>