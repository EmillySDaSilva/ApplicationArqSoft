package com.example.applicationarqsoft;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class TerceiraActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terceira);

        Intent intent = new Intent(this, MyIntentService.class);
        intent.putExtra("TELA", "Tela3");
        startService(intent);

        List<MyContact> contact = ContactsHelper.getContacts(this);
        if (contact.size()>=3){
            contact.get(2);
        }

        TextView textFinal = findViewById(R.id.texto3);
        Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener(
                v -> startActivity(new Intent(this, MainActivity.class))

        );


    }
}