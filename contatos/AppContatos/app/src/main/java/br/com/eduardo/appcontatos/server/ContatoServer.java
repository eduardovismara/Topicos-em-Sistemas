package br.com.eduardo.appcontatos.server;

import java.util.List;

import br.com.eduardo.appcontatos.model.Contato;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by Eduardo on 22/04/2016.
 */
public interface ContatoServer {

    @POST("contatos")
    Call<Contato> addContato(@Body() Contato contato);

    @GET("contatos")
    Call<List<Contato>> listContatos();

    @GET("contatos/{id}")
    Call<Contato> listContatos(@Path("id") long id);

    @PUT("contatos/{id}")
    Call<Contato> updateContato(@Path("id") long id,@Body() Contato contato);

    @DELETE("contatos/{id}")
    Call<Contato> deleteContatos(@Path("id") long id);
}
