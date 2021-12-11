package com.example.giuaky08;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.adapter.ImageAdapter;
import com.example.model.ImageProduct;
import com.example.model.Product;

import java.util.ArrayList;

public class AddActivity extends AppCompatActivity {
    TextView txtTitle;
    EditText  edtName, edtDes;
    ImageView imvPhoto;
    Button btnChange, btnSave, btnCancel;
    Product selectedProduct;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        linkView();
       addEvent();
    }

    private void addEvent() {
        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog= new Dialog(AddActivity.this);
                dialog.setContentView(R.layout.dialog_image);
                GridView gvImage= dialog.findViewById(R.id.gvImage);
                ArrayList<ImageProduct> imageProducts = new ArrayList<>();
                imageProducts.add(new ImageProduct(R.drawable.beer333));
                imageProducts.add(new ImageProduct(R.drawable.hanoi));
                imageProducts.add(new ImageProduct(R.drawable.heineken));
                imageProducts.add(new ImageProduct(R.drawable.larue));
                imageProducts.add(new ImageProduct(R.drawable.saigon));
                imageProducts.add(new ImageProduct(R.drawable.sapporo));
                imageProducts.add(new ImageProduct(R.drawable.tiger));
                imageProducts.add(new ImageProduct(R.drawable.larue));
                imageProducts.add(new ImageProduct(R.drawable.tiger));
                ImageAdapter adapter= new ImageAdapter(AddActivity.this,R.layout.item_layout_image,imageProducts);

            }
        });
    }

    private void linkView() {
        imvPhoto=findViewById(R.id.imvPhoto);
        edtName=findViewById(R.id.edtName);
        edtDes=findViewById(R.id.edtDes);
        btnSave=findViewById(R.id.btnSave);
        btnCancel=findViewById(R.id.btnCancel);
        btnChange=findViewById(R.id.btnEdit);
    }
}
