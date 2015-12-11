package com.example.eduardo.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.eduardo.intent.R;

public class TelaCadastro extends AppCompatActivity {

    EditText edtUser,edtPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro);

        edtUser = (EditText) findViewById(R.id.edtUser);
        edtPass = (EditText) findViewById(R.id.edtPass);

    }

    public void voltar(View view) {
        finish();
    }


    public void cadatrar(View view) {

        String usuario = edtUser.getText().toString();
        String senha = edtPass.getText().toString();

        if (usuario.equals("") || senha.equals("")) {
            Toast.makeText(getApplicationContext(), R.string.campovazio, Toast.LENGTH_LONG).show();
        }else{
            Usuarios u = new Usuarios();

            u.setUser(usuario);
            u.setPass(senha);

            Colecoes.getInstance().getUsuarios().add(u);

            Toast.makeText(getApplicationContext(), R.string.cadastradosucesso, Toast.LENGTH_LONG).show();
            finish();
        }



    }
}
