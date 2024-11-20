package com.simulado.appgerarsenha;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    String letrasMinusculas = "abcdefghijklmnopqrstuvwxyz";
    String numeros = "0123456789";
    String simbolos = "!@#$%&";

    private TextView mostrarSenha;
    private Button gerarSenha;
    private Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        mostrarSenha = findViewById(R.id.textViewSenha);
        gerarSenha = findViewById(R.id.buttonGerar);

        gerarSenha.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String senha = criarSenha();
                mostrarSenha.setText (senha);
            }
        });


    }

    private String criarSenha (){
        Random random = new Random();
        StringBuilder senha = new StringBuilder();


        for (int i = 0; i < 3; i++) {
            senha.append(getRandomChar(letrasMinusculas));
            senha.append(getRandomChar(numeros));
            senha.append(getRandomChar(simbolos));
        }

        return senha.toString();

    }

    private char getRandomChar(String source) {
        return source.charAt(random.nextInt(source.length()));
    }


}