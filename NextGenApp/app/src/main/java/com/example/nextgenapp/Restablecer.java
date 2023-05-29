package com.example.nextgenapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class Restablecer extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private EditText correo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restablecer);
        mAuth = FirebaseAuth.getInstance();
        correo = findViewById(R.id.correo);
    }


    public void Restablecercontraseña(View view) {
        if (TextUtils.isEmpty(correo.getText())) {
            Toast.makeText(this, "Por favor, completa todos los campos.", Toast.LENGTH_SHORT).show();
            return;
        }
        mAuth.sendPasswordResetEmail(correo.getText().toString().trim())
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            // Envío de correo electrónico de restablecimiento de contraseña exitoso
                            Toast.makeText(getApplicationContext(), "Se ha enviado un correo electrónico.", Toast.LENGTH_SHORT).show();
                            // Puedes redirigir al usuario a la pantalla de inicio de sesión u otra actividad
                        } else {
                            // Error al enviar el correo electrónico de restablecimiento de contraseña
                            Toast.makeText(getApplicationContext(), "Error al enviar el correo electrónico. ", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
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
}