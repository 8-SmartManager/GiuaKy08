package com.example.giuaky08;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.adapter.ImageAdapter;
import com.example.model.ImageProduct;
import com.example.model.Product;

import java.util.ArrayList;

public class AddActivity extends AppCompatActivity {

    EditText edtName, edtDes;
    Button btnChange, btnSave, btnCancel;
    ImageView imvImage;

    ImageProduct bi;
    int imageId= R.drawable.heineken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        linkViews();
        imvImage.setImageResource(R.drawable.heineken);
        addEvent();

    }

    private void addEvent() {
        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog= new Dialog(AddActivity.this);
                dialog.setContentView(R.layout.dialog_image);
                GridView gvImage=dialog.findViewById(R.id.gvImage);
                ArrayList<ImageProduct> image_beers= new ArrayList<>();
                image_beers.add(new ImageProduct(R.drawable.beer333));
                image_beers.add(new ImageProduct(R.drawable.hanoi));
                image_beers.add(new ImageProduct(R.drawable.heineken));
                image_beers.add(new ImageProduct(R.drawable.larue));
                image_beers.add(new ImageProduct(R.drawable.sapporo));
                image_beers.add(new ImageProduct(R.drawable.saigon));
                image_beers.add(new ImageProduct(R.drawable.tiger));
                image_beers.add(new ImageProduct(R.drawable.hanoi));
                image_beers.add(new ImageProduct(R.drawable.beer333));
                ImageAdapter adapter= new ImageAdapter(AddActivity.this,R.layout.item_layout_image,image_beers);
                gvImage.setAdapter(adapter);
                gvImage.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        bi= (ImageProduct) adapter.getItem(i);
                        imvImage.setImageResource(bi.getImageId());
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name= edtName.getText().toString(), des= edtDes.getText().toString();
                imageId= bi.getImageId();
                if(name.equals("")||des.equals("")){
                    AlertDialog.Builder builder= new AlertDialog.Builder(AddActivity.this);
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
                        MainActivity.db.execSql("INSERT INTO "+MyDataBase.TBL_NAME+" VALUES(null,"+imageId+", '"+name+"', '"+des+"')");
                        Toast.makeText(AddActivity.this, "Success!", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                    catch (Exception exception){
                        Toast.makeText(AddActivity.this, "Fail!", Toast.LENGTH_SHORT).show();
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



    private void linkViews() {
        edtName=findViewById(R.id.edtName);
        edtDes=findViewById(R.id.edtDes);
        btnCancel=findViewById(R.id.btnCancel);
        btnChange=findViewById(R.id.btnEdit);
        btnSave=findViewById(R.id.btnSave);
        imvImage=findViewById(R.id.imvPhotoProduct);

    }
}
