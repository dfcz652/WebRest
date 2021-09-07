package ru.alishev.springcourse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.alishev.springcourse.dao.PersonDAO;
import ru.alishev.springcourse.dao.ProductDAO;
import ru.alishev.springcourse.models.Person;
import ru.alishev.springcourse.models.Product;

import javax.validation.Valid;

@Controller
@RequestMapping("/product")
public class ProductController {
    private final ProductDAO productDAO;

    @Autowired
    public ProductController(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("product", productDAO.index());
        return "product/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("product", productDAO.show(id));
        return "product/show";
    }

    @GetMapping("/webrest")
    public String newProduct(@ModelAttribute("product") Product product) {
        return "people/webrest";
    }

    @PostMapping()
    public String create(@ModelAttribute("product") @Valid Product product,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "product/webrest";

        productDAO.save(product);
        return "redirect:/product";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("person", productDAO.show(id));
        return "product/edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("product") @Valid Product product, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "product/edit";

        productDAO.update(product);
        return "redirect:/product";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        productDAO.delete(id);
        System.out.println("gg");
        return "redirect:/product";
    }
}
