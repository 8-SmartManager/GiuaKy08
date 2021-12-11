package com.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.giuaky08.R;
import com.example.model.ImageProduct;
import com.example.model.Product;

import java.util.List;

public class ImageAdapter extends BaseAdapter {
    Context context;
    int item_product;
    List<ImageProduct> productList;

    @Override
    public int getCount() {
        return productList.size();
    }

    @Override
    public Object getItem(int i) {
        return productList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view==null)
        {
            holder = new ViewHolder();
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(item_product,null);
            holder.imvThumb= view.findViewById(R.id.imvThumb);




            view.setTag(holder);
        }
        else {holder= (ViewHolder) view.getTag();
        }
        ImageProduct product = productList.get(i);
        holder.imvThumb.setImageResource(product.getImageId());


        return view;
    }

    public static class ViewHolder{
        ImageView imvThumb;

    }
}
