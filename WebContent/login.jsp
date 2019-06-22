<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン/ユーザー登録ページ</title>
</head>
<body>
<p>ログインフォーム</p>
<form action="/EC/LoginUser" method="post">
 メールアドレス:<input type="text" name="mail"><br>
 パスワード:<input type="password" name="pass"><br>
 <input type="submit" value="ログイン">
 </form>
 <p>-------------------------------------------------------------------</p>
 <p>ユーザー登録</p>
 <a href="/EC/RegisterUser">ユーザー登録する</a>
</body>
</html>