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
    List<ShopItem> contentOfCart = new ArrayList<>();

    @GetMapping("/")
    public String homepage() {
        return "redirect:/webshop";
    }

    @GetMapping("/webshop")
    public String webshop(Model model) {
        ShopItem itemToBuy = new ShopItem("x", "x", 0.00, 0);
        model.addAttribute("itemList", itemList.getItemList());
        model.addAttribute("currentCurrencySign", currentCurrency.getSign());
        model.addAttribute("itemToBuy", itemToBuy);
        return "index";
    }

    @GetMapping("/only-available")
    public String onlyAvailable(Model model) {
        if (itemList.getItemList().isEmpty()) {
            model.addAttribute("message", "Sorry, no items available");
            return "message";
        }
        ShopItem itemToBuy = new ShopItem("x", "x", 0.00, 0);
        List<ShopItem> availableItemList = itemList.getItemList().stream()
                .filter(item -> item.getQuantityOfStock() > 0)
                .collect(Collectors.toList());
        model.addAttribute("itemList", availableItemList);
        model.addAttribute("currentCurrencySign", currentCurrency.getSign());
        model.addAttribute("itemToBuy", itemToBuy);
        return "index";
    }

    @GetMapping("/cheapest-first")
    public String cheapestFirst(Model model) {
        if (itemList.getItemList().isEmpty()) {
            model.addAttribute("message", "Sorry, no items available");
            return "message";
        }
        ShopItem itemToBuy = new ShopItem("x", "x", 0.00, 0);
        List<ShopItem> cheapestFirstItemList = itemList.getItemList().stream()
                .sorted(Comparator.comparingDouble(ShopItem::getPrice))
                .collect(Collectors.toList());
        model.addAttribute("itemList", cheapestFirstItemList);
        model.addAttribute("currentCurrencySign", currentCurrency.getSign());
        model.addAttribute("itemToBuy", itemToBuy);
        return "index";
    }

    @GetMapping("/contains-nike")
    public String containsNike(Model model) {
        if (itemList.getItemList().isEmpty()) {
            model.addAttribute("message", "Sorry, no Nike items available");
            return "message";
        }
        ShopItem itemToBuy = new ShopItem("x", "x", 0.00, 0);
        List<ShopItem> containsNike = itemList.getItemList().stream()
                .filter(item -> item.getName().contains("Nike") || item.getDescription().contains("Nike"))
                .collect(Collectors.toList());
        model.addAttribute("itemList", containsNike);
        model.addAttribute("currentCurrencySign", currentCurrency.getSign());
        model.addAttribute("itemToBuy", itemToBuy);
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
            ShopItem itemToBuy = new ShopItem("x", "x", 0.00, 0);
            List<ShopItem> mostExpensive = itemList.getItemList().stream()
                    .filter(item -> item.getPrice().equals(optionalMostExpensive.get().getPrice()))
                    .collect(Collectors.toList());
            model.addAttribute("itemList", mostExpensive);
            model.addAttribute("currentCurrencySign", currentCurrency.getSign());
            model.addAttribute("itemToBuy", itemToBuy);
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
        ShopItem itemToBuy = new ShopItem("x", "x", 0.00, 0);
        model.addAttribute("itemList", searchResult);
        model.addAttribute("currentCurrencySign", currentCurrency.getSign());
        model.addAttribute("itemToBuy", itemToBuy);
        return "index";
    }

    @GetMapping("/change-currency")
    public String changeCurrency(Model model) {
        model.addAttribute("currencyList", itemList.getCurrencyList());
        return "changeCurrency";
    }

    @PostMapping("/new-currency")
    public String newCurrency(@RequestParam String currencyName) {
        Currency previousCurrency = currentCurrency;
        Optional<Currency> optionalCurrentCurrency = itemList.getCurrencyList().stream()
                .filter(currency -> currency.getName().equals(currencyName))
                .findFirst();
        if (optionalCurrentCurrency.isPresent()) {
            currentCurrency = optionalCurrentCurrency.get();
            itemList.getItemList().stream()
                    .forEach(item -> item.setPrice(item.getPrice() / previousCurrency.getExchangeRate() * currentCurrency.getExchangeRate()));
        }
        return "redirect:/webshop";
    }

    @PostMapping("/add-item-to-cart")
    public String buySelectedItems(@RequestParam Long itemID, Model model) {
        Optional<ShopItem> optionalShopItem = itemList.getItemList().stream()
                .filter(item -> item.getID() == itemID)
                .findFirst();
        if (optionalShopItem.isEmpty()) {
            model.addAttribute("message", "Sorry, we couldn't find the selected item.");
            return "message";
        }
        ShopItem itemToBuy = optionalShopItem.get();
        model.addAttribute("itemToBuy", itemToBuy);
        return "contentOfCart";
    }

    @PostMapping("/get-item-amount")
    public String getItemAmount(@RequestParam Long itemID, Integer amountToBuy, Model model) {
        Optional<ShopItem> optionalShopItem = itemList.getItemList().stream()
                .filter(item -> item.getID() == itemID)
                .findFirst();
        if (optionalShopItem.isEmpty() || (amountToBuy <= 0)) {
            model.addAttribute("message", "Sorry, we don't have the selected item.");
            return "message";
        }
        ShopItem itemToBuy = optionalShopItem.get();
        addItemToCart(itemToBuy, amountToBuy);
        model.addAttribute("contentOfCart", contentOfCart);
        return "contentOfCart";
    }

    private void addItemToCart(ShopItem newItem, Integer amountToBuy) {
        newItem.setAmountToBuy(amountToBuy);
        contentOfCart.stream()
                .filter(item -> item.getID() == newItem.getID())
                .forEach(item -> item.setAmountToBuy(amountToBuy));
        if (!(contentOfCart.contains(newItem))){
            contentOfCart.add(newItem);
        }
        contentOfCart = contentOfCart.stream()
                .filter(item -> item.getAmountToBuy() > 0)
                .collect(Collectors.toList());
    }
}
