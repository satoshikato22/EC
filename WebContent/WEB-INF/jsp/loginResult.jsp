<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "entity.loginUser" %>
<%
loginUser lu = (loginUser) session.getAttribute("loginUser");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログインの結果</title>
</head>
<body>
<p>こんにちは<%=lu.getName() %>さん</p>
</body>
</html>