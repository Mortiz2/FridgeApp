package com.krzpro.fridgeapp.controller;

import com.krzpro.fridgeapp.model.FridgeItem;
import com.krzpro.fridgeapp.model.Product;
import com.krzpro.fridgeapp.service.FridgeItemService;
import com.krzpro.fridgeapp.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/view/fridgeitem")
public class FridgeItemViewController {

    private final FridgeItemService fridgeItemService;
    private final ProductService productService;

    public FridgeItemViewController(FridgeItemService fridgeItemService, ProductService productService) {
        this.fridgeItemService = fridgeItemService;
        this.productService = productService;
    }

    @GetMapping
    public String listItems(Model model) {
        List<FridgeItem> items = fridgeItemService.findAll();
        model.addAttribute("fridgeitems", items);
        return "fridgeitem-list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("fridgeItem", new FridgeItem());
        model.addAttribute("products", productService.findAll());
        return "fridgeitem-form";
    }

    @PostMapping("/add")
    public String saveItem(@ModelAttribute FridgeItem fridgeItem) {
        fridgeItemService.save(fridgeItem);
        return "redirect:/view/fridgeitem";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        FridgeItem item = fridgeItemService.findById(id).orElseThrow();
        model.addAttribute("fridgeItem", item);
        model.addAttribute("products", productService.findAll());
        return "fridgeitem-form";
    }

    @PostMapping("/edit/{id}")
    public String updateItem(@PathVariable Long id, @ModelAttribute FridgeItem fridgeItem) {
        fridgeItem.setId(id);
        fridgeItemService.save(fridgeItem);
        return "redirect:/view/fridgeitem";
    }

    @GetMapping("/delete/{id}")
    public String deleteItem(@PathVariable Long id) {
        fridgeItemService.deleteById(id);
        return "redirect:/view/fridgeitem";
    }
}
