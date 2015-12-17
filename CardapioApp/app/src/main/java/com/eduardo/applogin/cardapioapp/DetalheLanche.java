package com.eduardo.applogin.cardapioapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetalheLanche extends AppCompatActivity {

    TextView txtNome,txtDetalhe,txtValor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_lanche);

        Intent i = new Intent();
        i = getIntent();

        String nome = i.getStringExtra("nome");
        String detalhe = i.getStringExtra("detalhe");
        String valor = i.getStringExtra("valor");


        txtNome = (TextView) findViewById(R.id.txtNome);
        txtDetalhe = (TextView) findViewById(R.id.txtDetalhe);
        txtValor = (TextView) findViewById(R.id.txtValor);

        txtNome.setText(nome);
        txtDetalhe.setText(detalhe);
        txtValor.setText("Valor: R$ "+valor);
    }
}
