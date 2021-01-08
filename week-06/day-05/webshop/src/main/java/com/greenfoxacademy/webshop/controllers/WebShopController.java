package com.greenfoxacademy.webshop.controllers;

import com.greenfoxacademy.webshop.models.ItemList;
import com.greenfoxacademy.webshop.models.ShopItem;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class WebShopController {

    ItemList itemList = new ItemList();

    @GetMapping("/webshop")
    public String webshop(Model model){
        model.addAttribute("itemList", itemList.getItemList());
        return "index";
    }

    @GetMapping("/only-available")
    public String onlyAvailable(Model model){
        List<ShopItem> availableItemList = itemList.getItemList().stream()
                .filter(item -> item.getQuantityOfStock()>0)
                .collect(Collectors.toList());
        model.addAttribute("itemList", availableItemList);
        return "index";
    }

    @GetMapping("/cheapest-first")
    public String cheapestFirst(Model model){
        List<ShopItem> cheapestFirstItemList = itemList.getItemList().stream()
                .sorted()
                .collect(Collectors.toList());
        model.addAttribute("itemList", cheapestFirstItemList);
        return "index";
    }

    @GetMapping("/contains-nike")
    public String containsNike(Model model){
        model.addAttribute("itemList", itemList.getItemList());
        return "index";
    }

    @GetMapping("/average-stock")
    public String averageStock(Model model){
        model.addAttribute("itemList", itemList.getItemList());
        return "index";
    }

    @GetMapping("/most-expensive-available")
    public String mostExpensiveAvailable(Model model){
        model.addAttribute("itemList", itemList.getItemList());
        return "index";
    }
}
