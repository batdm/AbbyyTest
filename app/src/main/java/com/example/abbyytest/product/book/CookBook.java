package com.example.abbyytest.product.book;

import android.content.ContentValues;

public class CookBook extends Book {

    private String main_ingredient;

    public CookBook(String name, int price, String barcode, int num_page, String main_ingredient) {
        super(name, price, barcode, num_page);
        this.main_ingredient = main_ingredient;
    }

    public ContentValues getBookValues() {
        ContentValues ProductValues = new ContentValues();
        ProductValues.put("name", name);
        ProductValues.put("price", price);
        ProductValues.put("barcode", barcode);
        ProductValues.put("category", "Книги");
        ProductValues.put("sub_category", "Кулинария");
        ProductValues.put("sub_category_id", 2);
        ProductValues.put("num_page", num_page);
        ProductValues.put("main_ingredient", main_ingredient);
        return ProductValues;
    }
}
