package com.example.eduardo.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText edValor1,edValor2;
    TextView tvResultado;
    double resultado;
    double val1,val2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edValor1 = (EditText)findViewById(R.id.edValor1);
        edValor2 = (EditText)findViewById(R.id.edValor2);

        tvResultado = (TextView)findViewById(R.id.tvResultado);

    }

    public void somar(View view) {

        val1 = Double.parseDouble(edValor1.getText().toString());
        val2 = Double.parseDouble(edValor2.getText().toString());

        resultado = val1 + val2;

        tvResultado.setText("Resultado da Soma: "+resultado);
    }

    public void subtrair(View view) {
        val1 = Double.parseDouble(edValor1.getText().toString());
        val2 = Double.parseDouble(edValor2.getText().toString());

        resultado = val1 - val2;

        tvResultado.setText("Resultado da Subtração: "+resultado);
    }

    public void multiplicar(View view) {
        val1 = Double.parseDouble(edValor1.getText().toString());
        val2 = Double.parseDouble(edValor2.getText().toString());

        resultado = val1 * val2;

        tvResultado.setText("Resultado da Multiplicação: "+resultado);

    }

    public void dividir(View view) {
        val1 = Double.parseDouble(edValor1.getText().toString());
        val2 = Double.parseDouble(edValor2.getText().toString());

        resultado = val1 / val2;

        tvResultado.setText("Resultado da Divisão: "+resultado);

    }
}
