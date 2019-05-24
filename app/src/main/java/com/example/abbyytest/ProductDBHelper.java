package com.example.abbyytest;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

@Deprecated
public class ProductDBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "Product";
    private static final int DB_VERSION = 1;

    ProductDBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        updateMyDB(db, 0, DB_VERSION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        updateMyDB(db, oldVersion, newVersion);
    }

    private void updateMyDB(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion < 1) {
            db.execSQL("create table t_prg_book (" +
                    "_id integer primary key autoincrement," +
                    "name text," +
                    "price integer," +
                    "barcode text," +
                    "category text," +
                    "sub_category text," +
                    "num_page integer," +
                    "prg_language text" +
                    ");");
            db.execSQL("create table t_cook_book (" +
                    "_id integer primary key autoincrement," +
                    "name text," +
                    "price integer," +
                    "barcode text," +
                    "category text," +
                    "sub_category text," +
                    "num_page integer," +
                    "main_ingredient text" +
                    ");");
            db.execSQL("create table t_esot_book (" +
                    "_id integer primary key autoincrement," +
                    "name text," +
                    "price integer," +
                    "category text," +
                    "sub_category text," +
                    "type text," +
                    "num_page integer," +
                    "min_years integer" +
                    ");");
            db.execSQL("create table t_cd_dvd (" +
                    "_id integer primary key autoincrement," +
                    "name text," +
                    "price integer," +
                    "barcode text," +
                    "category text," +
                    "sub_category text," +
                    "music integer," +
                    "video integer," +
                    "software integer" +
                    ");");
            insertEsotBook(db, "Тайная доктрина", 20, "5235", 150, 18);
            insertCdMusic(db, "AC/DC Back In Black", 5, "51235123", "Hells Bells!");
            insertCdSoft(db, "Notepad++", 0, "124124", "Install me!");
            insertCdVideo(db, "UFC highlights 2019", 10, "56238", "Bibib");
            insertCookBook(db, "500 рецептов", 1, "827438", 100, "Омлет");
            insertProgBook(db, "Head first Android", 5, "92675", 704, "Java");
            insertDvdSoft(db, "Abode", 0, "195762", "wooo");
            Log.v("DBHelper", "create rows");
        }
    }

    private static ContentValues getBookProductValues(String name, Integer price, String barcode, String sub_category, Integer num_page, String prg_lang, String main_ingr, Integer min_years) {
        ContentValues ProductValues = new ContentValues();
        ProductValues.put("name", name);
        ProductValues.put("price", price);
        ProductValues.put("barcode", barcode);
        ProductValues.put("category", "Книги");
        ProductValues.put("sub_category", sub_category);
        ProductValues.put("num_page", num_page);
        if (prg_lang != null) {
            ProductValues.put("prg_language", prg_lang);
        }
        if (main_ingr != null) {
            ProductValues.put("main_ingredient", main_ingr);
        }
        if (min_years != null) {
            ProductValues.put("min_years", min_years);
        }
        return ProductValues;
    }

    private static ContentValues getDiscProductValues(String name, Integer price, String barcode, String sub_category, String music, String video, String soft) {
        ContentValues ProductValues = new ContentValues();
        ProductValues.put("name", name);
        ProductValues.put("price", price);
        ProductValues.put("barcode", barcode);
        ProductValues.put("category", "Диски");
        ProductValues.put("sub_category", sub_category);
        if (music != null) {
            ProductValues.put("music", music);
        }
        if (video != null) {
            ProductValues.put("video", video);
        }
        if (soft != null) {
            ProductValues.put("software", soft);
        }
        return ProductValues;
    }

    private static void insertProgBook(SQLiteDatabase db, String name, Integer price, String barcode, Integer num_page, String prg_lang) {
        db.insert("t_prg_book", null, getBookProductValues(name, price, barcode, "Программирование", num_page, prg_lang, null, null));
    }

    private static void insertCookBook(SQLiteDatabase db, String name, Integer price, String barcode, Integer num_page, String main_ingr) {
        db.insert("t_cook_book", null, getBookProductValues(name, price, barcode, "Кулинария", num_page, null, main_ingr, null));
    }

    private static void insertEsotBook(SQLiteDatabase db, String name, Integer price, String barcode, Integer num_page, Integer min_years) {
        db.insert("t_esot_book", null, getBookProductValues(name, price, barcode, "Эзотерика", num_page, null, null, min_years));
    }

    private static void insertCdMusic(SQLiteDatabase db, String name, Integer price, String barcode, String music) {
        db.insert("t_cd_dvd", null, getDiscProductValues(name, price, barcode, "CD", music, null, null));
    }

    private static void insertCdVideo(SQLiteDatabase db, String name, Integer price, String barcode, String video) {
        db.insert("t_cd_dvd", null, getDiscProductValues(name, price, barcode, "CD", null, video, null));
    }

    private static void insertCdSoft(SQLiteDatabase db, String name, Integer price, String barcode, String soft) {
        db.insert("t_cd_dvd", null, getDiscProductValues(name, price, barcode, "CD", null, null, soft));
    }

    private static void insertDvdMusic(SQLiteDatabase db, String name, Integer price, String barcode, String music) {
        db.insert("t_cd_dvd", null, getDiscProductValues(name, price, barcode, "DVD", music, null, null));
    }

    private static void insertDvdVideo(SQLiteDatabase db, String name, Integer price, String barcode, String video) {
        db.insert("t_cd_dvd", null, getDiscProductValues(name, price, barcode, "DVD", null, video, null));
    }

    private static void insertDvdSoft(SQLiteDatabase db, String name, Integer price, String barcode, String soft) {
        db.insert("t_cd_dvd", null, getDiscProductValues(name, price, barcode, "DVD", null, null, soft));
    }

}
