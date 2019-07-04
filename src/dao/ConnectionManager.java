package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * SQLとのコネクションを取得するためのクラス。
 */
public class ConnectionManager
{
    /** データベースアクセス用URL */
    private static final String URL;

    /** データベースアクセス用ユーザ名 */
    private static final String USER;

    /** データベースアクセス用パスワード */
    private static final String PASSWORD;

	/**
	 * データベースアクセスの設定を行う。
	 * @param データベースアクセス用URL
	 * @param データベースアクセス用ユーザ名
	 * @param データベースアクセス用パスワード
	 */
	public ConnectionManager ( String url, String user, String password )
	{
		URL = url;
		USER = user;
		PASSWORD = password;
	}

    /**
     * データベースのConnectionを取得する。
     * @return コネクション
     */
    public Connection getConnection () throws SQLException
    {
        return DriverManager.getConnection ( URL, USER, PASSWORD );
    }
}
