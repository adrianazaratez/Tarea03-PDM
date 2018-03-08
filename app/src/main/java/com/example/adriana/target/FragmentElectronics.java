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

public class FragmentElectronics extends android.support.v4.app.Fragment{


    public FragmentElectronics(){

    }

    public void changeData(){

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

        ArrayList<ItemProduct> electronics = new ArrayList<>();
        electronics.add(new ItemProduct(getString(R.string.elec_name_1),getString(R.string.elec_store_1),getString(R.string.elec_location_1),getString(R.string.elec_phone_1), 0,0));
        electronics.add(new ItemProduct(getString(R.string.elec_name_2),getString(R.string.elec_store_2),getString(R.string.elec_location_2),getString(R.string.elec_phone_2),1,1));

        adapter = new AdapterProduct(getActivity(), electronics, getContext());
        recyclerView.setAdapter(adapter);
        return view;
    }

}
