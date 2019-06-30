<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "model.User" %>
<%
User u = (User) session.getAttribute("user");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録エラー</title>
</head>
<body>
<p>登録内容を確認してください</p>
<form action="/EC/RegisterUser" method="post">
ユーザー名:<input type="text" value=<%=u.getName() %> name="name"><br>
<p>パスワードは「英数字大文字小文字含めて8文字」以上にしてください。</p>
パスワード:<input type="text" value=<%=u.getText() %> name="text"><br>
パスワード確認:<input type="text" value=<%=u.getPass() %> name="pass"><br>
メールアドレス:<input type="text" value=<%=u.getMail() %> name="mail"><br>
住所:<p><textarea name="address" cols="30" rows="5" ><%=u.getAddress() %></textarea><br>
<input type="submit" value="登録">
</form>
</body>
</html>