package com.example.eduardo.login;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.eduardo.intent.R;

public class Tela2Activity extends AppCompatActivity {

    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);

        Intent i = new Intent();
        i = getIntent();

        String usuario = i.getStringExtra("usuario");

        text = (TextView) findViewById(R.id.textView3);

        text.setText(getResources().getText(R.string.bemvindo) +" "+usuario);

    }

}
