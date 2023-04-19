package com.example.crudretrofit.sinterface;

import com.example.crudretrofit.model.Empleado;

import java.util.List;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface CrudEmpleadoInterface {
    @GET("/consultarAll")
    Call<List<Empleado>> getAll();
    @POST("/guardar")
    Call <Empleado> guardar(RequestBody body);
    @DELETE("/user/{id}")
    Call<Void> borrar(Long id);
    @PUT("/update/{id}")
    Call<Empleado> actualizar(Long id,RequestBody body);

}
