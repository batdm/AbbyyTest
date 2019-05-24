package com.example.abbyytest.product.disc;

import android.content.ContentValues;

public class DiscSoft extends Disc {

    private String soft;
    private ContentValues discSoftValues;

    public DiscSoft(String name, int price, String barcode, String soft) {
        super(name, price, barcode);
        this.soft = soft;
        discSoftValues = new ContentValues();
    }

    private void getDiscValues() {
        discSoftValues.put("name", name);
        discSoftValues.put("price", price);
        discSoftValues.put("barcode", barcode);
        discSoftValues.put("category", "Диски");
        discSoftValues.put("software", soft);
    }

    public ContentValues getCdSoftValues() {
        getDiscValues();
        discSoftValues.put("sub_category", "CD");
        discSoftValues.put("sub_category_id", 8);
        return discSoftValues;
    }

    public ContentValues getDvdSoftValues() {
        getDiscValues();
        discSoftValues.put("sub_category", "DVD");
        discSoftValues.put("sub_category_id", 9);
        return discSoftValues;
    }
}
