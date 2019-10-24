package com.example.myapplication;

import android.annotation.SuppressLint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class FakeDatabase {


    public static int orderMealNumber = 0;

    public static Item getItemById(int articleID) {
        return items.get(articleID);
    }

    public static Item getOrderById(int articleID) {
        return orders.get(articleID);
    }

    public static ArrayList<Item> getAllItems() {
        return new ArrayList<Item>((List) Arrays.asList(items.values().toArray()));
    }

    public static ArrayList<Item> getAllOrders() {
        return new ArrayList<Item>((List) Arrays.asList(orders.values().toArray()));
    }

    static public HashMap<Integer, Item> items = new HashMap<>();
    static public HashMap<Integer, Item> orders = new HashMap<>();
    
    static {
        items.put(1, new Item(1,"Hamburger", 8, "this is a hamburger",
                "ham", R.mipmap.ham));
        items.put(2, new Item(2,"Cheese burger", 8, "this is a Cheese burger",
                "cheese", R.mipmap.cheese));
        items.put(3, new Item(3,"Sandwich", 8, "this is a Sandwich",
                "sand", R.mipmap.sand));
        items.put(4, new Item(4,"Milk shake", 5, "this is a Milk shake",
                "shake", R.mipmap.shake));
        items.put(5, new Item(5,"Muffins", 4.5, "this is a Muffins",
                "muffin", R.mipmap.muffin));
        items.put(6, new Item(6,"Burrito", 6, "this is a Burrito",
                "burrito", R.mipmap.burrito));
        items.put(7, new Item(7,"Fries", 4, "this is a Fries",
                "fries", R.mipmap.fries));
        items.put(8, new Item(8,"Pretzel", 10, "this is a Pretzel",
                "pretzel", R.mipmap.pretzel));
        items.put(9, new Item(9,"Onion rings", 3.6, "this is a Onion rings",
                "onion", R.mipmap.onion));
        items.put(10, new Item(10,"Donuts", 3.5, "this is a Donuts",
                "donuts", R.mipmap.donuts));
        items.put(11, new Item(11,"Taco", 7.3, "this is a Taco",
                "taco", R.mipmap.taco));
        items.put(12, new Item(12,"Hot dog", 4.5, "this is a Hot dog",
                "hot", R.mipmap.hot));
        items.put(13, new Item(13,"Fried chicken", 6.5, "this is a Fried chicken",
                "fried", R.mipmap.fried));
        items.put(14, new Item(14,"Bacon", 4.5, "this is a Bacon",
                "bacon", R.mipmap.bacon));
        items.put(15, new Item(15,"Cookies", 3, "this is a Cookies",
                "cookies", R.mipmap.cookies));

    }
}
