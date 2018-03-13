package com.example.adriana.target;

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

public class FragmentElectronics extends android.support.v4.app.Fragment{


    RecyclerView.Adapter adapter;
    ArrayList<ItemProduct> electronics;

    public FragmentElectronics(){

    }

    public void changeData(){

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        RecyclerView.LayoutManager mLayoutManager;

        View view = inflater.inflate(R.layout.fragment_technology, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.fragment_recycler_view);

        recyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);

        electronics = new ArrayList<>();
        electronics.add(new ItemProduct(getString(R.string.elec_name_1),getString(R.string.elec_store_1),getString(R.string.elec_location_1),getString(R.string.elec_phone_1), 0,0));
        electronics.add(new ItemProduct(getString(R.string.elec_name_2),getString(R.string.elec_store_2),getString(R.string.elec_location_2),getString(R.string.elec_phone_2),1,1));

        adapter = new AdapterProduct(getActivity(), electronics, getContext());
        recyclerView.setAdapter(adapter);
        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        ItemProduct itemProduct = data.getParcelableExtra("TAB");
        Iterator<ItemProduct> iterator = this.electronics.iterator();
        int position = 0;
        while(iterator.hasNext()){
            ItemProduct item = iterator.next();
            if(item.getCode() == itemProduct.getCode()){
                electronics.set(position, itemProduct);
                break;
            }
            position++;
        }
        adapter.notifyDataSetChanged();
    }

}
