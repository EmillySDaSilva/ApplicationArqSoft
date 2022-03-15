package com.example.applicationarqsoft;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import java.util.List;

public class SegundaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);
        Intent intent = new Intent(this, MyIntentService.class);
        intent.putExtra("TELA", "Tela2");
        startService(intent);
        List<MyContact> contact = ContactsHelper.getContacts(this);
        if (contact.size()>=2){
            contact.get(1);
        }

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(
                v -> startActivity(new Intent(this, TerceiraActivity.class))

        );

    }
}