package com.example.crudretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import com.example.crudretrofit.model.Empleado;
import com.example.crudretrofit.sinterface.CrudEmpleadoInterface;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private CrudEmpleadoInterface cruempleado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getAll();
    }
    private void getAll(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.56.1:8080/")
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
                List<Empleado> listEmpleado = response.body();
                listEmpleado.forEach(p -> Log.i("Empleados:", p.toString()));

            }
            @Override
            public void onFailure(Call<List<Empleado>> call, Throwable t) {
                Log.e("Throw error:",t.getMessage());
            }
        });
    }
}