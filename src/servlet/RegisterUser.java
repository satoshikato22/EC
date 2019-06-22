package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import model.UserLogic;

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

		User u = new User();
		u.setName(name);
		u.setPass(pass);
		u.setMail(mail);
		u.setAddress(address);

		UserLogic ul = new UserLogic();
		ul.execute(u);

		if(u.getIsbool()) {
			session.setAttribute("user", u);

			RequestDispatcher dispatcher =
					request.getRequestDispatcher("/WEB-INF/jsp/registerConfirm.jsp");
			dispatcher.forward(request,response);
		}else {
			session.setAttribute("user", u);
			RequestDispatcher dispatcher =
					request.getRequestDispatcher("/WEB-INF/jsp/registerError.jsp");
			dispatcher.forward(request,response);
		}
	}

}
