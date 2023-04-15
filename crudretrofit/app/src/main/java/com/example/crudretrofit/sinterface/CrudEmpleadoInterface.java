package com.example.crudretrofit.sinterface;

import com.example.crudretrofit.model.Empleado;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface CrudEmpleadoInterface {
    @GET("/consultarAll")
    Call<List<Empleado>> getAll();
}
