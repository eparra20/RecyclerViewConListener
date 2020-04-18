package com.example.myapplication;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * Necesito mi LAYOUT y necesito mi lista de personajes.
 */
public class PersonajesAdapter extends RecyclerView.Adapter {

    private List<Personaje> listaDePersonajes;
    //private MainActivity mainActivity;
    private PersonajesAdapterListener listener;

    public PersonajesAdapter(List<Personaje> listaDePersonajes,PersonajesAdapterListener personajesAdapterListener) {
        this.listaDePersonajes = listaDePersonajes;
        //this.mainActivity = mainActivity;
        this.listener = personajesAdapterListener;
    }

    /**
     * Crea la Celda del layout
     * @param parent
     * @param viewType
     * @return
     */
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //1 es PASAR EL XML a algo de tipo VIEW, es decir necesito INFLARLO
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        //convertimos este XML a VIEW R.layout.celda_personaje
        View viewCelda = layoutInflater.inflate(R.layout.celda_personaje,parent,false);
        //2 este metodo no retorna un VIEW, retorna un viewHolder.
        PersonajeViewHolder viewHolder = new PersonajeViewHolder(viewCelda);
        return viewHolder;
    }

    /**
     * EL que le da a la celda creada los valores correspondientes.
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        //obtener el elemento de la lista a mostrar.
        Personaje unPersonajeAMostrar = listaDePersonajes.get(position);
        PersonajeViewHolder personajeViewHolder = (PersonajeViewHolder) holder;
        personajeViewHolder.cargarPersonaje(unPersonajeAMostrar);
    }

    /**
     * Retorna la cantidad de elementos en mi lista.
     * @return
     */
    @Override
    public int getItemCount() {
        return this.listaDePersonajes.size();
    }


    //¿Que es un viewHolder?
    // Es la representacion Java de la celda.
    //Un ViewHolder es una MAMUSKA
    private class PersonajeViewHolder extends RecyclerView.ViewHolder {


        private ImageView imageViewPersonaje;
        private TextView textViewPersonajeNombre;
        private TextView textViewPersonajeSerieOrigen;

        //dentro de itemView es la celda_personaje.xml inflada.
        //inflada es pasar de XML a View
        public PersonajeViewHolder(@NonNull View itemView) {
            super(itemView);
            //los findViewById
            imageViewPersonaje = itemView.findViewById(R.id.celdaPersonajeImageViewPersonaje);
            textViewPersonajeNombre = itemView.findViewById(R.id.celdaPersonajeTextViewNombrePersonaje);
            textViewPersonajeSerieOrigen = itemView.findViewById(R.id.celdaPersonajeTextViewSerieOrigen);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //le pedimos al adapter la posicion
                    int adapterPosition = getAdapterPosition();
                    //saco el personaje de mi lista de personajes por la position
                    Personaje personaje = listaDePersonajes.get(adapterPosition);
                 //   mainActivity.irAlaSegundaActividad(personaje);
                    listener.hicieronClick(personaje);
                }
            });
        }

        /**
         * ACA es donde enlazamos realmente CADA UNO de los personajes con cada una de las celdas.
         * Por que recuerden que un viewHolder es una representacion de una UNICA CELDA.
         *
         * @param unPersonaje
         */
        public void cargarPersonaje(Personaje unPersonaje) {
            imageViewPersonaje.setImageResource(unPersonaje.getImagen());
            textViewPersonajeNombre.setText(unPersonaje.getNombre());
            textViewPersonajeSerieOrigen.setText(unPersonaje.getOrigenSerie());
        }

    }


    public interface PersonajesAdapterListener{
        public void hicieronClick(Personaje personaje);
    }

}
