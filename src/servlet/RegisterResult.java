package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.RegisterInsert;
import dao.RegisterSelect;
import model.User;
import model.UserLogic;

/**
 * Servlet implementation class RegisterResult
 */
@WebServlet("/RegisterResult")
public class RegisterResult extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterResult() {
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

		RegisterSelect rs = new RegisterSelect();
		try {
			rs.select(u);
		} catch (Exception e) {
			e.printStackTrace();
		}


		if(u.getIsbool()) {
			session.setAttribute("user", u);
			RegisterInsert ri = new RegisterInsert();
			ri.insert(u);
			RequestDispatcher dispatcher =
					request.getRequestDispatcher("/RegisterThanks.jsp");
			dispatcher.forward(request,response);
		}else {
			session.setAttribute("user", u);
			RequestDispatcher dispatcher =
					request.getRequestDispatcher("/registerDuplicateError.jsp");
			dispatcher.forward(request,response);
		}
	}


	}

