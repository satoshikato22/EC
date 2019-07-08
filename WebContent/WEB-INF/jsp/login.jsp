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
<form action="/EC/FrontController" method="post">
 メールアドレス:<input type="text" name="mail"><br>
 パスワード:<input type="password" name="pass"><br>
 <button type="submit" name="targetId" value="LOGIN">ログイン</button>
 </form>
 <p>-------------------------------------------------------------------</p>
 <p>ユーザー登録</p>
 <form action="/EC/FrontController" method="post">
 <button type="submit" name="targetId" value="GOTO_ACC_REGIST">ユーザー登録する</button>
 </form>
</body>
</html>