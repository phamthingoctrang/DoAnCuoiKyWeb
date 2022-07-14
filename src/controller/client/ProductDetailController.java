package controller.client;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoryDAO;
import dao.ProductDAO;
import dao.ReviewDAO;
import model.Category;
import model.Product;
import model.Review;



public class ProductDetailController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		CategoryDAO cateDao = new CategoryDAO();
	ProductDAO productDao = new ProductDAO();
	ReviewDAO reviewDao = new ReviewDAO();
	DecimalFormat df = new DecimalFormat("#.000");
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		Product detail_product = productDao.get(Integer.parseInt(id));
		req.setAttribute("detail_product", detail_product);
		
		List<Category> name_cate_of_product = cateDao.getCateByProduct(Integer.parseInt(id));
		req.setAttribute("name_cate_of_product", name_cate_of_product);
		
		String idCate = detail_product.getCategory_id();
		
		List<Product> productListCate = productDao.getProductById(Integer.parseInt(idCate));
		
		req.setAttribute("productById", productListCate);
		
		List<Review> reviewById = reviewDao.getReviewById(Integer.parseInt(id));
		req.setAttribute("reviewbyid", reviewById);
		
		List<Product> productList = productDao.getAll();
		req.setAttribute("productlist", productList);	
		//Giá giảm
		List<Product> productsList1 = new ArrayList<Product>();
		for(Product product: productList)
		{
			Product product1 = productDao.get(Integer.parseInt(product.getId()));
			product1.setPrice(String.valueOf(df.format(Double.parseDouble(product.getPrice()) * (1 - (Double.parseDouble(product.getDiscount())/100)))));
			productsList1.add(product1);
			
		}

		req.setAttribute("productlist1", productsList1);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/client/product-detail.jsp");
		dispatcher.forward(req, resp);
	}

}
