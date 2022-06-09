package com.example.proyecto1etapa2pdm115;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class HorarioConsultarActivity extends AppCompatActivity {

    EditText edtIdHorario;
    EditText edtDesde;
    EditText edtHasta;
    Button btnBuscar, btnlimpiar;

    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horario_consultar);

        edtIdHorario=(EditText)findViewById(R.id.editIdHorario);
        edtDesde = (EditText) findViewById(R.id.editDesde_horario);
        edtHasta = (EditText) findViewById(R.id.editHasta_horario);
        btnBuscar = (Button) findViewById(R.id.botonConsultar);
        btnlimpiar =  (Button) findViewById(R.id.botonLimpiar);

        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buscarHorario("http://192.168.1.10/WebServices/ws_consultarHorario.php?id_horario="+edtIdHorario.getText()+"");
            }
        });

        btnlimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limpiar();
            }
        });
    }


    private void buscarHorario(String URL)
    {
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject jsonObject = null;
                for (int i = 0; i < response.length(); i++) {
                    try {
                        jsonObject = response.getJSONObject(0);
                        edtDesde.setText(jsonObject.getString("desde_horario"));
                        edtHasta.setText(jsonObject.getString("hasta_horario"));
                    } catch (JSONException e) {
                        Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),"Error de conexión",Toast.LENGTH_SHORT).show();
            }
        }
        );
        requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonArrayRequest);
    }


    public void limpiar ()
    {
        edtIdHorario.setText("");
        edtDesde.setText("");
        edtHasta.setText("");
    }
}