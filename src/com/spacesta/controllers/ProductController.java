package com.spacesta.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spacesta.models.Product;
import com.spacesta.services.ProductService;

@Controller
public class ProductController {
	@Autowired
	public ProductService productService;
	
	@RequestMapping(path = "/addproduct", method = RequestMethod.GET) 
	public ModelAndView displayForm() {
		return new ModelAndView("addProduct", "product", new Product());
	}
	
	@RequestMapping(path = "/addproduct", method = RequestMethod.POST)
	public ModelAndView addProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		System.out.println("ProductName: " + product.getProductName());
		System.out.println("ProductPrice: " + product.getProductPrice());

		if (result.hasErrors()) {
		  
			return new ModelAndView("addProduct", "product", product);
		}
		
		else {
			boolean check = productService.checkProduct(product);
			if(check == false)
			{
				productService.registerProduct(product);
			}
			else
			{
				  result.rejectValue("productName", "error.product", "The product already exists");
				  return new ModelAndView("addProduct", "product", product);
			}
			return new ModelAndView("displayProducts", "products", productService.getProducts());
		}
		
	}
	
}
