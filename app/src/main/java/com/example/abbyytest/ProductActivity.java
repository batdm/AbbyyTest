package com.example.abbyytest;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class ProductActivity extends AppCompatActivity {

    public static final String EXTRA_PRODUCT_ID = "productID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        //получить id товара из данных интента
        int productId = (Integer) getIntent().getExtras().get(EXTRA_PRODUCT_ID);
        try {
            SQLiteOpenHelper paperDBHelper = new NewProductDBHelper(this);
            SQLiteDatabase db = paperDBHelper.getReadableDatabase();
            Cursor cursor = db.query("t_product",
                    new String[]{"name", "price", "barcode", "category", "sub_category", "sub_category_id", "num_page", "prg_language", "main_ingredient", "min_years ", "music", "video", "software"},
                    "_id = ?",
                    new String[]{Integer.toString(productId)},
                    null,
                    null,
                    null);
            //Переход к первой записи в курсоре
            if (cursor.moveToFirst()) {
                //Для идентификации типа продукта используется ID(в таблице "t_product" поле "sub_category_id"):
                // Книги{1 - прогр-е,2 - кулинария,3 - эзотерика},
                // диски{
                // музыка{4 - cd, 5 - dvd},
                // видео{6 - cd, 7 - dvd},
                // софт{8 - cd, 9 - dvd}
                // }
                String productName = cursor.getString(0);
                int productPrice = cursor.getInt(1);
                String productBarCode = cursor.getString(2);
                String productCategory = cursor.getString(3);
                String productSubCategory = cursor.getString(4);
                int sub_cat_id = cursor.getInt(5);
                int num_page;
                String music, video, soft;
                Log.i("name", productName);
                Log.i("productPrice", Integer.toString(productPrice));
                Log.i("productBarCode", productBarCode);
                Log.i("productCategory", productCategory);
                Log.i("productSubCategory", productSubCategory);

                TextView productNameView = (TextView) findViewById(R.id.product_name);
                TextView productCategoryView = (TextView) findViewById(R.id.product_category);
                TextView productSubCategoryView = (TextView) findViewById(R.id.product_sub_category);
                TextView productPriceView = (TextView) findViewById(R.id.product_price);
                TextView productBarCodeView = (TextView) findViewById(R.id.product_barcode);
                TextView productExtraFirst = (TextView) findViewById(R.id.extra_first);
                TextView productExtraSecond = (TextView) findViewById(R.id.extra_second);
                TextView productExtraFirstDesc = (TextView) findViewById(R.id.extra_first_desc);
                TextView productExtraSecondDesc = (TextView) findViewById(R.id.extra_second_desc);
                switch (sub_cat_id) {
                    case 1://Книги - прогр-е
                        num_page = cursor.getInt(6);
                        String prg_lang = cursor.getString(7);
                        productExtraFirstDesc.setText("Количество страниц:");
                        productExtraSecondDesc.setText("Язык программирования:");
                        productExtraFirst.setText(Integer.toString(num_page));
                        productExtraSecond.setText(prg_lang);
                        Log.i("prog book:", Integer.toString(num_page));
                        break;
                    case 2://Книги - кулинария
                        num_page = cursor.getInt(6);
                        String main_ingredient = cursor.getString(8);
                        productExtraFirstDesc.setText("Количество страниц:");
                        productExtraSecondDesc.setText("Главный ингредиент:");
                        productExtraFirst.setText(Integer.toString(num_page));
                        productExtraSecond.setText(main_ingredient);
                        break;
                    case 3://Книги - эзотерика
                        num_page = cursor.getInt(6);
                        int min_years = cursor.getInt(9);
                        productExtraFirstDesc.setText("Количество страниц:");
                        productExtraSecondDesc.setText("Минимальный возраст читателя:");
                        productExtraFirst.setText(Integer.toString(num_page));
                        productExtraSecond.setText(Integer.toString(min_years));
                        break;
                    case 4:
                        music = cursor.getString(10);
                        productExtraFirstDesc.setText("Музыка:");
                        productExtraFirst.setText(music);
                        break;
                    case 5:
                        music = cursor.getString(10);
                        productExtraFirstDesc.setText("Музыка:");
                        productExtraFirst.setText(music);
                        break;
                    case 6:
                        video = cursor.getString(11);
                        productExtraFirstDesc.setText("Видео:");
                        productExtraFirst.setText(video);
                        break;
                    case 7:
                        video = cursor.getString(11);
                        productExtraFirstDesc.setText("Видео:");
                        productExtraFirst.setText(video);
                        break;
                    case 8:
                        soft = cursor.getString(12);
                        productExtraFirstDesc.setText("ПО:");
                        productExtraFirst.setText(soft);
                        break;
                    case 9:
                        soft = cursor.getString(12);
                        productExtraFirstDesc.setText("ПО:");
                        productExtraFirst.setText(soft);
                        break;
                }


                productNameView.setText(productName);
                productCategoryView.setText(productCategory);
                productSubCategoryView.setText(productSubCategory);
                productPriceView.setText(Integer.toString(productPrice));
                productBarCodeView.setText(productBarCode);


                //добавить кнопку "избранное"
            }
            cursor.close();
            db.close();
        } catch (SQLiteException e) {
            Toast toast = Toast.makeText(this, "Database unavailable", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}
