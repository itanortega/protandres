package com.example.personal.myappgym;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main3Activity extends AppCompatActivity {

    private static String LOCAL = "";

    RecyclerView Rv_MultifuncionalesLaser;
    LinearLayoutManager linearLayoutManager;
    private AdapterArticulos adapterArticulos;
    private ExecutorService queue = Executors.newSingleThreadExecutor();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(linearLayoutManager.VERTICAL);

        Rv_MultifuncionalesLaser = (RecyclerView) findViewById(R.id.Rv_MultifuncionalesLaser);
        Rv_MultifuncionalesLaser.setLayoutManager(linearLayoutManager);

        LOCAL = getApplicationContext().getFilesDir().getAbsolutePath() + "/";

        cargarPalabras();
    }

    public void cargarPalabras(){

        ArrayList<Articulo> articulos = new ArrayList<>();
        Articulo a;

        articulos.add(new Articulo(1, "ref 1","descripcion 1"));
        articulos.add(new Articulo(2, "ref 2","descripcion 2"));
        articulos.add(new Articulo(3, "ref 3","descripcion 3"));


        adapterArticulos = new AdapterArticulos(articulos, getApplicationContext());
        Rv_MultifuncionalesLaser.setAdapter(adapterArticulos);


        /*Runnable thread = new Runnable() {
            @Override
            public void run() {
                String strUrl = LOCAL + "words.json";
                CAFData data = null;

                data = CAFData.dataWithContentsOfFile(strUrl);

                try {
                    JSONObject root = new JSONObject(data.toText());
                    JSONArray catJson = root.getJSONArray("categorias");
                    JSONObject categoriaJson = catJson.getJSONObject(id_categoria);
                    JSONArray palabras = categoriaJson.getJSONArray("words");

                    final JSONArray palabrasJson = palabras;

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            ArrayList<Palabra> palabras = new ArrayList<>();
                            Palabra p;
                            JSONObject palabraJson;

                            for(int i=0; i<palabrasJson.length(); i++){
                                try {
                                    palabraJson = palabrasJson.getJSONObject(i);
                                    p = new Palabra(i, palabraJson.getString("inglés").toString(), palabraJson.getString("español").toString(), LOCAL + palabraJson.getString("español").toString() + ".png");
                                    palabras.add(p);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }

                            palabrasAdapter = new PalabrasAdapter(palabras, getApplicationContext());
                            Rv_Palabras.setAdapter(palabrasAdapter);
                        }
                    });
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };

        queue.execute(thread);*/
    }

}
