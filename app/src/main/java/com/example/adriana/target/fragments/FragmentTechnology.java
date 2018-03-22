package com.example.adriana.target.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.adriana.target.AdapterProduct;
import com.example.adriana.target.R;
import com.example.adriana.target.beans.Category;
import com.example.adriana.target.beans.City;
import com.example.adriana.target.beans.ItemProduct;
import com.example.adriana.target.beans.Store;
import com.example.adriana.target.database.DatabaseHandler;
import com.example.adriana.target.database.ItemProductControl;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by adriana on 01/03/2018.
 */

public class FragmentTechnology extends android.support.v4.app.Fragment{

    public FragmentTechnology(){

    }

    RecyclerView.Adapter adapter;
    ArrayList<ItemProduct> products;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        RecyclerView.LayoutManager mLayoutManager;

        View view = inflater.inflate(R.layout.fragment_technology, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.fragment_recycler_view);

        recyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);

        products = new ArrayList<ItemProduct>();

        DatabaseHandler dh = DatabaseHandler.getInstance(FragmentTechnology.this.getContext());

        ItemProductControl categoryProd = new ItemProductControl();

        products = categoryProd.getItemProductsByCategory(0,dh);
//
//        ItemProduct product = new ItemProduct();
//        product.setCode(1);
//        product.setTitle("Mac");
//        product.setPicture(2);
//        product.setDescription("");
//        Store store = new Store();
//        store.setName("BEST BUY");
//        store.setCity(new City(1,"Guadalajara"));
//        store.setPhone("3311344912");
//        product.setStore(store);
//        product.setCategory(new Category(1,"TECHNOLOGY"));
//        products.add(product);


        adapter = new AdapterProduct(getActivity(), products,getContext());
        recyclerView.setAdapter(adapter);
        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        ItemProduct itemProduct = data.getParcelableExtra("TAB");
        Iterator<ItemProduct> iterator = this.products.iterator();
        int position = 0;
        while(iterator.hasNext()){
            ItemProduct item = iterator.next();
            if(item.getCode() == itemProduct.getCode()){
                products.set(position, itemProduct);
                break;
            }
            position++;
        }
        adapter.notifyDataSetChanged();
    }


}
