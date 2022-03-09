package com.example.applicationarqsoft;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;


public class MyIntentService extends IntentService {


    public MyIntentService() {

        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
                String name = intent.getStringExtra("TELA");
                Toast.makeText(this, "Nome da "+name, Toast.LENGTH_LONG).show();

        }
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d("HSS", "Service on destroy");
    }

}