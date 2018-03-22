package com.example.adriana.target;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.adriana.target.beans.City;
import com.example.adriana.target.beans.Store;
import com.example.adriana.target.beans.User;
import com.example.adriana.target.database.DatabaseHandler;
import com.example.adriana.target.database.StoreControl;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class ActivitySplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        TimerTask task = new TimerTask(){
            @Override
            public void run(){
                User user = loadUser();
                Intent intent;
                if(user.isLogged()){
                    intent = new Intent(ActivitySplashScreen.this,ActivityMain.class);
                }else{
                    intent = new Intent(ActivitySplashScreen.this,ActivityLogin.class);
                }
                startActivity(intent);
                finish();
            }

        };
        Timer timer = new Timer();
        timer.schedule(task,2000);

        consult();
    }

    public User loadUser(){
        SharedPreferences sharedPreferences = getSharedPreferences("com.example.adriana.USER_PREFERENCES",MODE_PRIVATE);
        User user = new User();
        user.setName(sharedPreferences.getString("NAME",null));
        user.setPassword(sharedPreferences.getString("PWD",null));
        user.setLogged(sharedPreferences.getBoolean("LOGGED",false));
        sharedPreferences = null;
        return user;
    }

    public void consult(){
        DatabaseHandler dh = DatabaseHandler.getInstance(ActivitySplashScreen.this);
        StoreControl control = new StoreControl();
        ArrayList<Store> stores = new ArrayList<>();
        stores = control.getStores(dh);
        City city = new City(1,"Guadalajara");

        if(stores.size() < 1){
            Store store1 = new Store(1,"Best Buy","3311344912",1,18.023,23.1231,city);
            Store store2 = new Store(2,"Mac Store","3313536913",2,18.032,23.1112,city);
            Store store3 = new Store(3,"Saint Jhonny","3331988864",3,18.020,23.1312,city);
            control.addStore(store1,dh);
            control.addStore(store2,dh);
            control.addStore(store3,dh);
        }

    }
}
