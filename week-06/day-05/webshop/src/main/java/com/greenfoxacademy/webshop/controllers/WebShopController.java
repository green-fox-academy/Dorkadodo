package com.greenfoxacademy.webshop.controllers;

import com.greenfoxacademy.webshop.models.ItemList;
import com.greenfoxacademy.webshop.models.ShopItem;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;
import java.util.stream.Collectors;

@Controller
public class WebShopController {

    ItemList itemList = new ItemList();

    @GetMapping("/webshop")
    public String webshop(Model model) {
        model.addAttribute("itemList", itemList.getItemList());
        return "index";
    }

    @GetMapping("/only-available")
    public String onlyAvailable(Model model) {
        List<ShopItem> availableItemList = itemList.getItemList().stream()
                .filter(item -> item.getQuantityOfStock() > 0)
                .collect(Collectors.toList());
        model.addAttribute("itemList", availableItemList);
        return "index";
    }

    @GetMapping("/cheapest-first")
    public String cheapestFirst(Model model) {
        List<ShopItem> cheapestFirstItemList = itemList.getItemList().stream()
                .sorted(Comparator.comparingInt(ShopItem::getPrice))
                .collect(Collectors.toList());
        model.addAttribute("itemList", cheapestFirstItemList);
        return "index";
    }

    @GetMapping("/contains-nike")
    public String containsNike(Model model) {
        List<ShopItem> containsNike = itemList.getItemList().stream()
                .filter(item -> item.getName().contains("Nike") || item.getDescription().contains("Nike"))
                .collect(Collectors.toList());
        model.addAttribute("itemList", containsNike);
        return "index";
    }

    @GetMapping("/average-stock")
    public String averageStock(Model model) {
        OptionalDouble optionalAverageStock = itemList.getItemList().stream()
                .mapToInt(ShopItem::getQuantityOfStock)
                .average();
        String averageStock;
        if (optionalAverageStock.isPresent()) {
            averageStock = "Average stock: " + String.valueOf(optionalAverageStock.getAsDouble());
        } else {
            averageStock = "No items found";
        }

        model.addAttribute("message", averageStock);
        return "message";
    }

    @GetMapping("/most-expensive-available")
    public String mostExpensiveAvailable(Model model) {
        Optional<ShopItem> optionalMostExpensive = itemList.getItemList().stream()
                .max((item1, item2) -> item1.getPrice().compareTo(item2.getPrice()));
        if (optionalMostExpensive.isPresent()) {
            List<ShopItem> mostExpensive = itemList.getItemList().stream()
                    .filter(item -> item.getPrice().equals(optionalMostExpensive.get().getPrice()))
                    .collect(Collectors.toList());
            model.addAttribute("itemList", mostExpensive);
            return "index";
        } else {
            model.addAttribute("message", "No items found");
            return "message";
        }
    }

    @PostMapping("/search")
    public String search(@RequestParam String searchword, Model model) {
        List<ShopItem> searchResult = itemList.getItemList().stream()
                .filter(item -> item.getName().toLowerCase().contains(searchword.toLowerCase().trim()) || item.getDescription().toLowerCase().contains(searchword.toLowerCase().trim()))
                .collect(Collectors.toList());
        model.addAttribute("itemList", searchResult);
        return "index";
    }
}
