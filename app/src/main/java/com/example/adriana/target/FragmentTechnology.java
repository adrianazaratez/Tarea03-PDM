package com.example.adriana.target;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.adriana.target.beans.ItemProduct;

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
        products.add(new ItemProduct(getString(R.string.tech_name_1), getString(R.string.tech_store_1), getString(R.string.tech_location_1), getString(R.string.tech_phone_1), 2,2));
        products.add(new ItemProduct(getString(R.string.tech_name_2), getString(R.string.tech_store_2),  getString(R.string.tech_location_2),getString(R.string.tech_phone_2),3,3));
        products.add(new ItemProduct(getString(R.string.tech_name_3), getString(R.string.tech_store_3),  getString(R.string.tech_location_3),getString(R.string.tech_phone_3),4,4));


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
