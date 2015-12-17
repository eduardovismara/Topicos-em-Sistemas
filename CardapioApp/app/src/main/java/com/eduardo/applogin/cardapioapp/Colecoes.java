package com.eduardo.applogin.cardapioapp;

import android.app.LauncherActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eduardo on 12/11/15.
 */
public class Colecoes {

    private static Colecoes instance;

    private List<Lanches> lanches;

    private Colecoes() {
        lanches = new ArrayList<Lanches>();
    }


    public static Colecoes getInstance(){
        if(instance == null){
            instance = new Colecoes();
        }
        return instance;
    }

    public static void setInstance(Colecoes instance) {
        Colecoes.instance = instance;
    }

    public List<Lanches> getLanches() {
        return lanches;
    }

    public void setLanches(List<Lanches> lanches) {
        this.lanches = lanches;
    }

    public List<String> getLanchesNome(){
        List<String> listaLanche = new ArrayList<String>();

        for (Lanches l : Colecoes.getInstance().getLanches()) {

            listaLanche.add(l.getNomeLanche());

        }
        return listaLanche;
    }

    public Lanches localizaLancheNome(String nome){

        Lanches lanche = null;

        for (Lanches l : Colecoes.getInstance().getLanches()) {
            if (l.getNomeLanche().equals(nome)){
                return l;
            }
        }

        return lanche;
    }
}
