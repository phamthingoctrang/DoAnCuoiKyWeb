package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionDB;
import model.Ordered;

public class OrderedDAO extends ConnectionDB{
	public void insert(Ordered ordered) {
		String sql = "INSERT INTO ordered(product_id, transaction_id,qty) VALUES (?, ?, ?)";
		Connection con = ConnectionDB.getConnect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, Integer.parseInt(ordered.getProduct_id()));
			ps.setInt(2, Integer.parseInt(ordered.getTransaction_id()));
			ps.setInt(3, ordered.getQty());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void edit(Ordered ordered) {
		
	}

	public void delete(String id) {
		
	}

	public Ordered get(int id) {
		return null;
	}

	public Ordered get(String name) {
		return null;
	}

	public List<Ordered> getAll() {
		List<Ordered> ordereds = new ArrayList<Ordered>();
		String sql = "SELECT * FROM ordered";
		Connection con = ConnectionDB.getConnect();
		try {
			PreparedStatement ps = con.prepareStatement(sql); 
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				Ordered ordered = new Ordered();
				ordered.setId(rs.getString("id"));
				ordered.setProduct_id(rs.getString("product_id"));
				ordered.setTransacsion_id(rs.getString("transaction_id"));
				ordered.setQty(Integer.parseInt(rs.getString("qty")));
				ordereds.add(ordered);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ordereds;
	}

}
