package mx.com.bogel.koalix;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import mx.com.bogel.koalix.APIConsumer.RestApiClient;
import mx.com.bogel.koalix.Adapters.ResultadosAdapter;
import mx.com.bogel.koalix.Objects.Propuesta;
import mx.com.bogel.koalix.Utils.Global;

public class Resultado extends AppCompatActivity {
    TextView cargando;
    ProgressBar progreso;
    ArrayList<Propuesta> optionsArray;
    JSONObject infoUsuario;

    String usuario;
    String doors;
    String cyl;
    String seats;
    String body;
    String URL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        consultaAPI();
    }

    public void consultaAPI(){
        URL = Global.URL_D;
        new RestApiClient(URL ,"", "", "", RestApiClient.METHOD.GET, new RestApiClient.RestInterface() {

            @Override
            public void onFinish(final String Result) {
                if (Result != null) {
                    try {
                        JSONObject jsonResult = new JSONObject(Result);
                        Integer size = jsonResult.length();
                        if(size==0){
                            Toast toast = Toast.makeText(getApplicationContext(),"Ups, lo siento, "+usuario+" creo que no encontre ninguna opcion para ti! :(",Toast.LENGTH_SHORT);
                            toast.show();
                        }else{
                            if (size > 10){
                                size = 5;
                            }
                            for (int i = 0; i < size; i++) {
                                String marca = jsonResult.getString("make_display");
                                String gama = jsonResult.getString("model_body");
                                String modelo = jsonResult.getString("model_name");
                                String motor = jsonResult.getString("model_engine_cyl");
                                String plazas = jsonResult.getString("model_seats");
                                String puertas = jsonResult.getString("model_doors");
                                optionsArray.add(new Propuesta(modelo,marca,puertas,plazas,motor,gama));
                            }
                            RecyclerView principalRecycler = (RecyclerView)findViewById(R.id.recycler_propuestas);
                            principalRecycler.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                            ResultadosAdapter resultadosAdapter = new ResultadosAdapter(getApplicationContext(), optionsArray);
                            principalRecycler.setAdapter(resultadosAdapter);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                        Toast toast = Toast.makeText(getApplicationContext(),"Ups, lo siento, "+usuario+" creo que no encontre ninguna opcion para ti! :(",Toast.LENGTH_SHORT);
                        toast.show();
                    }
                }else{
                }
            }
            @Override
            public void onBefore() {

            }
        }).execute();
    }


}
