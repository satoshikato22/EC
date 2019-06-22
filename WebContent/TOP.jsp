<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TOP画面</title>
</head>
<body>
<h1>TOP画面</h1>
<p>検索キーワードを入力してください</p>
<form action="/EC/Serch" method="post">
<input type="text" name="keyword">
<input type="submit" value="検索"><br>
</form>
<!-- 下記は適当,<a>タグでいいかなー？ -->
<a href="/EC/Login">ログイン/ユーザー登録</a><br>
<a href="/EC/Cart.jsp">カート</a><br>
<h1>このWEBサイトは、お寿司専門のECサイトです</h1>
</body>
</html>