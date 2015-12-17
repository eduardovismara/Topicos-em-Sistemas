package com.eduardo.applogin.cardapioapp;

import android.app.assist.AssistContent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    ListView list;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cadastroInicial();

        carregaLanches();


    }

    public AdapterView.OnItemClickListener detalheLanche(final Context context){
        return (new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> av, View view, int position, long id) {
                Object o = av.getItemAtPosition(position);
                String str=(String)o;

                Lanches l = Colecoes.getInstance().localizaLancheNome(str);


                Intent detalhe = new Intent(getBaseContext(), DetalheLanche.class);

                Bundle b = new Bundle();
                b.putString("nome", l.getNomeLanche());
                b.putString("detalhe", l.getIngredientes());
                b.putString("valor", String.valueOf(l.getValor()));

                detalhe.putExtras(b);

                startActivity(detalhe);



            }
        });
    }

    public void cadastroInicial(){
        // Lanche 1
        Lanches l1 = new Lanches();
        l1.setNomeLanche("X-CALABRESA");
        l1.setIngredientes("PÃO, HAMBURGUER, CALABRESA");
        l1.setValor(10);

        // Lanche 2
        Lanches l2 = new Lanches();
        l2.setNomeLanche("X-SALADA");
        l2.setIngredientes("PÃO, HAMBURGUER, SALADA");
        l2.setValor(6);

        // Lanche 3
        Lanches l3 = new Lanches();
        l3.setNomeLanche("X-EGG");
        l3.setIngredientes("PÃO, HAMBURGUER, OVO");
        l3.setValor(9);

        // Lanche 4
        Lanches l4 = new Lanches();
        l4.setNomeLanche("X-BACON");
        l4.setIngredientes("PÃO, HAMBURGUER, BACON");
        l4.setValor(12);

        // Lanche 5
        Lanches l5 = new Lanches();
        l5.setNomeLanche("X-FILÉ");
        l5.setIngredientes("PÃO, FILÉ, SALADA");
        l5.setValor(15);

        // Lanche 6
        Lanches l6 = new Lanches();
        l6.setNomeLanche("X-SUPREMO");
        l6.setIngredientes("PÃO, FRANGO, SALADA, MILHO");
        l6.setValor(14);

        // Lanche 7
        Lanches l7 = new Lanches();
        l7.setNomeLanche("BAURU");
        l7.setIngredientes("PÃO, PRESUNTO, MUSSARELA");
        l7.setValor(5);

        // Lanche 8
        Lanches l8 = new Lanches();
        l8.setNomeLanche("X-BNH");
        l8.setIngredientes("PÃO, SALSICHA");
        l8.setValor(7.5);

        // Lanche 9
        Lanches l9 = new Lanches();
        l9.setNomeLanche("X-UFMS");
        l9.setIngredientes("PÃO, FILE DE SAPO, SALADA");
        l9.setValor(20);

        // Lanche 10
        Lanches l10 = new Lanches();
        l10.setNomeLanche("CACHORRO QUENTE");
        l10.setIngredientes("PÃO, SALSICHA, MILHO");
        l10.setValor(3);

        Colecoes.getInstance().getLanches().add(l1);
        Colecoes.getInstance().getLanches().add(l2);
        Colecoes.getInstance().getLanches().add(l3);
        Colecoes.getInstance().getLanches().add(l4);
        Colecoes.getInstance().getLanches().add(l5);
        Colecoes.getInstance().getLanches().add(l6);
        Colecoes.getInstance().getLanches().add(l7);
        Colecoes.getInstance().getLanches().add(l8);
        Colecoes.getInstance().getLanches().add(l9);
        Colecoes.getInstance().getLanches().add(l10);

    }

    public void carregaLanches(){
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, Colecoes.getInstance().getLanchesNome());

        list = (ListView) findViewById(R.id.list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(detalheLanche(this));

    }

    public void cadastrarLanche(View view) {
        Intent i = new Intent(getBaseContext(), CadastroLanche.class);

        startActivity(i);

    }

    @Override
    protected void onResume() {
        super.onResume();
        carregaLanches();
    }
}
