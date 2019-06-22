<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "model.SerchSelect" %>
<%
SerchSelect ss = (SerchSelect) session.getAttribute("ss");
%>
<%!
public void jspInit(){
	try{
		Class.forName("com.mysql.cj.jdbc.Driver");
	}catch(Exception e){
		e.printStackTrace();
	}
}
%>
<%@ page import = "java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>検索結果だぜうぇいうぇい</title>
</head>
<body>
<p>検索結果だぜうぇいうぇい</p>
<p><%=ss.getKeyword() %></p>
<table border='1'><tr><th>ID</th><th>商品名</th><th>価格</th></tr>
<%
	Connection conn = null;
	Statement stmt = null;

	try{
		conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:8889/docoTsubu", "satoshi", "ktud3104");

		stmt = conn.createStatement();

		String sql =
				"select * from product where name like ?";
		PreparedStatement pStmt = conn.prepareStatement(sql);
		pStmt.setString(1,"%"+ss.getKeyword()+"%");
				ResultSet rs = pStmt.executeQuery();

		while(rs.next()){
%>
	<tr>
	<td><%=rs.getInt("id") %></td>
	<td><a href="/EC/ProductDetails?name=<%=rs.getString("name")%>"><%=rs.getString("name") %></a></td>
	<td><%=rs.getInt("price") %></td>
	</tr>
<%
		}
	}catch(Exception e){
		e.printStackTrace();
	}finally {
		if(conn != null) {
			try {
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
%>
</table>
</body>
</html>