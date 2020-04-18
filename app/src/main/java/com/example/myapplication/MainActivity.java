package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.app.Person;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

//debe implementar PersonajesAdapter.PersonajesAdapterListener para cumplir el contrato
public class MainActivity extends AppCompatActivity implements PersonajesAdapter.PersonajesAdapterListener {


    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.mainActivityRecyclerView);


        //donde, que cosa, y por cuanto tiempo.

        //1) Dato un java class plana hicimos una lista de objetos
        //2) el XML que represente la CELDA (ES CADA UNO DE LOS ELEMENTOS:)
        //3) RecyclerView
        //4) Adapter.
        //5) cocinar el recyclerView con el adapter y los datos.


        List<Personaje> personajeList = obtenerPersonajes();
        PersonajesAdapter personajesAdapter = new PersonajesAdapter(personajeList,this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,3,LinearLayoutManager.VERTICAL,false);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);


        //que si no colocamos esto no SE VE.
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(personajesAdapter);

    }

    public List<Personaje> obtenerPersonajes(){
        List<Personaje> personajeList = new ArrayList<>();

        personajeList.add(new Personaje("Homero","Los Simpsons",R.drawable.homero));
        personajeList.add(new Personaje("Cartman","South Park",R.drawable.cartman));
        personajeList.add(new Personaje("Homero","Los Simpsons",R.drawable.homero));
        personajeList.add(new Personaje("Cartman","South Park",R.drawable.cartman));
        personajeList.add(new Personaje("Homero","Los Simpsons",R.drawable.homero));
        personajeList.add(new Personaje("Cartman","South Park",R.drawable.cartman));
        personajeList.add(new Personaje("Homero","Los Simpsons",R.drawable.homero));
        personajeList.add(new Personaje("Cartman","South Park",R.drawable.cartman));
        return personajeList;
    }

    /**
     * EL RESPONSABLE DE IR DE UNA ACTIVIDAD A OTRA ES LA MAIN ACTIVITY NO EL ADAPTER.
     * @param personaje
     */
    @Override
    public void hicieronClick(Personaje personaje) {
        Intent intent = new Intent(this,DetailActivity.class);

        //creamos el bundle
        Bundle bundle = new Bundle();
        bundle.putString(DetailActivity.NOMBRE_PERSONAJE,personaje.getNombre());
        bundle.putInt(DetailActivity.IMAGEN_PERSONAJE,personaje.getImagen());


        //asociamos el intent al bundle
        intent.putExtras(bundle);

        startActivity(intent);
    }
}
