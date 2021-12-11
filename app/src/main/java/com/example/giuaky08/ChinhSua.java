package com.example.giuaky08;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.adapter.ImageAdapter;
import com.example.model.ImageProduct;
import com.example.model.Product;

import java.util.ArrayList;

public class ChinhSua extends AppCompatActivity {

    EditText edtName, edtDes;
    Button btnUpdate, btnCancel, btnEdit;
    ImageView imvPhoto;
    Product selectedProduct;
    ImageProduct im;
    int imageId = R.drawable.heineken;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        linkViews();
        getData();
        addEvents();
    }

    private void getData() {
        Intent intent= getIntent();
        selectedProduct= (Product) intent.getSerializableExtra("san pham");
        edtName.setText(selectedProduct.getProductName());
        edtDes.setText(selectedProduct.getProductDes());
        imvPhoto.setImageResource(selectedProduct.getProductImage());
        imageId=selectedProduct.getProductImage();
    }

    private void linkViews() {
        edtName = findViewById(R.id.edtName);
        edtDes = findViewById(R.id.edtDes);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnCancel = findViewById(R.id.btnCancel);
        btnEdit = findViewById(R.id.btnEdit);
        imvPhoto = findViewById(R.id.imvPhoto);
    }

    private void addEvents() {
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(ChinhSua.this);
                dialog.setContentView(R.layout.dialog_image);

                ImageView imageView =dialog.findViewById(R.id.imvPhoto);
                GridView gvImage = dialog.findViewById(R.id.gvImage);
                ArrayList<ImageProduct> imageProducts = new ArrayList<>();
                imageProducts.add(new ImageProduct(R.drawable.beer333));
                imageProducts.add(new ImageProduct(R.drawable.hanoi));
                imageProducts.add(new ImageProduct(R.drawable.heineken));
                imageProducts.add(new ImageProduct(R.drawable.larue));
                imageProducts.add(new ImageProduct(R.drawable.tiger));
                imageProducts.add(new ImageProduct(R.drawable.saigon));
                imageProducts.add(new ImageProduct(R.drawable.sapporo));
                ImageAdapter adapter = new ImageAdapter(ChinhSua.this, R.layout.item_layout_image, imageProducts);
                gvImage.setAdapter(adapter);
                gvImage.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        im= (ImageProduct) adapter.getItem(i);
                        imvPhoto.setImageResource(bi.getImageId());
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name= edtName.getText().toString(), des= edtDes.getText().toString();
                imageId= im.getImageId();
                if(name.equals("")||des.equals("")){
                    AlertDialog.Builder builder= new AlertDialog.Builder(ChinhSua.this);
                    builder.setTitle("Lỗi!");
                    builder.setMessage("Vui lòng nhập đủ thông tin");
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });

                    builder.create().show();
                }
                else {
                    try {
                        MainActivity.db.execSql("UPDATE "+MyDataBase.TBL_NAME+" SET "+MyDataBase.COL_W_IMAGE+"="+imageId+","+MyDataBase.COL_W_NAME+ "='"+name+"', "+MyDataBase.COL_W_DES+"='"+des+"' WHERE "+MyDataBase.COL_W_ID+"="+selectedProduct.getProductId());
                        Toast.makeText(ChinhSua.this, "Success!", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                    catch (Exception exception){
                        Toast.makeText(ChinhSua.this, "Fail!", Toast.LENGTH_SHORT).show();
                        finish();
                    }

                }



            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
