package controller.client;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connection.ConnectionDB;
import dao.RegisterDAO;
import model.User;



/**
 * Servlet implementation class RegistrationController
 */

public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegistrationController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/view/client/register.jsp");
    	dispatcher.forward(request, response);
    }
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String name = request.getParameter("name");
		String created = request.getParameter("created");

		User user = new User(username, password, email, phone, name, created);

		RegisterDAO register = new RegisterDAO(ConnectionDB.getConnect());
		if (register.RegisterUser(user)) 
		{
			request.setAttribute("Message", "Bạn đã tạo tài khoàn thành công.");
			RequestDispatcher rd = request.getRequestDispatcher("/view/client/login.jsp");
			rd.forward(request, response);
		} else {
			request.setAttribute("errMessage", "Tạo tài khoản thất bại. Hãy thử lại !!!");
			RequestDispatcher rd = request.getRequestDispatcher("/view/client/register.jsp");
			rd.forward(request, response);
		}
	}
}
