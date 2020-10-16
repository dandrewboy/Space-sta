package com.spacesta.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import com.spacesta.models.Product;

public class ProductDaoImpl implements ProductDao {

  @Autowired
  DataSource datasource;

  @Autowired
  JdbcTemplate jdbcTemplate;

  //Adds a new product to the database.
  public int registerProduct(Product product) {
    String sql="insert into spacesta.products(productName, productDescription, productQuantity, productPrice) VALUES ('"+product.getProductName()+"','"+product.getProductDescription()+"',"+product.getProductQuantity()+","+product.getProductPrice()+")";  
    return jdbcTemplate.update(sql);
  }
  
  //Checks if the product name already exists in the database. 
  public boolean checkProduct(Product product) {
	  String sql="select * from spacesta.products where productName='" + product.getProductName() +"'";
	  List<Product> products = jdbcTemplate.query(sql, new ProductMapper());
	  if(products.size() > 0)
	  {
		  return true;
	  }
	  return false;
  }

  //Returns a list of products in the database.
  public List<Product> getProducts() {
	  String sql="select * from spacesta.products";
	  List<Product> products = jdbcTemplate.query(sql, new ProductMapper());
	  return products;
  }

}

class ProductMapper implements RowMapper<Product> {

  public Product mapRow(ResultSet rs, int arg1) throws SQLException {
    Product product = new Product();

    product.setProductName(rs.getString("productName"));
    product.setProductDescription(rs.getString("productDescription"));
    product.setProductQuantity(rs.getInt("productQuantity"));
    product.setProductPrice(rs.getDouble("productPrice"));
    return product;
  }
}