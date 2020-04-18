package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    public static final String NOMBRE_PERSONAJE = "nombrePersonaje";
    public static final String IMAGEN_PERSONAJE = "imagenPersonaje";


    private TextView textViewNombrePersonaje;
    private ImageView imageViewPersonaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        textViewNombrePersonaje = findViewById(R.id.detailActivityTextViewNombrePersonaje);
        imageViewPersonaje = findViewById(R.id.detailActivityImageViewPersonaje);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();


        String nombrePersonaje = bundle.getString(NOMBRE_PERSONAJE);
        int imagenPersonaje = bundle.getInt(IMAGEN_PERSONAJE);


        textViewNombrePersonaje.setText(nombrePersonaje);
        imageViewPersonaje.setImageResource(imagenPersonaje);


    }
}
