package com.example.SpringBean.Controller;

import com.example.SpringBean.Model.Product;
import com.example.SpringBean.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public String home() {
        return "index"; // index.html
    }

    @GetMapping("/add-product")
    public String addProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "add-product"; // add-product.html
    }

    @PostMapping("/add-product")
    public String addProductSubmit(@ModelAttribute Product product) {
        productService.addProduct(product);
        return "redirect:/display-products";
    }

    @GetMapping("/display-products")
    public String displayProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "display-products"; // display-products.html
    }
}
