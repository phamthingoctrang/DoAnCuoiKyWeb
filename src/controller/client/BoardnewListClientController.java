package controller.client;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardnewDAO;
import model.Boardnew;


public class BoardnewListClientController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	BoardnewDAO boardnewDao = new BoardnewDAO();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Boardnew> boardnewList = boardnewDao.getAll();
		req.setAttribute("boardnewlist", boardnewList);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/client/blog-archive.jsp");
		dispatcher.forward(req, resp);
	}

}
