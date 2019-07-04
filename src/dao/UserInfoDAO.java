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
	 */
	public UserInfo selectUserInfoByUserId ( int userId )
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
		catch ( SQLException exception )
		{
			e.printStackTrace ();
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
			catch ( SQLException exception )
			{
				e.printStackTrace ();
			}
		}

		return userInfo;
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
