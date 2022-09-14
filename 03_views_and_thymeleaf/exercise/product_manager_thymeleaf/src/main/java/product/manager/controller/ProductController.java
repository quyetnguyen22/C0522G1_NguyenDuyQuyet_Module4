package product.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import product.manager.model.Product;
import product.manager.service.IProductService;

@Controller
public class ProductController {

    @Autowired
    IProductService productService;

    @GetMapping("/productList")
    public String productList(Model model) {
        model.addAttribute("productList", productService.productList());
        return "list";
    }

    @GetMapping("/add")
    public String formAddProduct(Model model) {
        model.addAttribute("product", new Product());
        return "add";
    }

    @GetMapping("/save")
    public String saveAddProduct(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        productService.addNewProduct(product);
        redirectAttributes.addFlashAttribute("msg", "add " + product.getProductName() + " successfully!");
        return "redirect:/add";
    }

    @GetMapping("/search/{id}")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.showDetail(id));
        return "";
    }

    @GetMapping("/formEdit/{id}")
    public String editProduct(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.showDetail(id));
        return "edit";
    }

    @GetMapping("/saveEdit")
    public String saveEditing(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        productService.editProduct(product.getId(), product);
        redirectAttributes.addFlashAttribute("msgEdit", "Edited " + product.getProductName() + " successfully!");
        return "redirect:/productList";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id, RedirectAttributes attributes) {
        Product product = productService.showDetail(id);
        attributes.addFlashAttribute("msgDelete", "Deleted " + product.getProductName() + " successfully!");
        productService.deleteProduct(id);
        return "redirect:/productList";
    }
}
