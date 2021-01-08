package com.greenfoxacademy.webshop.controllers;

import com.greenfoxacademy.webshop.models.Lists;
import com.greenfoxacademy.webshop.models.ShopItem;
import com.greenfoxacademy.webshop.models.Currency;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;
import java.util.stream.Collectors;

@Controller
public class WebShopController {

    Lists itemList = new Lists();
    Currency currentCurrency = new Currency("euro", "€", 1.00);

    @GetMapping("/")
    public String homepage() {
        return "redirect:/webshop";
    }

    @GetMapping("/webshop")
    public String webshop(Model model) {
        model.addAttribute("itemList", itemList.getItemList());
        model.addAttribute("currentCurrencySign", currentCurrency.getSign());
        return "index";
    }

    @GetMapping("/only-available")
    public String onlyAvailable(Model model) {
        if (itemList.getItemList().isEmpty()) {
            model.addAttribute("message", "Sorry, no items available");
            return "message";
        }

        List<ShopItem> availableItemList = itemList.getItemList().stream()
                .filter(item -> item.getQuantityOfStock() > 0)
                .collect(Collectors.toList());
        model.addAttribute("itemList", availableItemList);
        model.addAttribute("currentCurrencySign", currentCurrency.getSign());
        return "index";
    }

    @GetMapping("/cheapest-first")
    public String cheapestFirst(Model model) {
        if (itemList.getItemList().isEmpty()) {
            model.addAttribute("message", "Sorry, no items available");
            return "message";
        }
        List<ShopItem> cheapestFirstItemList = itemList.getItemList().stream()
                .sorted(Comparator.comparingLong(ShopItem::getPrice))
                .collect(Collectors.toList());
        model.addAttribute("itemList", cheapestFirstItemList);
        model.addAttribute("currentCurrencySign", currentCurrency.getSign());
        return "index";
    }

    @GetMapping("/contains-nike")
    public String containsNike(Model model) {
        if (itemList.getItemList().isEmpty()) {
            model.addAttribute("message", "Sorry, no Nike items available");
            return "message";
        }
        List<ShopItem> containsNike = itemList.getItemList().stream()
                .filter(item -> item.getName().contains("Nike") || item.getDescription().contains("Nike"))
                .collect(Collectors.toList());
        model.addAttribute("itemList", containsNike);
        model.addAttribute("currentCurrencySign", currentCurrency.getSign());
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
        if (itemList.getItemList().isEmpty()) {
            model.addAttribute("message", "Sorry, no items available");
            return "message";
        }
        Optional<ShopItem> optionalMostExpensive = itemList.getItemList().stream()
                .max((item1, item2) -> item1.getPrice().compareTo(item2.getPrice()));
        if (optionalMostExpensive.isPresent()) {
            List<ShopItem> mostExpensive = itemList.getItemList().stream()
                    .filter(item -> item.getPrice().equals(optionalMostExpensive.get().getPrice()))
                    .collect(Collectors.toList());
            model.addAttribute("itemList", mostExpensive);
            model.addAttribute("currentCurrencySign", currentCurrency.getSign());
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
        if (searchResult.isEmpty()) {
            model.addAttribute("message", "No items found for " + searchword.toUpperCase());
            return "message";
        }
        model.addAttribute("itemList", searchResult);
        model.addAttribute("currentCurrencySign", currentCurrency.getSign());
        return "index";
    }

    @GetMapping("/change-currency")
    public String changeCurrency(Model model){
        model.addAttribute("currencyList", itemList.getCurrencyList());
        return "changeCurrency";
    }

    @PostMapping("/new-currency")
    public String newCurrency(@RequestParam String currencyName){
        Optional<Currency> optionalCurrentCurrency = itemList.getCurrencyList().stream()
        .filter(currency -> currency.getName().equals(currencyName))
                .findFirst();
        if (optionalCurrentCurrency.isPresent()){
            currentCurrency = optionalCurrentCurrency.get();
            itemList.getItemList().stream()
                    .forEach(item -> item.setPrice(Math.round(item.getPrice() * currentCurrency.getExchangeRate())));
        }

        return "redirect:/webshop";
    }
}
