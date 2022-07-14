package controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TransactionDAO;
import model.Transactions;


/**
 * Servlet implementation class OrderListController
 */

public class OrderListController extends HttpServlet {
	private static final long serialVersionUID = 1L; 
	TransactionDAO transactionDao = new TransactionDAO();

 
	@Override 
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { 
		List<Transactions> transactionList = transactionDao.getAll();
		req.setAttribute("order", transactionList); 
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/show-order.jsp"); 
		dispatcher.forward(req, resp); 
	} 

}
