package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import entity.SerchSelect;

public class SearchAction implements Action
{
	@Override
	public String execute ( HttpServletRequest request )
	{
		// 遷移先ページ
		String transitionPage = null;

		String keyword = request.getParameter("keyword");

		SerchSelect ss = new SerchSelect();
		ss.setKeyword(keyword);

		HttpSession session = request.getSession();
		session.setAttribute("ss", ss);

		transitionPage = "/WEB-INF/jsp/serchResult.jsp";

		return transitionPage;
	}
}
