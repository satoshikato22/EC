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
<form action="/EC/FrontController" method="post">
<input type="text" name="keyword">
<button type="submit" name="targetId" value="SEARCH">検索</button><br>
</form>
<!-- 下記は適当,<a>タグでいいかなー？ -->
<form action="/EC/FrontController" method="post">
<button type="submit" name="targetId" value="GOTO_LOGIN">ログイン/ユーザー登録</button>
<button type="submit" name="targetId" value="GOTO_CART">カート</button>
</form>
<h1>このWEBサイトは、お寿司専門のECサイトです</h1>
</body>
</html>