package com.example.abbyytest.product.disc;

import android.content.ContentValues;

public class DiscVideo extends Disc {
    private String video;
    private ContentValues discVideoValues;

    public DiscVideo(String name, int price, String barcode, String video) {
        super(name, price, barcode);
        this.video = video;
        discVideoValues = new ContentValues();
    }

    private void getDiscValues() {
        discVideoValues.put("name", name);
        discVideoValues.put("price", price);
        discVideoValues.put("barcode", barcode);
        discVideoValues.put("category", "Диски");
        discVideoValues.put("video", video);

    }

    public ContentValues getCdVideoValues() {
        getDiscValues();
        discVideoValues.put("sub_category", "CD");
        discVideoValues.put("sub_category_id", 6);
        return discVideoValues;
    }

    public ContentValues getDvdVideoValues() {
        getDiscValues();
        discVideoValues.put("sub_category", "DVD");
        discVideoValues.put("sub_category_id", 7);
        return discVideoValues;
    }

}
