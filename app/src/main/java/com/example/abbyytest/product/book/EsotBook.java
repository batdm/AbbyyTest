package com.example.abbyytest.product.book;

import android.content.ContentValues;

public class EsotBook extends Book {

    private int min_years;

    public EsotBook(String name, int price, String barcode, int num_page, int min_years) {
        super(name, price, barcode, num_page);
        this.min_years = min_years;
    }

    public ContentValues getBookValues() {
        ContentValues ProductValues = new ContentValues();
        ProductValues.put("name", name);
        ProductValues.put("price", price);
        ProductValues.put("barcode", barcode);
        ProductValues.put("category", "Книги");
        ProductValues.put("sub_category", "Эзотерика");
        ProductValues.put("sub_category_id", 3);
        ProductValues.put("num_page", num_page);
        ProductValues.put("min_years", min_years);
        return ProductValues;
    }
}
