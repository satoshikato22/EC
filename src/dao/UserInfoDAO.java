package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.UserInfo;

/**
 * USERINFOテーブルとのCRUDを行うためのクラス。
 */
public class UserInfoDAO
{
	/** SQLのコネクション */
	private Connection connection;

	/**
	 * SQLのコネクションを設定する。
	 * @param SQLのコネクション
	 */
	public UserInfoDAO ( Connection connection )
	{
		setConnection ( connection );
	}

	/**
	 * USERINFOテーブルから、ユーザIDに該当する情報を検索する。
	 * @param ユーザID
	 * @return ユーザ情報
	 * @throws java.sql.SQLException SQL関連の例外を投げる
	 */
	public UserInfo selectUserInfoByUserId ( int userId ) throws SQLException
	{
		// ユーザ情報
		UserInfo userInfo = null;

		// データ取得の準備
		String sql = "SELECT USERID, NAME, PASS, MAIL, ADDRESS"
			+ " FROM USERINFO"
			+ " WHERE USERID = ?";
		PreparedStatement preStatement = null;
		ResultSet resultSet = null;

		try
		{
			// SQL文を動的に設定する
			preStatement = getConnection ().prepareStatement ( sql );
			preStatement.setString ( 1, userId );

			// 取得データをオブジェクトに設定する
			resultSet = preStatement.executeQuery ();
			if ( resultSet.next () )
			{
				int userId = resultSet.getString ( "USERID" );
				String name = resultSet.getString ( "NAME" );
				String pass = resultSet.getString ( "PASS" );
				String mail = resultSet.getString ( "MAIL" );
				String address = resultSet.getString ( "ADDRESS" );

				userInfo = new UserInfo ();
				userInfo.setUserId ( userId );
				userInfo.setName ( name );
				userInfo.setPass ( pass );
				userInfo.setMail ( mail );
				userInfo.setAddress ( address );
			}
		}
		finally
		{
			try
			{
				// 後処理
				if ( preStatement != null )
				{
					preStatement.close ();
				}
				if ( resultSet != null )
				{
					resultSet.close ();
				}
			}
		}

		return userInfo;
	}

	/**
	 * USERINFOテーブルから、メールアドレスに該当する情報を検索する。
	 * @param メールアドレス
	 * @return ユーザ情報
	 * @throws java.sql.SQLException SQL関連の例外を投げる
	 */
	public UserInfo selectUserInfoByMail ( String mail ) throws SQLException
	{
		// ユーザ情報
		UserInfo userInfo = null;

		// データ取得の準備
		String sql = "SELECT USERID, NAME, PASS, MAIL, ADDRESS"
			+ " FROM USERINFO"
			+ " WHERE MAIL = ?";
		PreparedStatement preStatement = null;
		ResultSet resultSet = null;

		try
		{
			// SQL文を動的に設定する
			preStatement = getConnection ().prepareStatement ( sql );
			preStatement.setString ( 1, mail );

			// 取得データをオブジェクトに設定する
			resultSet = preStatement.executeQuery ();
			if ( resultSet.next () )
			{
				int userId = resultSet.getString ( "USERID" );
				String name = resultSet.getString ( "NAME" );
				String pass = resultSet.getString ( "PASS" );
				String mail = resultSet.getString ( "MAIL" );
				String address = resultSet.getString ( "ADDRESS" );

				userInfo = new UserInfo ();
				userInfo.setUserId ( userId );
				userInfo.setName ( name );
				userInfo.setPass ( pass );
				userInfo.setMail ( mail );
				userInfo.setAddress ( address );
			}
		}
		finally
		{
			try
			{
				// 後処理
				if ( preStatement != null )
				{
					preStatement.close ();
				}
				if ( resultSet != null )
				{
					resultSet.close ();
				}
			}
		}

		return userInfo;
	}

	/**
	 * USERINFOテーブルに、ユーザ情報を登録する。
	 * @param ユーザ情報
	 * @return 登録結果 true:登録成功, false:登録失敗
	 * @throws java.sql.SQLException SQL関連の例外を投げる
	 */
	public boolean insertUserInfo ( UserInfo userInfo ) throws SQLException
	{
		// 登録結果 true:登録成功, false:登録失敗
		boolean hasRegistered = false;

		// データ取得の準備
		String sql = "INSERT INTO USERINFO ( USERID, NAME, PASS, MAIL, ADDRESS )"
			+ " VALUES ( NULL, ?, ?, ?, ? )"
		PreparedStatement preStatement = null;

		try
		{
			// SQL文を動的に設定する
			preStatement = getConnection ().prepareStatement ( sql );
			preStatement.setString ( 1, userInfo.getName () );
			preStatement.setString ( 2, userInfo.getPass () );
			preStatement.setString ( 3, userInfo.getMail () );
			preStatement.setString ( 4, userInfo.getAddress () );

			if ( 1 <= preStatement.executeUpdate () )
			{
				// 1件以上の更新がある場合
				hasRegistered = true;
			}
		}
		finally
		{
			try
			{
				// 後処理
				if ( preStatement != null )
				{
					preStatement.close ();
				}
			}
		}

		return hasRegistered;
	}

	/**
	 * SQLのコネクションを取得する。
	 * @return SQLのコネクション
	 */
	public Connection getConnection ()
	{
		return connection;
	}

	/**
	 * SQLのコネクションを設定する。
	 * @param SQLのコネクション
	 */
	public void setConnection ( Connection connection )
	{
		this.connection = connection;
	}
}
