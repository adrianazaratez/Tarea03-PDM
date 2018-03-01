package com.example.adriana.target;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.adriana.target.beans.ItemProduct;

import java.util.ArrayList;

/**
 * Created by adriana on 01/03/2018.
 */

public class FragmentTechnology extends android.support.v4.app.Fragment{

    public FragmentTechnology(){

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        RecyclerView.Adapter adapter;
        RecyclerView.LayoutManager mLayoutManager;

        View view = inflater.inflate(R.layout.fragment_technology, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.fragment_recycler_view);

        recyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);

        ArrayList<ItemProduct> products = new ArrayList<ItemProduct>();
        products.add(new ItemProduct("Mac", "BestBuy", "+52 3315115016", "Plaza Galerías Guadalajara", getResources().getDrawable(R.drawable.mac)));
        products.add(new ItemProduct("AlienWare", "DELL", "+52 3331988864", "Plaza Ciudadela Lifestyle Guadalajara", getResources().getDrawable(R.drawable.alienware)));
        products.add(new ItemProduct("Lanix", "Saint Johny", "+52 3313536913", "Zapopan", getResources().getDrawable(R.drawable.lanix)));


        adapter = new AdapterProduct(getActivity(), products);
        recyclerView.setAdapter(adapter);
        return view;
    }
}
