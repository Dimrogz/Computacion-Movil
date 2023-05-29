package com.example.nextgenapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class Paginaprin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paginaprin);
        ArrayList<SlideModel> slideModels = new ArrayList<>();

        ImageSlider imageSlider1 = findViewById(R.id.imageSlider1);


        slideModels.add(new SlideModel(R.drawable.trident, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.lg, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.silla, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.thermaltake_c, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.msirefri, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.fuente, ScaleTypes.FIT));

        imageSlider1.setImageList(slideModels, ScaleTypes.FIT);

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
    public void item1(View view) {
        Intent i = new Intent(this, Producto.class);
        startActivity(i);
    }
    public void item2(View view) {
        Intent i = new Intent(this, Producto_1.class);
        startActivity(i);
    }
    public void item3(View view) {
        Intent i = new Intent(this, Producto_2.class);
        startActivity(i);
    }
    public void item4(View view) {
        Intent i = new Intent(this, Producto_3.class);
        startActivity(i);
    }
    public void item5(View view) {
        Intent i = new Intent(this, Producto_4.class);
        startActivity(i);
    }
    public void item6(View view) {
        Intent i = new Intent(this, Producto_5.class);
        startActivity(i);
    }
    public void item7(View view) {
        Intent i = new Intent(this, Producto_6.class);
        startActivity(i);
    }
}