<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規ユーザー登録</title>
</head>
<body>
<p>新規ユーザー登録</p>
<form action="/EC/RegisterUser" method="post">
ユーザー名:<input type="text" name="name"><br>
パスワード:<input type="text" name="text"><br>
パスワード確認:<input type="password" name="pass"><br>
メールアドレス:<input type="text" name="mail"><br>
住所:<p><textarea name="address" cols="30" rows="5"></textarea></p><br>
<a href="/EC/Login">戻る</a>
<input type="submit" value="次へ">
</form>
</body>
</html>