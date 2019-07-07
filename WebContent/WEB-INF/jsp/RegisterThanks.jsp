<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%!
public void jspInit(){
	try{
		Class.forName("com.mysql.cj.jdbc.Driver");
	}catch(Exception e){
		e.printStackTrace();
	}
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録完了フォーム</title>
</head>
<body>
<p>ユーザー登録完了しました</p>
<table border='1'><tr><th>ID</th><th>名前</th><th>Pass</th><th>mail></th><th>住所</th></tr>
<%
	Connection conn = null;
	Statement stmt = null;
	try {
        // データベースに接続するConnectionオブジェクトの取得
        conn = DriverManager.getConnection(
		  "jdbc:mysql://localhost:8889/EC", "admin", "admin");
        // データベース操作を行うためのStatementオブジェクトの取得
        stmt = conn.createStatement();
        // SQL()を実行して、結果を得る
        String sql = "SELECT * FROM userinfo";
        PreparedStatement pStmt = conn.prepareStatement(sql);
        ResultSet rs = pStmt.executeQuery();
        // 得られた結果をレコードごとに表示
        while (rs.next()) {
%>
		<tr>
		<td><%=rs.getString("userid") %></td>
		<td><%=rs.getString("name") %></td>
		<td><%=rs.getString("pass") %></td>
		<td><%=rs.getString("mail") %></td>
		<td><%=rs.getString("address") %></td>
		</tr>
<%
        }
	}catch(Exception e){
		e.printStackTrace();
	}
%>
	</table>
	<%-- <a href="/EC/TOP.jsp">戻る</a> --%>
	<form action="/EC/FrontController" method="post">
	<button type="submit" name="targetId" value="GOTO_TOP">戻る</button>
	</form>
</body>
</html>