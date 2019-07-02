package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.User;

public class RegisterSelect {
	public void select(User u) {
		Connection conn = null;
	    try {
	      // JDBCドライバを読み込み
	      Class.forName("com.mysql.cj.jdbc.Driver");

	      // データベースへ接続
	      conn = DriverManager.getConnection(
	    		  "jdbc:mysql://localhost:8889/EC", "admin", "admin");

	      // SELECT文を準備
	      String sql = "select pass,mail from userinfo where pass = ? and mail = ?";
	      PreparedStatement pStmt = conn.prepareStatement(sql);
	      pStmt.setString(1,u.getPass());
          pStmt.setString(2,u.getMail());

          ResultSet rs = pStmt.executeQuery();

          String pass = null;


          while(rs.next()) {

        	 pass = rs.getString("pass");
          }
          if(pass != null) {
        	  u.setSelectbool(false);
          }else {
        	  u.setSelectbool(true);

          }

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
