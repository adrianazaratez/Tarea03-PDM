package com.example.adriana.target;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.adriana.target.beans.Category;
import com.example.adriana.target.beans.ItemProduct;
import com.example.adriana.target.beans.Store;
import com.example.adriana.target.database.CategoryControl;
import com.example.adriana.target.database.DatabaseHandler;
import com.example.adriana.target.database.ItemProductControl;
import com.example.adriana.target.database.StoreControl;

import java.util.ArrayList;
import java.util.List;

public class ActivityItem extends AppCompatActivity {

    Spinner image, category, store;
    EditText title;
    Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        image = findViewById(R.id.activity_item_spinner1);
        category = findViewById(R.id.activity_item_spinner2);
        store = findViewById(R.id.activity_item_spinner3);
        title = findViewById(R.id.activity_item_titulo);
        save = findViewById(R.id.activity_item_save);

        final DatabaseHandler dh = DatabaseHandler.getInstance(ActivityItem.this);
        StoreControl storeC = new StoreControl();
        CategoryControl categoryC = new CategoryControl();

        ArrayList<Store> stores = new ArrayList<>();
        stores = storeC.getStores(dh);
        List<String> values = new ArrayList<>();
        for(int i = 0; i < stores.size(); i++){
            values.add(stores.get(i).getName());
        }

        ArrayList<Category> categories = new ArrayList<>();
        categories = categoryC.getAllCategories(dh);
        List<String> values1 = new ArrayList<>();
        for(int i = 0; i < categories.size(); i++){
            values1.add(stores.get(i).getName());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,values);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        store.setAdapter(adapter);

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,values1);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        category.setAdapter(adapter2);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int picture = 0;
                switch (image.getSelectedItem().toString()){
                    case "Mac":
                        picture = 2;break;
                    case "Alienware":
                        picture = 3;break;
                    case "Lanix":
                        picture = 4;break;
                    case "Lavadora":
                        picture = 0;break;
                    case "Sillon":
                        picture = 6;break;
                    case "Estereo":
                        picture = 1;break;
                    case "Cama":
                        picture = 5;break;
                    default:
                        picture = 0;break;
                }
                Store store1 = new Store();
                store1.setName(store.getSelectedItem().toString());
                Category category1 = new Category();
                category1.setName(category.getSelectedItem().toString());
                ItemProduct product = new ItemProduct();
                product.setPicture(picture);
                product.setTitle(title.getText().toString());
                product.setStore(store1);
                product.setCategory(category1);

                ItemProductControl ipc = new ItemProductControl();
                ipc.addItemProduct(product,dh);

                Intent intent = new Intent(ActivityItem.this,ActivityMain.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });
    }
}
