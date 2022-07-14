package controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ReviewDAO;
import model.Review;


public class ReviewListController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	ReviewDAO reviewDao = new ReviewDAO();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Review> reviewList = reviewDao.getAll();
		req.setAttribute("reviewlist", reviewList);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/show-review.jsp");
		dispatcher.forward(req, resp);
	}
}
