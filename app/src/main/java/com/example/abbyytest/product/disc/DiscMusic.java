package com.example.abbyytest.product.disc;

import android.content.ContentValues;

public class DiscMusic extends Disc {

    private String music;
    private ContentValues discMusicValues;

    public DiscMusic(String name, int price, String barcode, String music) {
        super(name, price, barcode);
        this.music = music;
        discMusicValues = new ContentValues();
    }

    private void getDiscValues() {
        discMusicValues.put("name", name);
        discMusicValues.put("price", price);
        discMusicValues.put("barcode", barcode);
        discMusicValues.put("category", "Диски");
        discMusicValues.put("music", music);
    }

    public ContentValues getCdMusicValues() {
        getDiscValues();
        discMusicValues.put("sub_category", "CD");
        discMusicValues.put("sub_category_id", 4);
        return discMusicValues;
    }

    public ContentValues getDvdMusicValues() {
        getDiscValues();
        discMusicValues.put("sub_category", "DVD");
        discMusicValues.put("sub_category_id", 5);
        return discMusicValues;
    }
}
