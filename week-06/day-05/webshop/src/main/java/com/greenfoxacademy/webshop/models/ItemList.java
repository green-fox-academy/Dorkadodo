package com.greenfoxacademy.webshop.models;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ItemList {
    private List<ShopItem> itemList;

    public ItemList() {
        itemList = new ArrayList<>();

        try {
            Stream<String>  lines = Files.lines(Path.of("src/main/resources/itemlist.csv"));
            List<ShopItem> items = lines.map(line -> {
                String[] arr = line.split(";");
                return new ShopItem(
                        arr[0],
                        arr[1],
                        Integer.parseInt(arr[2]), Integer.parseInt(arr[3]));
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
}
