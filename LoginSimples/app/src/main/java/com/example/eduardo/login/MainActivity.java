package com.example.eduardo.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.eduardo.intent.R;

public class MainActivity extends AppCompatActivity {

    EditText edtUser,edtPass;
    TextView tvErro;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtUser = (EditText) findViewById(R.id.edtUser);
        edtPass = (EditText) findViewById(R.id.edtPass);
        tvErro = (TextView) findViewById(R.id.tvErro);

    }


    public void validarLogin(View view) {

        Boolean logado=false;

        String usuario = edtUser.getText().toString();
        String senha = edtPass.getText().toString();

        if (usuario.equals("") || senha.equals("")) {
            Toast.makeText(getApplicationContext(), "Nenhum campo pode estar vazio!", Toast.LENGTH_LONG).show();
        }if (usuario.equals("user") & senha.equals("123")) {
            logado = true;
        }

        if (logado == true) {

                Intent tela2 = new Intent(getBaseContext(), Tela2Activity.class);

                Bundle b = new Bundle();
                b.putString("usuario", usuario);

                tela2.putExtras(b);

                startActivity(tela2);

        }else{
            Toast.makeText(getApplicationContext(), "Usuário ou senha inválido!", Toast.LENGTH_LONG).show();
        }


    }
}
