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
	      String sql = "select mail from userinfo where mail = ?";
	      PreparedStatement pStmt = conn.prepareStatement(sql);
	      //pStmt.setString(1,u.getPass());
          pStmt.setString(1,u.getMail());

          ResultSet rs = pStmt.executeQuery();

         // String pass = null;
          String mail = null;


          while(rs.next()) {

        	// pass = rs.getString("pass");
        	 mail = rs.getString("mail");
        	 if(mail.equals(u.getMail())) {
        		 u.setSelectbool(false);
        	 }
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
