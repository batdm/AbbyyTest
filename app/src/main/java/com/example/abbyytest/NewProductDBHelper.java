package com.example.abbyytest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.abbyytest.product.book.CookBook;
import com.example.abbyytest.product.book.EsotBook;
import com.example.abbyytest.product.book.ProgBook;
import com.example.abbyytest.product.disc.DiscMusic;
import com.example.abbyytest.product.disc.DiscSoft;
import com.example.abbyytest.product.disc.DiscVideo;

public class NewProductDBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "Product";
    private static final int DB_VERSION = 1;


    NewProductDBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        updateMyDB(db, 1, DB_VERSION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        updateMyDB(db, oldVersion, newVersion);
    }

    private void updateMyDB(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion < 2) {
            try {
                db.execSQL("create table t_product (" +
                        "_id integer primary key autoincrement," +
                        "name text," +
                        "price integer," +
                        "barcode text," +
                        "category text," +
                        "sub_category text," +
                        "sub_category_id integer," +
                        "num_page integer," +
                        "prg_language text," +
                        "main_ingredient text," +
                        "min_years integer," +
                        "music text," +
                        "video text," +
                        "software text" +
                        ");");
                addProgBook(db, "Head first Android", 5, "92675", 704, "Java");
                addProgBook(db, "Java SE", 10, "5325213", 800, "Java");
                addCookBook(db, "500 рецептов", 1, "827438", 100, "Омлет");
                addEsotBook(db, "Тайная доктрина", 20, "5235", 150, 18);
                addCdVideo(db, "UFC highlights 2019", 10, "56238", "Bibib");
                addCdMusic(db, "AC/DC Back In Black", 5, "51235123", "Hells Bells!");
                addCdSoft(db, "Notepad++", 0, "124124", "Install me!");
                addDvdMusic(db, "Любэ", 12, "124124", "Конь");
                addDvdSoft(db, "Microsoft", 33, "6235", "GitHub");
                addDvdVideo(db,"Game of Thrones",213,"78324","s1 s10");
            } catch (SQLiteException e) {
                Log.e("В классе '" + getClass() + "' ошибка:", e.getMessage());
            }
        }
    }

    private void addProgBook(SQLiteDatabase db, String name, int price, String barcode, int num_page, String prg_language) {
        ProgBook progBook = new ProgBook(name, price, barcode, num_page, prg_language);
        db.insert("t_product", null, progBook.getBookValues());
    }

    private void addCookBook(SQLiteDatabase db, String name, int price, String barcode, int num_page, String main_ingredient) {
        CookBook cookBook = new CookBook(name, price, barcode, num_page, main_ingredient);
        db.insert("t_product", null, cookBook.getBookValues());
    }

    private void addEsotBook(SQLiteDatabase db, String name, int price, String barcode, int num_page, int min_years) {
        EsotBook esotBook = new EsotBook(name, price, barcode, num_page, min_years);
        db.insert("t_product", null, esotBook.getBookValues());
    }

    private void addCdVideo(SQLiteDatabase db, String name, int price, String barcode, String video) {
        DiscVideo discVideo = new DiscVideo(name, price, barcode, video);
        db.insert("t_product", null, discVideo.getCdVideoValues());
    }

    private void addCdMusic(SQLiteDatabase db, String name, int price, String barcode, String music) {
        DiscMusic discVideo = new DiscMusic(name, price, barcode, music);
        db.insert("t_product", null, discVideo.getCdMusicValues());
    }

    private void addCdSoft(SQLiteDatabase db, String name, int price, String barcode, String soft) {
        DiscSoft discVideo = new DiscSoft(name, price, barcode, soft);
        db.insert("t_product", null, discVideo.getCdSoftValues());
    }

    private void addDvdVideo(SQLiteDatabase db, String name, int price, String barcode, String video) {
        DiscVideo discVideo = new DiscVideo(name, price, barcode, video);
        db.insert("t_product", null, discVideo.getDvdVideoValues());
    }

    private void addDvdMusic(SQLiteDatabase db, String name, int price, String barcode, String music) {
        DiscMusic discVideo = new DiscMusic(name, price, barcode, music);
        db.insert("t_product", null, discVideo.getDvdMusicValues());
    }

    private void addDvdSoft(SQLiteDatabase db, String name, int price, String barcode, String soft) {
        DiscSoft discVideo = new DiscSoft(name, price, barcode, soft);
        db.insert("t_product", null, discVideo.getDvdSoftValues());
    }
}
