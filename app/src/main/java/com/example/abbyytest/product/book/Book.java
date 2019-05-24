package com.example.abbyytest.product.book;

import com.example.abbyytest.product.Product;

public class Book extends Product {

    protected int num_page;

    public Book(String name, int price, String barcode, int num_page) {
        super(name, price, barcode);
        this.num_page = num_page;
    }
}
