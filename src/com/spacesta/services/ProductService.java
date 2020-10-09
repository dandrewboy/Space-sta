package com.spacesta.services;

import java.util.List;
import com.spacesta.models.Product;

public interface ProductService {

  int registerProduct(Product product);
  
  boolean  checkProduct(Product product);
  
  List<Product> getProducts();
}
