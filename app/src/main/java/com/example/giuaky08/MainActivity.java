package com.example.giuaky08;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.adapter.ProductAdapter;
import com.example.model.Product;

import java.time.LocalDate;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvProduct;
    ProductAdapter adapter;
    ArrayList<Product> products;
    MyDataBase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinkViews();
        getData();
        getDataFromDB();

        initData();

    }

    private void initData() {
        adapter = new ProductAdapter(MainActivity.this,R.layout.item_layout, products);
        lvProduct.setAdapter(adapter);
    }

    private void getDataFromDB() {
        products = new ArrayList<>();
        Cursor cursor = db.getData("SELECT * FROM " + MyDataBase.TBL_NAME);
        products.clear();
        while(cursor.moveToNext()){
            products.add(new Product(cursor.getInt(0), cursor.getInt(1), cursor.getString(2), cursor.getString(3)));

        }
        cursor.close();

    }

    private void getData() {
    }

    private void LinkViews() {
        lvProduct=findViewById(R.id.lvProduct);
    }
}