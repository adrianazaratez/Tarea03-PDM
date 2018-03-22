package com.example.adriana.target;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.adriana.target.beans.ItemProduct;

import java.util.ArrayList;

import android.widget.Toast;


/**
 * Created by adriana on 26/02/2018.
 */

public class AdapterProduct extends RecyclerView.Adapter<AdapterProduct.ViewHolder>{

    ArrayList<ItemProduct> products;
    private Context context;

    public AdapterProduct(FragmentActivity activity, ArrayList<ItemProduct> products, Context context){
        this.products = products;
        this.context = context;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView mTitle;
        public TextView mStore;
        public TextView mLocation;
        public TextView mPhone;
        public ImageView mImage;
        public CardView mCard;
        public Button mSeeMore;
        public Button mShare;

        public ViewHolder (View v){
            super(v);
            mTitle = v.findViewById(R.id.item_product_title);
            mStore = v.findViewById(R.id.item_product_store);
            mLocation = v.findViewById(R.id.item_product_location);
            mPhone = v.findViewById(R.id.item_product_phone);
            mImage = v.findViewById(R.id.item_product_image);
            mCard = v.findViewById(R.id.card_view);
            mShare = v.findViewById(R.id.item_product_share);
            mSeeMore = v.findViewById(R.id.item_product_detail);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product,parent,false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.mTitle.setText(products.get(position).getTitle());
        holder.mStore.setText(products.get(position).getStore().getName());
        holder.mLocation.setText(products.get(position).getStore().getCity().getName());
        holder.mPhone.setText(products.get(position).getStore().getPhone());
        switch(products.get(position).getPicture()){
            case 0:
                holder.mImage.setImageResource(R.drawable.lavadora);
                break;
            case 1:
                holder.mImage.setImageResource(R.drawable.estereo);
                break;
            case 2:
                holder.mImage.setImageResource(R.drawable.mac);
                break;
            case 3:
                holder.mImage.setImageResource(R.drawable.alienware);
                break;
            case 4:
                holder.mImage.setImageResource(R.drawable.lanix);
                break;
            case 5:
                holder.mImage.setImageResource(R.drawable.cama);
                break;
            case 6:
                holder.mImage.setImageResource(R.drawable.sillon);
                break;
            default:
                holder.mImage.setImageResource(R.drawable.mac);
                break;
        }

        holder.mPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL,
                        Uri.parse("tel:" + products.get(position).getStore().getPhone()));
                v.getContext().startActivity(intent);
            }
        });

        holder.mSeeMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ItemProduct product = new ItemProduct();
                product.setTitle(products.get(position).getTitle());
                product.setStore(products.get(position).getStore());
                product.setPicture(products.get(position).getPicture());
                product.setCode(products.get(position).getCode());
                Intent intent = new Intent();
                intent.setClass(context,ActivityProduct.class);
                intent.putExtra("TAB",product);
                ((ActivityMain) context).startActivityForResult(intent,products.get(position).getCode());
            }
        });
        holder.mShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ItemProduct product = new ItemProduct();
                product.setTitle(products.get(position).getTitle());
                product.setStore(products.get(position).getStore());
                product.setPicture(products.get(position).getPicture());
                product.setCode(products.get(position).getCode());
                Intent intent = new Intent();
                intent.setClass(context,ActivityProduct.class);
                intent.putExtra("TAB",product);
                ((ActivityMain) context).startActivityForResult(intent,products.get(position).getCode());
            }
        });
        holder.mCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ItemProduct product = new ItemProduct();
                product.setTitle(products.get(position).getTitle());
                product.setStore(products.get(position).getStore());
                product.setPicture(products.get(position).getPicture());
                product.setCode(products.get(position).getCode());
                Intent intent = new Intent();
                intent.setClass(context,ActivityProduct.class);
                intent.putExtra("TAB",product);
                ((ActivityMain) context).startActivityForResult(intent,products.get(position).getCode());
            }
        });
    }


    @Override
    public int getItemCount() {
        return products.size();
    }
}
