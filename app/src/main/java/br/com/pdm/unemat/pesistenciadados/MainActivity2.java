package br.com.pdm.unemat.pesistenciadados;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView txtResult;
    public static final String MyPREFERENCES = "arquivo";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        txtResult=(TextView) findViewById(R.id.textView2);

        //RECUPERAR OS DADOS SALVOS
        SharedPreferences preferencia = getSharedPreferences(MyPREFERENCES, 0);

        if (preferencia.contains("email")){
            // RECUPERAR OS DSADOS
            String usuario = preferencia.getString("email", "Bem Vindo! email não definido");
            txtResult.setText("Bem Vindo! " + usuario);

        }else {
            txtResult.setText("Bem Vindo! Usuário não definido");
        }
    }
}