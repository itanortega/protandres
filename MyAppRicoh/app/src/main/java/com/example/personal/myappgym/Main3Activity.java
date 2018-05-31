package com.example.personal.myappgym;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main3Activity extends AppCompatActivity {

    private static String LOCAL = "";
    private static String DOMAIN = "http://181.62.161.249:41062/www/ricoh/";

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
        Runnable thread = new Runnable() {
            @Override
            public void run() {
                ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(getBaseContext().CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

                if (networkInfo != null){
                    URL urlArchivo = null;
                    try {
                        urlArchivo = new URL(DOMAIN + "api.php?get=impresoras");
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }

                    CAFData archivoData;
                    CAFData data = null;

                    if(urlArchivo != null) {
                        archivoData = CAFData.dataWithContentsOfURL(urlArchivo);
                        try {
                            archivoData.writeToFile(LOCAL + "impresoras.json", true);

                            JSONObject dataJson = new JSONObject(archivoData.toText());
                            JSONArray datosLista = dataJson.getJSONArray("data");

                            for (int i = 0; i < datosLista.length(); i++) {
                                try {
                                    JSONObject dato = datosLista.getJSONObject(i);
                                    String nombreImagen = dato.getString("referencia").toString() + ".jpg";
                                    data = CAFData.dataWithContentsOfURL(new URL(DOMAIN + "imgs/" + nombreImagen));
                                    data.writeToFile(LOCAL + nombreImagen, true);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                } catch (MalformedURLException e) {
                                    e.printStackTrace();
                                }
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }

                // leer archivo y cargar info
                ArrayList<Articulo> articulos = new ArrayList<>();
                Articulo a;

                CAFData datoslocal = CAFData.dataWithContentsOfFile(LOCAL + "impresoras.json");
                JSONObject registroJson;
                try {
                    JSONObject dataJson = new JSONObject(datoslocal.toText());
                    JSONArray datosL = dataJson.getJSONArray("data");
                    for (int i = 0; i < datosL.length(); i++) {
                        try {
                            registroJson = datosL.getJSONObject(i);
                            articulos.add(new Articulo(i+1, registroJson.getString("referencia"),registroJson.getString("descripcion_es"),registroJson.getString("descripcion_en"), LOCAL + registroJson.getString("referencia") + ".jpg"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                final ArrayList<Articulo> lista_articulos = articulos;
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        adapterArticulos = new AdapterArticulos(lista_articulos, getApplicationContext());
                        Rv_MultifuncionalesLaser.setAdapter(adapterArticulos);
                    }
                });
            }
        };

        queue.execute(thread);
    }

}
