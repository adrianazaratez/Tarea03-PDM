package com.example.adriana.target;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.adriana.target.beans.ItemProduct;

public class ActivityProduct extends AppCompatActivity {

    EditText title;
    EditText store;
    EditText location;
    EditText phone;
    ImageView image;

    Button save;
    Button cancel;

    ItemProduct item;
    ListView listView;
    ItemProduct productThingui;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        title = findViewById(R.id.activity_product_name);
        store = findViewById(R.id.activity_product_store);
        location = findViewById(R.id.activity_product_location);
        phone = findViewById(R.id.activity_product_phone);
        image = findViewById(R.id.activity_product_image);
        save = findViewById(R.id.activity_product_save);
        cancel = findViewById(R.id.activity_product_cancel);

        int i[]= {};
        try {
            if (getIntent().getExtras() != null) {
                item = getIntent().getParcelableExtra("TAB");
                if (item != null) {
                    title.setText(item.getTitle());
                    store.setText(item.getStore());
                    location.setText(item.getLocation());
                    phone.setText(item.getPhone());
                    switch (item.getPicture()){
                        case 0:
                            image.setImageResource(R.drawable.lavadora);
                            break;
                        case 1:
                            image.setImageResource(R.drawable.estereo);
                            break;
                        case 2:
                            image.setImageResource(R.drawable.mac);
                            break;
                        case 3:
                            image.setImageResource(R.drawable.alienware);
                            break;
                        case 4:
                            image.setImageResource(R.drawable.lanix);
                            break;
                        case 5:
                            image.setImageResource(R.drawable.cama);
                            break;
                        case 6:
                            image.setImageResource(R.drawable.sillon);
                            break;
                        default:
                            image.setImageResource(R.drawable.mac);
                            break;
                    }
                }
            }
        }catch(Exception e){

        }


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                productThingui = new ItemProduct(title.getText().toString(),
                                                store.getText().toString(),
                                                location.getText().toString(),
                                                phone.getText().toString(),
                                                item.getPicture(),item.getCode());
                Intent intent = new Intent();
                intent.putExtra("TAB",productThingui);
                setResult(RESULT_OK,intent);
                finish();
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });
    }
}
