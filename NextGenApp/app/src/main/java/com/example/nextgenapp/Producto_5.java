package com.example.nextgenapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;

public class Producto_5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producto_5);
        ImageSlider imageSlider = findViewById(R.id.imageSlider);
        ArrayList<SlideModel> slideModels = new ArrayList<>();

        slideModels.add(new SlideModel(R.drawable.g920, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.g920_1, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.g920_2, ScaleTypes.FIT));


        imageSlider.setImageList(slideModels, ScaleTypes.FIT);
    }
    public void registrarse(View view) {
        Intent i = new Intent(this, Registro.class);
        startActivity(i);

    }
    public void restablecer(View view) {
        Intent i = new Intent(this, Restablecer.class);
        startActivity(i);

    }
    public void iniciopag(View view) {
        Intent i = new Intent(this, Paginaprin.class);
        startActivity(i);
    }
    public void inicioapp(View view) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
    public void enviar(View view) {
        Intent i = new Intent(this, Enviado.class);
        startActivity(i);
    }
    public void cierre(View view) {
        Intent i = new Intent(this, Cierre.class);
        startActivity(i);
    }
    public void comprado(View view) {
        Intent i = new Intent(this, Comprado.class);
        startActivity(i);
    }
}