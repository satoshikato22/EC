package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegisterDAO {
	public boolean insert(String name,String pass,String mail,String address) {
		Connection conn = null;
	    try {
	      // JDBCドライバを読み込み
	      Class.forName("com.mysql.cj.jdbc.Driver");

	      // データベースへ接続
	      conn = DriverManager.getConnection(
	    		  "jdbc:mysql://localhost:8889/docoTsubu", "satoshi", "ktud3104");

	      // SELECT文を準備
	      
	      PreparedStatement pStmt = conn.prepareStatement("select ?,? from userinfo");
	      pStmt.setString(1,mail);
          pStmt.setString(2,pass);

          ResultSet rs = pStmt.executeQuery();

          String Pass = null;
          String Mail = null;

          while(rs.next()) {
        	 Mail = rs.getString("mail");
        	 Pass = rs.getString("pass");
          }
          if(Mail != mail) {
        	  return false;
          }
          if(Pass != pass) {
        	  return false;
          }

          else {
        	 pStmt =
        	conn.prepareStatement("insert into userinfo(userid,name,pass,mail,address)values(null,?,?,?,?)");
        	 pStmt.setString(1, name);
        	 pStmt.setString(2, pass);
        	 pStmt.setString(3, mail);
        	 pStmt.setString(4, address);
        	 pStmt.executeUpdate();
        	 conn.commit();
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
	    return true;
	}
}
