package com.proventaja.tiendit.petagram;



import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.HorizontalScrollView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rv_mascota;
    private ArrayList<Mascota> listaMascotas ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.patitita);
       // actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ffffff")));

        rv_mascota = findViewById(R.id.rv_animales);


        //crear una lista de mascotas
        listaMascotas = new ArrayList<>();
        listaMascotas.add(new Mascota(R.drawable.perro1,"Pepe", 5));
        listaMascotas.add(new Mascota(R.drawable.perro2,"Blue ", 3));
        listaMascotas.add(new Mascota(R.drawable.perro3,"Locote ", 2));
        listaMascotas.add(new Mascota(R.drawable.perro4,"Berna", 5));
        listaMascotas.add(new Mascota(R.drawable.perro5,"Ponche", 4));
        listaMascotas.add(new Mascota(R.drawable.perro6,"Lala", 5));
        listaMascotas.add(new Mascota(R.drawable.perro7,"Lucas", 4));
        //configuramos el recyclerview
        LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        rv_mascota.setLayoutManager(llm);
        rv_mascota.setAdapter(new MascotaAdapter(getApplicationContext(),listaMascotas));
        setTitle("Petagram");

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();

        inflater.inflate(R.menu.menu_main, menu);


        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub


        switch (item.getItemId()){
            case R.id.nav_home_faoritos:
                Intent intent = new Intent(this, MascotasFavoritasActivity.class);
                startActivity(intent);
                return true;
            case R.id.nav_home_opciones:
                finish();
                return true;
        }
      return   super.onOptionsItemSelected(item);
    }

}