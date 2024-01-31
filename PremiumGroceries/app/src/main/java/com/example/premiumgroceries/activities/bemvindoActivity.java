package com.example.premiumgroceries.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.premiumgroceries.R;
import com.google.firebase.Firebase;
import com.google.firebase.auth.FirebaseAuth;

public class bemvindoActivity extends AppCompatActivity {

    Button entre, registro;
    FirebaseAuth mauth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bemvindo);

        mauth = FirebaseAuth.getInstance();

        if (mauth.getCurrentUser() != null){
            startActivity(new Intent(bemvindoActivity.this, MainActivity.class));
            finish();
        }

        entre = findViewById(R.id.entre_wel);
        registro = findViewById(R.id.registro_wel);

        entre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(bemvindoActivity.this, LoginActivity.class));
            }
        });

        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(bemvindoActivity.this, SignUpActivity.class));
            }
        });

}
}