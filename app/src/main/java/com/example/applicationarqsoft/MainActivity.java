package com.example.applicationarqsoft;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private MyBroadcastReceiver receiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Intent intent = new Intent(this, MyIntentService.class);
        intent.putExtra("TELA", "Tela1");
        startService(intent);

        Button button1 = findViewById(R.id.button1);

        button1.setOnClickListener(
                v -> startActivity(new Intent(this, SegundaActivity.class))
        );
        List<MyContact> contacts = ContactsHelper.getContacts(this);
        for (MyContact contact: contacts){
            Log.d("ESS", "ID:" + contact.getId()+ ",Name:"+ contact.getName());
        }
        List<MyContact> contact = ContactsHelper.getContacts(this);
        if (contact.size()>=1){
            contact.get(1);
        }

    }
    @Override
    protected void onStop() {
        super.onStop();
        receiver = new MyBroadcastReceiver();
        IntentFilter filter = new IntentFilter(WifiManager.WIFI_STATE_CHANGED_ACTION);
        registerReceiver(receiver, filter);
    }

    class MyBroadcastReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d("ESS", "WiFi mudou!");
        }
    }




}