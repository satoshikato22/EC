package logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.loginUser;

public class loginUserLogic {
	public void execute(loginUser lu) {
		Connection conn = null;
	    try {
	      // JDBCドライバを読み込み
	      Class.forName("com.mysql.cj.jdbc.Driver");

	      // データベースへ接続
	      conn = DriverManager.getConnection(
	    		  "jdbc:mysql://localhost:8889/EC", "admin", "admin");

	      // SELECT文を準備
	      String sql = "select * from userinfo where pass = ? and mail = ?";
	      PreparedStatement pStmt = conn.prepareStatement(sql);
	      pStmt.setString(1,lu.getPass());
          pStmt.setString(2,lu.getMail());

          ResultSet rs = pStmt.executeQuery();

          String pass = null;
          String mail = null;
          String name = null;
          while(rs.next()) {
        	  pass = rs.getString("pass");
        	  mail = rs.getString("mail");
        	  name = rs.getString("name");
          }
          if(pass == null || mail == null) {
        	  lu.setIsbool(false);
          }else {
        	  lu.setIsbool(true);
        	  lu.setName(name);
          }

	      // SELECTを実行し、結果表（ResultSet）を取得


	      // 結果表に格納されたレコードの内容を表示

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
