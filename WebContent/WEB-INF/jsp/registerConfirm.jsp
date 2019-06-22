<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page  import="model.User"%>
<%
User u = (User) session.getAttribute("user");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録内容確認</title>
</head>
<body>
<p>こちらの内容で間違いないでしょうか？</p>
<form action="/EC/RegisterResult" method="post">
ユーザー名:<input type="text" value=<%=u.getName() %> name="name"><br>
パスワード:<input type="text" value=<%=u.getPass() %> name="pass"><br>
メールアドレス:<input type="text" value=<%=u.getMail() %> name="mail"><br>
住所:<p><textarea name="address" cols="30" rows="5"><%=u.getAddress() %></textarea></p><br>
<input type="submit" value="登録">
</form>
</body>
</html>