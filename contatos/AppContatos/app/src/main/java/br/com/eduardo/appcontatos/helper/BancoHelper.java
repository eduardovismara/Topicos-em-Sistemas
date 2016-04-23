package br.com.eduardo.appcontatos.helper;

import com.raizlabs.android.dbflow.annotation.Database;

/**
 * Created by Eduardo on 22/04/2016.
 */
@Database(name = BancoHelper.NAME, version = BancoHelper.VERSION)
public class BancoHelper {
    // Nome da Base de dados
    public static final String NAME = "contatos";
    // Vercao do Banco
    public static final int VERSION = 1;
}