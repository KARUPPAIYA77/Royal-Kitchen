<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import ="com.tapfoods.model.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home.jsp</title>
</head>
<body>
<% User user =(User)session.getAttribute("user"); %>
<%if(user!=null) {%>
<h3>Welcome back<%out.println(user.getUsername()); }%></h3>
<%if(user==null) {%>
<h3>You haven`t Logged In</h3>
<%}%>
</body>
</html>