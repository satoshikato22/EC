package logic;

import java.sql.SQLException;
import java.util.regex.Pattern;

import dao.ConnectionManager;
import dao.UserInfoDAO;
import entity.User;
import entity.UserInfo;

public class UserLogic {
	public void execute(User u) {
		String pass = u.getPass();
		if(Pattern.matches("(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])[a-zA-Z0-9]{8,}",pass)) {
			// メールアドレスの重複確認
			UserInfo userInfo = null;
			ConnectionManager conManager = new ConnectionManager ( "jdbc:mysql://localhost:8889/EC", "admin", "admin" );
			try
			{
				UserInfoDAO userInfoDao = new UserInfoDAO ( conManager.getConnection () );
				userInfo = userInfoDao.selectUserInfoByMail ( u.getMail () );
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

			if ( userInfo == null )
			{
				u.setIsbool(true);
			}
			else
			{
				u.setIsbool(false);
			}

	}else {
		u.setIsbool(false);

	}
}
}
