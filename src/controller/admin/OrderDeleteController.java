package controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TransactionDAO;


public class OrderDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TransactionDAO transactionDao = new TransactionDAO();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		transactionDao.delete(id);
		resp.sendRedirect(req.getContextPath() + "/admin/order/list");
	}
}
