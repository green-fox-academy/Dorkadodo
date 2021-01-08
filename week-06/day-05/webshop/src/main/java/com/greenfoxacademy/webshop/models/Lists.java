package com.greenfoxacademy.webshop.models;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lists {
    private List<ShopItem> itemList;
    private List<Currency> currencyList;

    public Lists() {
        itemList = new ArrayList<>();

        try {
            Stream<String>  lines = Files.lines(Path.of("src/main/resources/itemlist.csv"));
            List<ShopItem> items = lines.map(line -> {
                String[] arr = line.split(";");
                return new ShopItem(
                        arr[0],
                        arr[1],
                        Long.parseLong(arr[2]), Integer.parseInt(arr[3]));
            }).collect(Collectors.toList());
            this.itemList.addAll(items);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Couldn't read or something went wrong");
        }
    }

    public List<ShopItem> getItemList() {
        return itemList;
    }

    public void setItemList(List<ShopItem> itemList) {
        this.itemList = itemList;
    }

    public List<Currency> getCurrencyList(){
        currencyList = new ArrayList<>();
        try {
            Stream<String>  lines = Files.lines(Path.of("src/main/resources/static/currency.csv"));
            List<Currency> currencies = lines.map(line -> {
                String[] arr = line.split(";");
                return new Currency(
                        arr[0],
                        arr[1],
                        Double.parseDouble(arr[2]));
            }).collect(Collectors.toList());
            currencyList.addAll(currencies);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Couldn't read or something went wrong");
        }
        return currencyList;
    }
}
