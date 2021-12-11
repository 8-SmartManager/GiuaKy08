package com.example.giuaky08;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.model.Product;

public class ChinhSua extends AppCompatActivity {

    EditText edtName, edtDes;
    Button btnSave, btnCancel, btnEdit;
    ImageView imvPhoto;
    Product selectedProduct;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        linkViews();
        addEvents();
    }

    private void linkViews() {
        edtName = findViewById(R.id.edtName);
        edtDes = findViewById(R.id.edtDes);
        btnSave = findViewById(R.id.btnSave);
        btnCancel = findViewById(R.id.btnCancel);
        btnEdit = findViewById(R.id.btnEdit);
        imvPhoto = findViewById(R.id.imvPhoto);
    }

    private void addEvents() {
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
