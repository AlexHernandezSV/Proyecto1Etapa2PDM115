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

public class HorarioInsertarActivity extends AppCompatActivity {

    EditText edtIdhorario;
    EditText edtDesde;
    EditText edtHasta;
    Button btnAgregar, btnLimpiar;

    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horario_insertar);

        edtIdhorario = (EditText) findViewById(R.id.editIdHorario);
        edtDesde = (EditText) findViewById(R.id.editDesde);
        edtHasta = (EditText) findViewById(R.id.editHasta);
        btnAgregar = (Button) findViewById(R.id.btnAgregar);
        btnLimpiar = (Button) findViewById(R.id.btnLimpiar);

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Cambiar la URL
                ejecutarServicio("http://192.168.1.10/WebServices/ws_insertarHorario.php");
            }
        });

        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limpiar();
            }
        });
    }

    private void ejecutarServicio(String URL) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(), "Operación exitosa", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parametros = new HashMap<String, String>();
                parametros.put("id_horario", edtIdhorario.getText().toString());
                parametros.put("desde_horario", edtDesde.getText().toString());
                parametros.put("hasta_horario", edtHasta.getText().toString());
                return parametros;
            }
        };
        requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    public void limpiar ()
    {
        edtIdhorario.setText("");
        edtDesde.setText("");
        edtHasta.setText("");
    }
}