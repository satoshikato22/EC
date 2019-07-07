package action;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.ConnectionManager;
import dao.UserInfoDAO;
import entity.UserInfo;
import logic.UserLogic;

public class AccountRegistrationAction implements Action
{
	@Override
	public String execute ( HttpServletRequest request )
	{
		// 遷移先ページ
		String transitionPage = null;

		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		String mail = request.getParameter("mail");
		String address = request.getParameter("address");

		HttpSession session = request.getSession();
		session.removeAttribute("user");

		UserInfo userInfo = new UserInfo ();
		userInfo.setName ( name );
		userInfo.setPass ( pass );
		userInfo.setMail ( mail );
		userInfo.setAddress ( address );

		UserLogic ul = new UserLogic();

		if(ul.execute(userInfo)) {

			session.setAttribute("user", userInfo);

			// DBにユーザ情報登録
			ConnectionManager conManager = new ConnectionManager ( "jdbc:mysql://localhost:8889/EC", "admin", "admin" );
			try
			{
				UserInfoDAO userInfoDao = new UserInfoDAO ( conManager.getConnection () );
				userInfoDao.insertUserInfo ( userInfo );
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

			transitionPage = "/WEB-INF/jsp/RegisterThanks.jsp";

		}else {
			session.setAttribute("user", userInfo);
			transitionPage = "/WEB-INF/jsp/registerError.jsp";
		}

		return transitionPage;
	}
}
