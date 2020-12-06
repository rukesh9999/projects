package com.product.manager.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.product.manager.main.model.Product;
import com.product.manager.main.service.ProductService;

@Controller
@RequestMapping(value = "/api")
public class ProductController {
	@Autowired
	ProductService productService;

	@GetMapping("/product")
	public ModelAndView viewHomeController() {
		List<Product> listofproducts = productService.getAllproducts();
		ModelAndView mv = new ModelAndView();
		mv.addObject("listofproducts", listofproducts);
		mv.setViewName("home");
		return mv;
	}

	@GetMapping("/createnewproduct")
	public String newProductController(Model model) {
		Product product = new Product();
		model.addAttribute(product);
		return "createnewproduct";
	}

	@PostMapping("/saveproduct")
	public String saveProductController(@ModelAttribute("product") Product product) {
		productService.saveProduct(product);

		return "redirect:/api/product";
	}

	
	@GetMapping("/editproduct/{id}")
	public ModelAndView deleteProduct(@PathVariable(name = "id") long id) {
		ModelAndView mv = new ModelAndView();
		Product product = productService.getProduct(id);
		mv.addObject("product", product);
		mv.setViewName("editProduct");
		return mv;
	}

    @GetMapping("/deleteproduct/{id}")
	public String deleteProductController(@PathVariable(name = "id") long id) {
		productService.deleteProduct(id);
		return "redirect:/api/product";
	}

}
