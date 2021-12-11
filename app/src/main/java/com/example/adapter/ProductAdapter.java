package com.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.giuaky08.R;
import com.example.model.Product;

import org.w3c.dom.Text;

import java.util.List;

public class ProductAdapter extends BaseAdapter {
    Context context;
    int item_product;
    List<Product> productList;

    public ProductAdapter(Context context, int item_product, List<Product> productList) {
        this.context = context;
        this.item_product = item_product;
        this.productList = productList;
    }

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
        ProductAdapter.ViewHolder holder;
        if (view==null)
        {
            holder = new ViewHolder();
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(item_product,null);
            holder.imvThumb= view.findViewById(R.id.imvThumb);
            holder.txtName= view.findViewById(R.id.txtName);
            holder.txtDes= view.findViewById(R.id.txtDes);



            view.setTag(holder);
        }
        else {holder= (ProductAdapter.ViewHolder) view.getTag();
        }
        Product product = productList.get(i);
        holder.imvThumb.setImageResource(product.getProductImage());
        holder.txtName.setText(product.getProductName());
        holder.txtDes.setText(product.getProductDes());

        return view;
    }

    public static class ViewHolder{
        ImageView imvThumb;
        TextView txtName, txtDes;
    }



}
