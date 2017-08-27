<%@page import="org.apache.jasper.tagplugins.jstl.core.Import"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.Map" %>
<%@page import="java.util.HashMap"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Maven</h1>

<% 
	Map<Integer, String> colors = new HashMap<>();
	colors.put(1, "Red");
	colors.put(2, "Blue");
	colors.put(3, "White");
	colors.put(4, "Pink");
	request.setAttribute("colors",colors);
%>
<form method="post" action="Sample">
	<input type="submit" value="submit" />
	
</form>
</body>
</html>