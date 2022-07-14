package controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ReviewDAO;

public class ReviewDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ReviewDAO reviewDao = new ReviewDAO();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		reviewDao.delete(Integer.parseInt(id));
		resp.sendRedirect(req.getContextPath() + "/admin/review/list");
	}

}
