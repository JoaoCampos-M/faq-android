package br.com.pdm.unemat.pesistenciadados;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // DECLARA VARIAVEIS
    EditText user, email, pwd;
    Button send;
    TextView txtResultado;


    // DECLARA O ARQUIVO DE PREFERENCIAS
    public static final String MyPREFERENCES = "arquivo";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // INSTANCIA AS VARIAVEIS
        user=(EditText) findViewById(R.id.username);
        email=(EditText) findViewById(R.id.email);
        pwd=(EditText) findViewById(R.id.password);
        send=(Button) findViewById(R.id.button);
        txtResultado=(TextView) findViewById(R.id.textView);

        //  CLASSE SHAREDPREFECENCES
        SharedPreferences sharedPreferences = getSharedPreferences(MyPREFERENCES, 0);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // DECLARAÇÃO DE VARIAVEIS LOCAIS
                String usuarioLocal = user.getText().toString();
                String emailLocal = email.getText().toString();
                String senhaLocal = pwd.getText().toString();

                // DECLARAÇÃO DO EDITOR - SHAREDPREFERENCES NO MODO EDIÇÃO
                SharedPreferences.Editor editor = sharedPreferences.edit();

                // FAZER PERSISTENCIA DOS DADOS
                editor.putString("usuario", usuarioLocal);
                editor.putString("email", emailLocal);
                editor.putString("senha", senhaLocal);

                // CONFIRMAR PERSISTENCIA DOS DADOS
                editor.commit();

                // NOTIFICAÇÃO NO APP
                Toast.makeText(MainActivity.this, "Dados Cadastrado no .xml com Sucesso!", Toast.LENGTH_LONG).show();

                //LIMPAR FORMULARIO (GLOBAL) PARA O PROXIMO CADASTRO
                user.getText().clear();
                email.getText().clear();
                pwd.getText().clear();
                user.requestFocus();

                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });



    }
}