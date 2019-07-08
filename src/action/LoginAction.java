package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import entity.loginUser;
import logic.loginUserLogic;

public class LoginAction implements Action
{
	@Override
	public String execute ( HttpServletRequest request )
	{
		// 遷移先ページ
		String transitionPage = null;

		String pass = request.getParameter("pass");
		String mail = request.getParameter("mail");

		HttpSession session = request.getSession();

		loginUser lu = new loginUser();
		lu.setPass(pass);
		lu.setMail(mail);

		loginUserLogic lul = new loginUserLogic();
		lul.execute(lu);
		if(lu.getIsbool()) {
			session.setAttribute("loginUser", lu);
			transitionPage = "/WEB-INF/jsp/loginResult.jsp";
		}else {
			transitionPage = "/WEB-INF/jsp/loginError.jsp";
		}

		return transitionPage;
	}
}
