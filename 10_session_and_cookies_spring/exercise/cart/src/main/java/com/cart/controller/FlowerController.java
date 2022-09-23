package com.cart.controller;

import com.cart.dto.CartDto;
import com.cart.dto.FlowerDto;
import com.cart.model.Flower;
import com.cart.service.IFlowerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@SessionAttributes("cart")
@Controller
@RequestMapping("/shop")
public class FlowerController {

    @ModelAttribute("cart")
    public CartDto initCart() {
        return new CartDto();
    }

    @Autowired
    private IFlowerService flowerService;

    @GetMapping
    public ModelAndView showListFlowers( Model model,
                                         @CookieValue(value = "productId", defaultValue = "-1") int productId) {
        if (productId != -1) {
            model.addAttribute("historyProduct", flowerService.showFlowerById(productId).get());
        }
        return new ModelAndView("product/flowerList", "flowers", flowerService.showAllFlower());
    }

    @GetMapping("/detail/{id}")
    public ModelAndView showDetail(@PathVariable int id, HttpServletResponse response) {
        /* create cookie*/
        Cookie cookie = new Cookie("productId", id + "");
        cookie.setMaxAge(60 * 60 * 24 * 2); // lifetime is 2 days
        cookie.setPath("/"); // global cookie
        response.addCookie(cookie);

        return new ModelAndView("product/flowerDetail", "flower", flowerService.showFlowerById(id));
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable int id,
//                            @ModelAttribute("cart") CartDto cartDto, // get SessionAttribute
                            @SessionAttribute("cart") CartDto cart) {

        Optional<Flower> flower = flowerService.showFlowerById(id);
        if (flower.isPresent()) {
            FlowerDto flowerDto = new FlowerDto();
            BeanUtils.copyProperties(flower.get(), flowerDto);
            cart.addToCart(flowerDto);
        }
        return "redirect:/cart";
    }

    @GetMapping("/decrease/{id}")
    public String decreaseProduct(@PathVariable int id,
                                  @SessionAttribute("cart") CartDto cart) {

        Optional<Flower> flower = flowerService.showFlowerById(id);
        if (flower.isPresent()) {
            FlowerDto flowerDto = new FlowerDto();
            BeanUtils.copyProperties(flower.get(), flowerDto);
            cart.decreaseProduct(flowerDto);
        }

        return "redirect:/cart";
    }

    @GetMapping("delete/{id}")
    public String deleteProduct(@PathVariable int id,
                                @SessionAttribute("cart") CartDto cart) {
        Optional<Flower> flower = flowerService.showFlowerById(id);
        if (flower.isPresent()) {
            FlowerDto flowerDto = new FlowerDto();
            BeanUtils.copyProperties(flower.get(), flowerDto);
            cart.deleteProduct(flowerDto);
        }

        return "redirect:/cart";
    }


}
