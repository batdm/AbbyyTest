package com.example.abbyytest.product.book;

import android.content.ContentValues;

public class ProgBook extends Book {

    private String prg_language;

    public ProgBook(String name, int price, String barcode, int num_page, String prg_language) {
        super(name, price, barcode, num_page);
        this.prg_language = prg_language;
    }

    public ContentValues getBookValues() {
        ContentValues ProductValues = new ContentValues();
        ProductValues.put("name", name);
        ProductValues.put("price", price);
        ProductValues.put("barcode", barcode);
        ProductValues.put("category", "Книги");
        ProductValues.put("sub_category", "Программирование");
        ProductValues.put("sub_category_id", 1);
        ProductValues.put("num_page", num_page);
        ProductValues.put("prg_language", prg_language);
        return ProductValues;
    }
}
