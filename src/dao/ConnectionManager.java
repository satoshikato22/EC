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
     * データベースのConnectionを取得する。
     * @return コネクション
     */
    public Connection getConnection () throws SQLException
    {
        return DriverManager.getConnection ( URL, USER, PASSWORD );
    }
}
