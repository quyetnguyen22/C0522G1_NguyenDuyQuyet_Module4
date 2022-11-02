package com.exam_module_4.controller;

import com.exam_module_4.dto.ProductsDto;
import com.exam_module_4.model.Products;
import com.exam_module_4.service.IProductTypeService;
import com.exam_module_4.service.IProductsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProductController {

    @Autowired
    private IProductsService productsService;

    @Autowired
    private IProductTypeService productTypeService;

    @GetMapping("list")
    public ModelAndView getAllCustomer(@PageableDefault(value = 5) Pageable pageable,
                                       Model model) {
        model.addAttribute("productType", productTypeService.getProductType());
        return new ModelAndView("list", "allProducts", productsService.showAll(pageable));
    }

    @GetMapping("formAdd")
    public String getFormAdd(Model model) {
        model.addAttribute("productType", productTypeService.getProductType());
        model.addAttribute("productDto", new ProductsDto());
        return "add";
    }

    @PostMapping("addNew")
    public String saveNewProduct(@ModelAttribute @Validated ProductsDto productsDto,
                                 BindingResult bindingResult,
                                 RedirectAttributes attributes,
                                 Model model) {
        new ProductsDto().validate(productsDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("productType", productTypeService.getProductType());
            return "add";
        } else {
            Products products = new Products();
            BeanUtils.copyProperties(productsDto, products);
            productsService.addNewProduct(products);
            attributes.addFlashAttribute("msg", "Added " + products.getName() + " successfully!");
            return "redirect:/formAdd";
        }
    }

    @GetMapping("search")
    public ModelAndView searchProduct(@PageableDefault(value = 5) Pageable pageable,
                                @RequestParam(value = "search") String search) {
        return new ModelAndView("list", "allProducts", productsService.searchProduct(pageable,search));
    }
}
