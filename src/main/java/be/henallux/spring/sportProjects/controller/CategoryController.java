package be.henallux.spring.sportProjects.controller;

import be.henallux.spring.sportProjects.model.Category;
import be.henallux.spring.sportProjects.model.Product;
import be.henallux.spring.sportProjects.service.CategoriesService;
import be.henallux.spring.sportProjects.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
@RequestMapping(value="/category")
public class CategoryController {
    private CategoriesService categoriesService;
    private ProductsService productsService;

    @Autowired
    public CategoryController(CategoriesService categoriesService, ProductsService productsService) {
        this.categoriesService = categoriesService;
        this.productsService = productsService;
    }

    @RequestMapping(params={"id"}, method = RequestMethod.GET)
    public String getWithCategoryId(Model model, @RequestParam(required = false) String id) {
        try {
            int idInteger = Integer.parseInt(id);
            Category category = categoriesService.getCategoryWithId(idInteger);
            if(category == null) {
                return "integrated:notfound";
            }
            ArrayList<Product> products = productsService.getProductsWithCategoryId(idInteger);
            model.addAttribute("category", category);
            model.addAttribute("products", products);
            return "integrated:category";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "integrated:error";
        }
    }
}
