package com.example.dammak_mohamed_amine_mesure_glycemie.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dammak_mohamed_amine_mesure_glycemie.R;
import com.example.dammak_mohamed_amine_mesure_glycemie.controller.HomeController;

public class HomeActivity extends AppCompatActivity {
    private Button btnConsultation;
    private EditText etUseremail, etUserpassword;
    private HomeController homeController;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        init();
        etUseremail.setText(homeController.getUserEmail());


        btnConsultation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email,password;
                boolean verifEmail = false, verifPassword = false;
                if(etUseremail.getText().toString().isEmpty() && etUserpassword.getText().toString().isEmpty()){
                    Toast.makeText(HomeActivity.this,"Veuillez saisir votre email et votre mot de passe",Toast.LENGTH_SHORT).show();
                } else {
                    if(!etUseremail.getText().toString().isEmpty())
                        verifEmail = true;
                    else
                        Toast.makeText(HomeActivity.this,"Veuillez saisir votre email",Toast.LENGTH_SHORT).show();

                    if(!etUserpassword.getText().toString().isEmpty())
                        if(etUserpassword.getText().toString().equals(homeController.getUserPassword()))
                            verifPassword = true;
                        else
                            Toast.makeText(HomeActivity.this,"Mot de passe incorrect !",Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(HomeActivity.this,"Veuillez saisir votre mot de passe",Toast.LENGTH_SHORT).show();
                }
                if(verifEmail && verifPassword) {
                    email = etUseremail.getText().toString();
                    password = etUserpassword.getText().toString();
                    homeController.createUser(email,password,HomeActivity.this);
                    Intent intent = new Intent(HomeActivity.this, MainActivity.class);
                    // Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                    finish();

                }
            }
        });
    }
    private void init(){
        homeController = HomeController.getInstance(HomeActivity.this);
        etUseremail = findViewById(R.id.etUserEmail);
        etUserpassword = findViewById(R.id.etUserPassword);
        btnConsultation = findViewById(R.id.btnConsultation);

    }
}