package controller.admin; 
 
import java.io.IOException; 
 
import javax.servlet.RequestDispatcher; 
import javax.servlet.ServletException; 
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse;

import dao.AdminDAO;
import model.Admin;
//import service.AdminService;

import java.util.List; 
 
 
/** 
 * Servlet implementation class CategoryListController 
 */ 

public class AdminListController extends HttpServlet { 
	/** 
	 *  
	 */ 
	private static final long serialVersionUID = 1L; 
	AdminDAO adminDao = new AdminDAO();
	@Override 
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { 
		List<Admin> adminList = adminDao.getAll();
		req.setAttribute("adminlist", adminList); 
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/admin.jsp"); 
		dispatcher.forward(req, resp); 
	} 
}