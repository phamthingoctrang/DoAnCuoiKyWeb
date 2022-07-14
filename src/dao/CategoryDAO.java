package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionDB;
import model.Category;

public class CategoryDAO extends ConnectionDB{
	public void insert(Category category) {
		String sql = "INSERT INTO category(name) VALUES (?)";
		new ConnectionDB();
		Connection con = ConnectionDB.getConnect();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, category.getName());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void edit(Category category) {
		String sql = "UPDATE category SET name = ? WHERE id = ?";
		new ConnectionDB();
		Connection con = ConnectionDB.getConnect();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, category.getName());
			ps.setString(2, category.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	public Category get(int id) {
		String sql = "SELECT * FROM category WHERE id = ? ";
		new ConnectionDB();
		Connection con = ConnectionDB.getConnect();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Category category = new Category();

				category.setId(rs.getString("id"));
				category.setName(rs.getString("name"));
				return category;

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Category get(String name) {
		return null;
	}

	public List<Category> getAll() {
		List<Category> categories = new ArrayList<Category>();
		String sql = "SELECT * FROM category";
		Connection conn = ConnectionDB.getConnect();

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Category category = new Category();

				category.setId(rs.getString("id"));
				category.setName(rs.getString("name"));
				categories.add(category);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return categories;
	}

	public void delete(String id) {
		System.out.println("Id :"+ id);
		String sql = "DELETE FROM category WHERE id = ?";
		new ConnectionDB();
		Connection conn = ConnectionDB.getConnect();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Category> getCateByProduct(int id) {
		List<Category> products_cate = new ArrayList<Category>();
		String sql = "select category.name from category,product where category.id = product.category_id and product.id = ?";
		Connection conn = ConnectionDB.getConnect();
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Category catagory_product = new Category();
				catagory_product.setName(rs.getString("name"));
				products_cate.add(catagory_product);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return products_cate;
	}

}
