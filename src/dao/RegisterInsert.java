package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.User;

public class RegisterInsert {
	public void insert(User u) {
		Connection conn = null;
	    try {
	      // JDBCドライバを読み込み
	      Class.forName("com.mysql.cj.jdbc.Driver");

	      // データベースへ接続
	      conn = DriverManager.getConnection(
	    		  "jdbc:mysql://localhost:8889/EC", "admin", "admin");

	      // SELECT文を準備
	      String sql = "insert into userinfo (userid,name,pass,mail,address) values(null,?,?,?,?)";
	      PreparedStatement pStmt = conn.prepareStatement(sql);
	      pStmt.setString(1,u.getName());
          pStmt.setString(2,u.getPass());
          pStmt.setString(3,u.getMail());
          pStmt.setString(4,u.getAddress());
          pStmt.executeUpdate();
          conn.commit();

	    } catch (SQLException e) {
	      e.printStackTrace();
	    } catch (ClassNotFoundException e) {
	      e.printStackTrace();
	    } finally {
	      // データベース切断
	      if (conn != null) {
	        try {
	          conn.close();
	        } catch (SQLException e) {
	          e.printStackTrace();
	        }
	      }
	      }
	   	}
}
