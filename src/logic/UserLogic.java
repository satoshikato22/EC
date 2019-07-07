package logic;

import java.sql.SQLException;
import java.util.regex.Pattern;

import dao.ConnectionManager;
import dao.UserInfoDAO;
import entity.UserInfo;

public class UserLogic {
	public boolean execute(UserInfo userInfo) {
		// 判定結果
		boolean result = false;

		String pass = userInfo.getPass();
		if(Pattern.matches("(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])[a-zA-Z0-9]{8,}",pass)) {
			// メールアドレスの重複確認
			UserInfo resultUserInfo = null;
			ConnectionManager conManager = new ConnectionManager ( "jdbc:mysql://localhost:8889/EC", "admin", "admin" );
			try
			{
				UserInfoDAO userInfoDao = new UserInfoDAO ( conManager.getConnection () );
				resultUserInfo = userInfoDao.selectUserInfoByMail ( userInfo.getMail () );
			}
			catch ( SQLException e )
			{
				e.printStackTrace ();
			}
			finally
			{
				try
				{
					conManager.getConnection ().close ();
				}
				catch ( SQLException e )
				{
					e.printStackTrace ();
				}
			}

			if ( resultUserInfo == null )
			{
				result = true;
			}
			else
			{
				result = false;
			}

		}else {
			result = false;

		}
		return result;
	}
}
