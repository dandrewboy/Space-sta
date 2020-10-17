package com.spacesta.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.spacesta.dao.ProductDao;
import com.spacesta.models.Product;

public class ProductServiceImpl implements ProductService {
	//inject the product DAO
	@Autowired
	public ProductDao productDao;

	//used to add a product to the database
	public int registerProduct(Product product) {
		return productDao.registerProduct(product);
	}


	//used to verify if the product name already exists within the database
	public boolean checkProduct(Product product) {
		return productDao.checkProduct(product);
	}


	//used to get all the products from the database and return a list of products.
	public List<Product> getProducts() {
		return productDao.getProducts();
	}

}
