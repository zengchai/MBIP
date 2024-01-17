package my.utm.ip.springmvcmaven.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import my.utm.ip.springmvcmaven.models.product.Product;
import my.utm.ip.springmvcmaven.services.product.ProductService;

@Controller
@RequestMapping("/product")

public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/list")

    public String home(Model model) {

        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);

        return "product/products";

    }

    @RequestMapping("/formAddProduct")

    public String viewAddProductForm(Model model) {

        model.addAttribute("mode", "add");
        model.addAttribute("product", new Product());
        return "product/formProduct";

    }

    @RequestMapping("/formEditProduct")

    public String viewEditProductForm(@RequestParam String id, Model model) {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        model.addAttribute("mode", "edit");
        return "product/formProduct";

    }

    @RequestMapping("/addProduct")

    public String addProduct(
            @RequestParam("productName") String productName,
            @RequestParam("productDescription") String productDescription,
            @RequestParam("productCategory") String productCategory,
            @RequestParam("productPrice") String sProductPrice) {
        double productPrice = Double.parseDouble(sProductPrice);
        Product product = new Product("", productName, productDescription, productCategory, productPrice);
        productService.addProduct(product);

        return "redirect:/product/list";
    }

    @RequestMapping("/editProduct")

    public String editProduct(
            @RequestParam String productId,
            @RequestParam String productName,
            @RequestParam String productDescription,
            @RequestParam String productCategory,
            @RequestParam String productPrice) {
        double dProductPrice = Double.parseDouble(productPrice);
        Product product = new Product(productId, productName, productDescription, productCategory, dProductPrice);
        productService.updateProduct(product);

        return "redirect:/product/list";
    }

    @RequestMapping("/deleteProduct")

    public String deleteProduct(@RequestParam String id, Model model) {

        boolean success = productService.deleteProduct(id);

        if (success) {

            return "redirect:/product/list";
        }

        model.addAttribute("errorMessage", "Deletion Failed!. The product doesn't exist");
        return "/product/error";

    }

}
