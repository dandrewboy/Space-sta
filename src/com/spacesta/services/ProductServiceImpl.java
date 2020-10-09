package com.spacesta.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.spacesta.dao.ProductDao;
import com.spacesta.models.Product;

public class ProductServiceImpl implements ProductService {

  @Autowired
  public ProductDao productDao;

  public int registerProduct(Product product) {
    return productDao.registerProduct(product);
  }

public boolean checkProduct(Product product) {
	return productDao.checkProduct(product);
}

public List<Product> getProducts() {
	return productDao.getProducts();
}

}
