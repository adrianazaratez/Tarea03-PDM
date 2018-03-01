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

public class FragmentHome extends android.support.v4.app.Fragment {


    public FragmentHome(){

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

        ArrayList<ItemProduct> products = new ArrayList<>();
        products.add(new ItemProduct("Bed Sealy","DICO","+52 3315115016","Mariano Otero Guadalajara", getResources().getDrawable(R.drawable.cama)));
        products.add(new ItemProduct("Individual Couch RED","DICO", "+52 3331988864","Mariano Otero Guadalajara", getResources().getDrawable(R.drawable.sillon)));

        adapter = new AdapterProduct(getActivity(), products);
        recyclerView.setAdapter(adapter);
        return view;
    }
}
