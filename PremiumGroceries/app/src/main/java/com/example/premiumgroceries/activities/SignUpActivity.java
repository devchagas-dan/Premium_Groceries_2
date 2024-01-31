package com.example.premiumgroceries.activities;

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
import com.example.premiumgroceries.models.ProductsModel;
import com.example.premiumgroceries.models.UserModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity {
    Button registrar;
    TextView entrar;
    EditText nome, email, senha;
    //criando a base de dados em Firebase
    FirebaseAuth mAuth;
    FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mAuth = FirebaseAuth.getInstance(); // criando a variáveL chamar o database
        database = FirebaseDatabase.getInstance();

        registrar = findViewById(R.id.reg_btn);
        nome = findViewById(R.id.nome);
        email = findViewById(R.id.email_reg);
        senha = findViewById(R.id.senha_reg);
        entrar = findViewById(R.id.entrada);

        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
            }
        });

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // criando varíavel para guardar os parametros do usuario
                usuario();
            }

        });
    }

    private void usuario() {
        // recebendo informação do usuário
        String nome_usuario = nome.getText().toString();
        String email_usuario = email.getText().toString(); // quero inserir um input que verifique se a string é um email ou não
        String senha_usuario = senha.getText().toString();

        //analisando se os getText contém informação
        if (TextUtils.isEmpty(nome_usuario)) {
            Toast.makeText(this, "Inserir um nome", Toast.LENGTH_SHORT).show();
            return;
        }
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
        //agora precisarei criar o usuario
        mAuth.createUserWithEmailAndPassword(email_usuario, senha_usuario)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            UserModel userModel = new UserModel(nome_usuario,email_usuario,senha_usuario);
                            String id = task.getResult().getUser().getUid();
                            database.getReference().child("Users").child(id).setValue(userModel);

                            Toast.makeText(SignUpActivity.this, "Registrado", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
                            finish();

                        } else {
                            String errorMessage;
                            errorMessage = "Erro ao registrar";
                            if (task.getException() != null){
                                errorMessage += ": " + task.getException().getMessage();
                            }
                            Toast.makeText(SignUpActivity.this, errorMessage, Toast.LENGTH_SHORT).show();
                        }
                    }
                });
        // public void goToLogin(View view){
        //startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
    }
}