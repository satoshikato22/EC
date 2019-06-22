package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.loginUser;
import model.loginUserLogic;

/**
 * Servlet implementation class LoginUser
 */
@WebServlet("/LoginUser")
public class LoginUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
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
			RequestDispatcher dispatcher =
					request.getRequestDispatcher("/WEB-INF/jsp/loginResult.jsp");
			dispatcher.forward(request,response);
		}else {
			RequestDispatcher dispatcher =
					request.getRequestDispatcher("/WEB-INF/jsp/loginError.jsp");
			dispatcher.forward(request,response);
		}
	}

}
