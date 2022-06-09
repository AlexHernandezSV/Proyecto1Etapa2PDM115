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
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class CicloInsertarActivity extends AppCompatActivity {

    EditText edtId_ciclo;
    EditText edtCiclo;
    EditText edtFecha_inicio;
    EditText edtFecha_fin;
    Button btnAgregar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ciclo_insertar);

        edtId_ciclo=(EditText)findViewById(R.id.edtId_ciclo);
        edtCiclo = (EditText) findViewById(R.id.edtCiclo);
        edtFecha_inicio = (EditText) findViewById(R.id.edtFecha_inicio);
        edtFecha_fin = (EditText) findViewById(R.id.edtFecha_fin);
        btnAgregar = (Button) findViewById(R.id.btnAgregar);

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ejecutarServicio("http://192.168.1.4:80/WebServices/insertar_ciclo.php");
            }
        });
    }

    private void ejecutarServicio(String URL)
    {
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
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> parametros = new HashMap<String, String>();
                parametros.put("id_ciclo",edtId_ciclo.getText().toString());
                parametros.put("ciclo",edtCiclo.getText().toString());
                parametros.put("fecha_inicio",edtFecha_inicio.getText().toString());
                parametros.put("fecha_fin",edtFecha_fin.getText().toString());
                return parametros;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}