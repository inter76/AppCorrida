package com.example.appcorrida;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class CadastroActivity extends AppCompatActivity {

    // Criar as variáveis.
    private EditText etNome;
    private EditText etEmail;
    private EditText etSenha;
    private Switch sProfessor;
    private Button btCadastrar;
    private FirebaseAuth mAuth;  // Criando a variável para o "Firebase".
    private Usuario u;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cadastro);

        etNome = findViewById(R.id.etNome);
        etEmail = findViewById(R.id.etEmail);
        etSenha = findViewById(R.id.etSenha);
        sProfessor = findViewById(R.id.sProfessor);
        btCadastrar = findViewById(R.id.btCadastrar);
        mAuth = FirebaseAuth.getInstance();

        // Quando clicar no botão "btCadastrar" uma ação vai ser txecutada.
        btCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recuperarDados();
                criarLogin();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }


    private void recuperarDados() {
        if(etNome.getText().toString() == "" ||etEmail.getText().toString() == "" || etSenha.getText().toString() == ""){
            Toast.makeText(this, "Você deve preencher todos os dados.", Toast.LENGTH_LONG);
        }else{
            u = new Usuario();
            u.setNome(etNome.getText().toString());
            u.setEmail(etEmail.getText().toString());
            u.setSenha(etSenha.getText().toString());
            u.setProfessor(sProfessor.getShowText());

        }
    }

    private void criarLogin() {
        mAuth.createUserWithEmailAndPassword(u.getEmail(), u.getSenha())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                           startActivity(new Intent(CadastroActivity.this, PrincipalActivity.class));
                        }else{
                            Toast.makeText(CadastroActivity.this, "Erro ao criar o login.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}