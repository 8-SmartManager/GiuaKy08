package com.example.giuaky08;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.adapter.ProductAdapter;
import com.example.model.Product;

import java.time.LocalDate;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvProduct;
    ProductAdapter adapter;
    ArrayList<Product> products;
    public static MyDataBase db;
    Product selectedProduct;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getData();
        LinkViews();


        getDataFromDB();
        addEvent();
        registerForContextMenu(lvProduct);

    }

    private void loadData() {
        adapter = new ProductAdapter(MainActivity.this,R.layout.item_layout,getDataFromDB());
        lvProduct.setAdapter(adapter);
    }

    private void addEvent() {
        lvProduct.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                selectedProduct= (Product) adapter.getItem(i);
                return false;
            }
        });
    }
    @Override
    protected void onResume() {
        super.onResume();
        loadData();
    }


    private ArrayList<Product> getDataFromDB() {
        products= new ArrayList<>();
        Cursor cursor =db.getData("SELECT * FROM "+MyDataBase.TBL_NAME);
        products.clear();
        while (cursor.moveToNext()){
            products.add(new Product(cursor.getInt(0),cursor.getInt(1),cursor.getString(2),cursor.getString(3)));
        }
        cursor.close();
        return products;
    }

    private void getData() {
        db= new MyDataBase(this);

    }

    private void LinkViews() {
        lvProduct=findViewById(R.id.lvProduct);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.context_menu, menu);

        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        if(item.getItemId()==R.id.mnEdit){
            //Update data
            Intent intent = new Intent(MainActivity.this, ChinhSua.class);
            //Attach Data
            intent.putExtra("san pham",selectedProduct);

            startActivity(intent);
        }
        else if (item.getItemId()==R.id.mnDelete){
            if(selectedProduct != null){
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Confirm!");
                builder.setMessage("Are you want to delete it?");
                builder.setIcon(android.R.drawable.ic_delete);

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        MainActivity.db.execSql("DELETE FROM "+ MyDataBase.TBL_NAME+" WHERE "+MyDataBase.COL_W_ID + "=" +selectedProduct.getProductId());
                        loadData();
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                builder.create();
                builder.show();
            }



        }



        return super.onContextItemSelected(item);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.mnAddTask);
        {
            Intent intent = new Intent(MainActivity.this,AddActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);

    }
}