package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
 EditText email,emailR2, password,passwordR1,passwordR2, user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email=findViewById(R.id.email);
        emailR2=findViewById(R.id.emailR1);
        password=findViewById(R.id.password);
        passwordR1=findViewById(R.id.passwordR);
        passwordR2=findViewById(R.id.passwordR2);
        user=findViewById(R.id.name);
    }

    public void validar(View view)
    {
        JSONObject datos=new JSONObject();
        try {

            datos.put("email", email.getText());
            datos.put("password", password.getText());

        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest UserJson = new JsonObjectRequest(Request.Method.POST, "http::/127.0.0.1:8000/api/", datos, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Toast.makeText(MainActivity.this,response.toString(),Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        if(UserJson == "1")


    }
    public void Registro(View view)
    {
        setContentView(R.layout.registrar);

    }
    public void Regresar(View view)
    {
        setContentView(R.layout.activity_main);
    }
}