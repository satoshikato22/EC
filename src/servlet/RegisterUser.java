package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ConnectionManager;
import dao.UserInfoDAO;
import entity.UserInfo;
import logic.UserLogic;

/**
 * Servlet implementation class RegisterUser
 */
@WebServlet("/RegisterUser")
public class RegisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher =
				request.getRequestDispatcher("/WEB-INF/jsp/registerUser.jsp");
		dispatcher.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
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

			RequestDispatcher dispatcher =
					request.getRequestDispatcher("/WEB-INF/jsp/RegisterThanks.jsp");
			dispatcher.forward(request,response);

		}else {
			session.setAttribute("user", userInfo);
			RequestDispatcher dispatcher =
					request.getRequestDispatcher("/WEB-INF/jsp/registerError.jsp");
			dispatcher.forward(request,response);
		}
	}
}
