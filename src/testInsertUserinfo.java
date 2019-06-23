
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class testInsertUserinfo {
	public static void main(String[] args) {
		Connection conn = null;
	    try {
	      // JDBCドライバを読み込み
	      Class.forName("com.mysql.cj.jdbc.Driver");

	      // データベースへ接続
	      conn = DriverManager.getConnection(
	    		  "jdbc:mysql://localhost:8889/EC", "admin", "admin");

	      // SELECT文を準備
	      String sql = "insert into userinfo(userid,name,pass,mail,address) values(null,あいうえお,atud3104,aiueo@abcd.com,神奈川県鎌倉市大船)";
	      PreparedStatement pStmt = conn.prepareStatement(sql);

	      // SELECTを実行し、結果表（ResultSet）を取得
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
