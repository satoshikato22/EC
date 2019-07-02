package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.UserInfo;

/**
 * USERINFOテーブルとのCRUDを行う。
 */
public class UserInfoDAO
{
	private Connection connection;

	public UserInfoDAO ( Connection connection )
	{
		this.connection = connection;
	}

	/**
	 * USERINFOテーブルから、ユーザIDに該当する情報を検索する。
	 * @param ユーザID
	 * @return ユーザ情報
	 */
	public UserInfo selectUserInfoByUserId ( int userId )
	{
		UserInfo userInfo = null;

		String sql = "SELECT USERID, NAME, PASS, MAIL, ADDRESS"
			+ " FROM USERINFO"
			+ " WHERE USERID = ?";
		PreparedStatement preStatement = null;
		ResultSet resultSet = null;

		try
		{
			preStatement = connection.prepareStatement ( sql );
			preStatement.setString ( 1, userId );

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
}
