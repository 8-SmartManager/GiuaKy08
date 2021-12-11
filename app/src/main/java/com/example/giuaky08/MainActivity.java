package com.example.giuaky08;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.model.Product;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvProduct;
    Product adapter;
    ArrayList<Product> products;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinkViews();
    }

    private void LinkViews() {
        lvProduct=findViewById(R.id.lvProduct);
    }
}