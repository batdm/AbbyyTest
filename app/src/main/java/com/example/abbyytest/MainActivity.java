package com.example.abbyytest;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private SQLiteDatabase db;
    private Cursor productCursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listPapers = (ListView) findViewById(R.id.list_papers);
        try {
            SQLiteOpenHelper productDBHelper = new NewProductDBHelper(this);
            db = productDBHelper.getReadableDatabase();
            productCursor = db.query("t_product", new String[]{"_id", "name", "category", "sub_category"}, null, null, null, null, null);
            Log.v("cursor rows count: ", Integer.toString(productCursor.getCount()));
            CursorAdapter productAdapter = new SimpleCursorAdapter(this,
                    android.R.layout.simple_list_item_2,
                    productCursor,
                    new String[]{"name", "sub_category"},
                    new int[]{android.R.id.text1, android.R.id.text2}, 0);
            listPapers.setAdapter(productAdapter);
        } catch (SQLiteException e) {
            Toast toast = Toast.makeText(this, "Database unavailable:" + e, Toast.LENGTH_SHORT);
            Log.e("DB exception: ", e.getMessage());
            toast.show();
        }
        listPapers.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, ProductActivity.class);
                intent.putExtra(ProductActivity.EXTRA_PRODUCT_ID, (int) id);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (productCursor != null) {
            productCursor.close();
        }
        if (db != null) {
            db.close();
        }

    }
}
