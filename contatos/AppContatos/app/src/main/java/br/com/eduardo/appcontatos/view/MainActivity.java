package br.com.eduardo.appcontatos.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import br.com.eduardo.appcontatos.R;
import br.com.eduardo.appcontatos.model.Contato;
import br.com.eduardo.appcontatos.server.ContatoServer;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Bind(R.id.edtNome)
    EditText edtNome;

    @Bind(R.id.edtTelefone)
    EditText edtTelefone;

    @Bind(R.id.edtEmail)
    EditText edtEmail;


    @Bind(R.id.edtId)
    EditText edtId;

    @Bind(R.id.tvResul)
    TextView tvResul;

    List<Contato> contatos;

    private final String url = "http://192.168.1.5:1337/";

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        updateUI();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //Botao de inserção
    @OnClick(R.id.fab)
    public void addContato(View v) {

        boolean inserir = true;

        final Contato c = getContato();

        if (c.getNome().length() == 0){
            Toast.makeText(getBaseContext(), "Informe o nome!", Toast.LENGTH_LONG).show();

            if(edtNome.requestFocus()) {
                getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
            }
            inserir = false;
        }else if (c.getTelefone().length() == 0){
            Toast.makeText(getBaseContext(), "Informe o telefone!", Toast.LENGTH_LONG).show();

            if(edtTelefone.requestFocus()) {
                getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
            }
            inserir = false;
        }else if (c.getEmail().length() == 0){
            Toast.makeText(getBaseContext(), "Informe o email!", Toast.LENGTH_LONG).show();

            if(edtEmail.requestFocus()) {
                getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
            }
            inserir = false;
        }

        if (inserir) {
            ContatoServer contatoServer = retrofit.create(ContatoServer.class);

            contatoServer.addContato(c).enqueue(new Callback<Contato>() {
                @Override
                public void onResponse(Call<Contato> call, Response<Contato> response) {
                    Toast.makeText(getBaseContext(), "Contato adicionado", Toast.LENGTH_LONG).show();
                    c.insert();
                    updateUI();
                }

                @Override
                public void onFailure(Call<Contato> call, Throwable t) {
                    Toast.makeText(getBaseContext(), t.getMessage(), Toast.LENGTH_LONG).show();

                }
            });
        }

    }


    //metodo que deleta um contato
    @OnClick(R.id.btDelete)
    public void delContato(View v) {
        String tmp = edtId.getText().toString();
        if (isNumber(tmp) & tmp.length()>0){
            final long id = Long.parseLong(tmp);

                ContatoServer contatoServer = retrofit.create(ContatoServer.class);
            contatoServer.deleteContatos(id).enqueue(new Callback<Contato>() {
                @Override
                public void onResponse(Call<Contato> call, Response<Contato> response) {
                    Toast.makeText(getBaseContext(), "Usuario removido", Toast.LENGTH_LONG).show();
                    updateUI();
                    Contato c = new Contato(id);
                    c.delete();
                }

                @Override
                public void onFailure(Call<Contato> call, Throwable t) {
                    Toast.makeText(getBaseContext(), t.getMessage(), Toast.LENGTH_LONG).show();

                }
            });
        }else{
            Toast.makeText(getBaseContext(), "ID inválido", Toast.LENGTH_LONG).show();
        }
    }

    //metodo que lista um contato pelo id
    @OnClick(R.id.btBuscaId)
    public void listContato(View v) {
        String tmp = edtId.getText().toString();
        if (isNumber(tmp) & tmp.length()>0){
            long id = Long.parseLong(tmp);

            ContatoServer contatoServer = retrofit.create(ContatoServer.class);
            contatoServer.listContatos(id).enqueue(new Callback<Contato>() {
                @Override
                public void onResponse(Call<Contato> call, Response<Contato> response) {
                    if (response.isSuccessful()) {
                        Contato u = response.body();
                        String a = "ID: " + u.getId() + "\nNome:" + u.getNome() + "\nTelefone: " + u.getTelefone() + "\nEmail: " + u.getEmail() + "\n";
                        tvResul.setText(a);
                        Log.d("codigo: ", String.valueOf(response.code()));
                    }
                }

                @Override
                public void onFailure(Call<Contato> call, Throwable t) {
                    Toast.makeText(getBaseContext(), t.getMessage(), Toast.LENGTH_LONG).show();

                }
            });
        }else{
            Toast.makeText(getBaseContext(), "ID inválido", Toast.LENGTH_LONG).show();
        }
    }

    //metodo que atualiza o contato
    @OnClick(R.id.btUpdate)
    public void updateContato(View v) {
        String tmp = edtId.getText().toString();
        if (isNumber(tmp) & tmp.length()>0){
            long id = Long.parseLong(tmp);

            ContatoServer contatoServer = retrofit.create(ContatoServer.class);
            final Contato c = getContato();

            contatoServer.updateContato(id, c).enqueue(new Callback<Contato>() {
                @Override
                public void onResponse(Call<Contato> call, Response<Contato> response) {
                    Log.d("codigo: ", String.valueOf(response.code()));
                    updateUI();
                    c.update();
                }

                @Override
                public void onFailure(Call<Contato> call, Throwable t) {
                    Toast.makeText(getBaseContext(), t.getMessage(), Toast.LENGTH_LONG).show();
                }
            });
        }else{
            Toast.makeText(getBaseContext(), "ID inválido", Toast.LENGTH_LONG).show();
        }
    }

    @OnClick(R.id.btBusca)
    public void listaContato(View v) {
        updateUI();
    }

    //metodo para atualizar os valores na aplicação
    private void updateUI() {
        ContatoServer contatoServer = retrofit.create(ContatoServer.class);

        contatoServer.listContatos().enqueue(new Callback<List<Contato>>() {
            @Override
            public void onResponse(Call<List<Contato>> call, Response<List<Contato>> response) {
                contatos = response.body();
                String res = "";
                for (Contato c : contatos) {
                    res +=  "ID: "+c.getId()+"\nNome:"+ c.getNome() + "\nTelefone: " + c.getTelefone() + "\nEmail: " + c.getEmail() + "\n";
                    res +=  "=================\n";
                }
                tvResul.setText(res);
            }

            @Override
            public void onFailure(Call<List<Contato>> call, Throwable t) {

            }
        });
    }

    private Contato getContato() {
        Contato u = new Contato(edtNome.getText().toString(),edtTelefone.getText().toString(),edtEmail.getText().toString());

        return u;
    }

    public boolean isNumber(String value){
        String regexStr = "^[0-9]*$";

        if(value.trim().matches(regexStr))
        {
            return true;
        }
        else{
            return false;
        }
    }

}
