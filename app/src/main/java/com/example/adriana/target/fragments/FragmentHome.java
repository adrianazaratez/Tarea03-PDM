package com.example.adriana.target.fragments;

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
import com.example.adriana.target.beans.ItemProduct;
import com.example.adriana.target.database.DatabaseHandler;
import com.example.adriana.target.database.ItemProductControl;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by adriana on 01/03/2018.
 */

public class FragmentHome extends android.support.v4.app.Fragment {

    RecyclerView.Adapter adapter;
    ArrayList<ItemProduct> products;
    public FragmentHome(){

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        RecyclerView.LayoutManager mLayoutManager;

        View view = inflater.inflate(R.layout.fragment_technology, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.fragment_recycler_view);

        recyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);

        products = new ArrayList<>();

        DatabaseHandler dh = DatabaseHandler.getInstance(FragmentHome.this.getContext());

        ItemProductControl categoryProd = new ItemProductControl();

        products = categoryProd.getItemProductsByCategory(1,dh);
        /*
        products.add(new ItemProduct(getString(R.string.home_name_1),getString(R.string.home_store_1),getString(R.string.home_location_1),getString(R.string.home_phone_1), 5,5));
        products.add(new ItemProduct(getString(R.string.home_name_2),getString(R.string.home_store_2),getString(R.string.home_location_2),getString(R.string.home_phone_2),6,6));
*/
        adapter = new AdapterProduct(getActivity(), products, getContext());
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
