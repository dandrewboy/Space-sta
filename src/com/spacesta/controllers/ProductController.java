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
	//inject the Product service
	@Autowired
	public ProductService productService;
	
	//used to GET the add product page based on user request
	@RequestMapping(path = "/addproduct", method = RequestMethod.GET) 
	public ModelAndView displayForm() {
		return new ModelAndView("addProduct", "product", new Product());
	}
	
	//method is called once the add product form is submitted (POST).
	@RequestMapping(path = "/addproduct", method = RequestMethod.POST)
	public ModelAndView addProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		System.out.println("ProductName: " + product.getProductName());
		System.out.println("ProductPrice: " + product.getProductPrice());

		//verify the form doesn't have errors and if it does, return to add product page with errors.
		if (result.hasErrors()) {
			return new ModelAndView("addProduct", "product", product);
		}
		
		//No form errors found.
		else {
			/*verify the product name doesn't already exist and if it doesn't add the product to the db, 
			 * else return an error notifying the user.
			 */
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
