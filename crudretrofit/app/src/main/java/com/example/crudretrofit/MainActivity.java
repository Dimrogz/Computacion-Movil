package com.example.crudretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.crudretrofit.model.Empleado;
import com.example.crudretrofit.sinterface.CrudEmpleadoInterface;
import com.google.gson.Gson;

import java.util.List;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private CrudEmpleadoInterface cruempleado;

    private List<Empleado> listaEmpleado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getAll();
    }
    private void getAll(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.56.1:8081")
                //.baseUrl("http://localhost:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        cruempleado = retrofit.create(CrudEmpleadoInterface.class);
        Call<List<Empleado>> call = cruempleado.getAll();

        call.enqueue(new Callback<List<Empleado>>(){
            @Override
            public void onResponse(Call<List<Empleado>> call, Response<List<Empleado>> response) {
                if (!response.isSuccessful()) {
                    Log.e("Reponse err:,", response.message());
                    return;
                }
                listaEmpleado = response.body();
                listaEmpleado.forEach(p -> Log.i("Empleados:", p.toString()));

            }
            @Override
            public void onFailure(Call<List<Empleado>> call, Throwable t) {
                Log.e("Throw error:",t.getMessage());
            }
        });


    }

    public void guardar(View view){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.56.1:8081")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        cruempleado = retrofit.create(CrudEmpleadoInterface.class);
        Empleado empleado = new Empleado(2L, "Diego", "12345", "dmr1213@hotmail.es");
        RequestBody body = RequestBody.create(MediaType.parse("application/json"),
                new Gson().toJson(empleado));
        Call<Empleado> call = cruempleado.guardar(body);
        call.enqueue(new Callback<Empleado>() {
            @Override
            public void onResponse(Call<Empleado> call, Response<Empleado> response) {
                if (response.isSuccessful()) {
                    System.out.println(response.message());
                    return;
                }
                System.out.println(response.body());
            }
            @Override
            public void onFailure(Call<Empleado> call, Throwable t) {
                Log.e("Throw error: ",t.getMessage());
            }
        });
    }

    public void eliminar(View view){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.56.1:8081")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        cruempleado = retrofit.create(CrudEmpleadoInterface.class);

        Call<Void> call = cruempleado.borrar(2L);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    System.out.println(response.message());
                    return;
                }
                System.out.println(response.body());
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Log.e("Throw error: ",t.getMessage());
            }
        });

    }

    public void actualizar(View view){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.56.1:8081")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        cruempleado = retrofit.create(CrudEmpleadoInterface.class);

        Empleado empleado = new Empleado(2L, "german", "12345", "german@hotmail.es");
        RequestBody body= RequestBody.create(MediaType.parse("application/json"),
                new Gson().toJson(empleado));
        Call<Empleado> call = cruempleado.actualizar(2L, body);

        call.enqueue(new Callback<Empleado>() {
            @Override
            public void onResponse(Call<Empleado> call, Response<Empleado> response) {
                if (response.isSuccessful()) {
                    System.out.println(response.message());
                    return;
                }
                System.out.println(response.body());
            }

            @Override
            public void onFailure(Call<Empleado> call, Throwable t) {
                Log.e("Throw error: ",t.getMessage());
            }
        });

    }


}