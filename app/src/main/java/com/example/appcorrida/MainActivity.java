package com.example.appcorrida;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.Firebase;

public class MainActivity extends AppCompatActivity {

    // Criar as variáveis.
    private Button btLogar;
    private Button btCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //////////////////////////////////////////////
        // Digitar Firebase e importar dependências //
        //////////////////////////////////////////////

        // O método "findViewById" associa o botão na tela à variável "btLogar".
        btLogar = findViewById(R.id.btLogar);
        btCadastrar = findViewById(R.id.btCadastrar);

        // Quando o "btLogar" for clicado, o método "telaLogar" é acionado.
        btLogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                telaLogar();
            }
        });

        btCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                telaCadastrar();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    // Métodos:

    private void telaLogar() {
        // O método nos transfere para a tela do "LoginActivity".
        startActivity(new Intent(this, LoginActivity.class));
    }

    private void telaCadastrar() {
        startActivity(new Intent(this, CadastroActivity.class));
    }
}

