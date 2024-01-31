package com.example.premiumgroceries.activities;

import static com.example.premiumgroceries.R.id.senha_log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.premiumgroceries.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    Button entrar;
    EditText email, senha;
    TextView registro;

    FirebaseAuth mauth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mauth = FirebaseAuth.getInstance();

        entrar = findViewById(R.id.entrar_log);
        email = findViewById(R.id.email_log);
        senha = findViewById(senha_log);
        registro = findViewById(R.id.registro_log);

        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, SignUpActivity.class));
            }
        });

        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                loginUsuario();

                startActivity(new Intent(LoginActivity.this, MainActivity.class));
            }
        });
    }

    private void loginUsuario() {
        String email_usuario = email.getText().toString(); // quero inserir um input que verifique se a string é um email ou não
        String senha_usuario = senha.getText().toString();

        //analisando se os getText contém informação

        if (TextUtils.isEmpty(email_usuario)) {
            Toast.makeText(this, "Inserir um email", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(senha_usuario)) {
            Toast.makeText(this, "Inserir uma senha", Toast.LENGTH_SHORT).show();
            return;
        }
        //verificar se a senha tem mais de 4 caracteres
        if (senha_usuario.length() < 4) {
            Toast.makeText(this, "Senha deve conter mais de 4 caracteres", Toast.LENGTH_SHORT).show();
            return;
        }
        // Login Usuário
        mauth.signInWithEmailAndPassword(email_usuario, senha_usuario)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()){
                            Toast.makeText(LoginActivity.this, "Tudo certo", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(LoginActivity.this, "Deu ruim!"+task.isSuccessful(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}