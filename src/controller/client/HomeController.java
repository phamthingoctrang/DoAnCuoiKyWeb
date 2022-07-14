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

import dao.BoardnewDAO;
import dao.ProductDAO;
import model.Boardnew;
import model.Product;


public class HomeController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	ProductDAO productDao = new ProductDAO();
	BoardnewDAO boardnewDao = new BoardnewDAO();
	DecimalFormat df = new DecimalFormat("#.000");
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Boardnew> boardnewList = boardnewDao.getAll();
		req.setAttribute("boardnewlist", boardnewList);
		// Product Rau củ quả
		List<Product> product_raucu= productDao.getProductById(1);
		req.setAttribute("product_raucu", product_raucu);	
		
		// Product hạt
		List<Product> product_hat= productDao.getProductById(2);
		req.setAttribute("product_hat", product_hat);	
		
		// Product trái cây
		List<Product> product_traicay= productDao.getProductById(3);
		req.setAttribute("product_traicay", product_traicay);	
		
		// Product mật ong
		List<Product> product_matong= productDao.getProductById(4);
		req.setAttribute("product_matong", product_matong);	
		
		// Product mới
		List<Product> product_new= productDao.getProductById(5);
		req.setAttribute("product_new", product_new);	
				
		// Product bán chạy
				List<Product> product_banchay= productDao.getProductById(6);
		req.setAttribute("product_banchay", product_banchay);	
		
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
		
		// Product giảm giá
		List<Product> product_sale= productDao.getProductById(7);
		req.setAttribute("product_sale", product_sale);	
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/client/index.jsp");
		dispatcher.forward(req, resp);
	}
}
