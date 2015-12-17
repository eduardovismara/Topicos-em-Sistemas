package com.eduardo.applogin.cardapioapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CadastroLanche extends AppCompatActivity {

    EditText edtNome,edtIngredientes,edtValor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_lanche);

        edtNome = (EditText) findViewById(R.id.edtNome);
        edtIngredientes = (EditText) findViewById(R.id.edtIngredientes);
        edtValor= (EditText) findViewById(R.id.edtValor);

    }


    public void cadatrar(View view) {

        String nomeLanche = edtNome.getText().toString();
        String ingredientes = edtIngredientes.getText().toString();
        double valor = Double.parseDouble(edtValor.getText().toString());


        if (nomeLanche.equals("") || ingredientes.equals("") || valor<=0) {
            Toast.makeText(getApplicationContext(), "Nenhum campo pode estar vazio!", Toast.LENGTH_LONG).show();
        }else{
            Lanches l = new Lanches();

            l.setNomeLanche(nomeLanche);
            l.setIngredientes(ingredientes);
            l.setValor(valor);

            Colecoes.getInstance().getLanches().add(l);

            Toast.makeText(getApplicationContext(), "Lanche cadastrado com sucesso!", Toast.LENGTH_LONG).show();
            finish();
        }


    }

    public void voltar(View view) {
        finish();
    }
}
