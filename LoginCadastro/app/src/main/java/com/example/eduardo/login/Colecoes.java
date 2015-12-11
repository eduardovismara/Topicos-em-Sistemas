package com.example.eduardo.login;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eduardo on 12/11/15.
 */
public class Colecoes {

    private static Colecoes instance;

    private List<Usuarios> usuarios;

    private Colecoes() {
        usuarios = new ArrayList<Usuarios>();
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

    public List<Usuarios> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuarios> usuarios) {
        this.usuarios = usuarios;
    }
}
