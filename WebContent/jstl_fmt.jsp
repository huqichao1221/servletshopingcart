<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		 Date d=new Date();
		pageContext.setAttribute("date", d);

	%>
	
	<fmt:formatDate value="${date}" pattern="yyyy-MM--dd hh:mm:ss"/>
	<fmt:formatDate value="${date}" var="obj" pattern="yyyy-MM--dd hh:mm:ss"/>
	time:${obj}
	
	<%
		String da="2017--05--25";
		pageContext.setAttribute("dated", da);
	
	%>
	
	<fmt:parseDate value="${dated }" pattern="yyyy--MM--dd"></fmt:parseDate>
</body>
</html>