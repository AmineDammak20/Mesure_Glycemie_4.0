package com.example.dammak_mohamed_amine_mesure_glycemie.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.dammak_mohamed_amine_mesure_glycemie.R;

public class ConsultActivity extends AppCompatActivity {
    private final String RESPONSE_KEY = "result";
    private TextView txtReponse;
    private Button btnRetour;
    private String reponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consult);
        init();
        Intent intent = getIntent();
        reponse = intent.getStringExtra(RESPONSE_KEY);
        txtReponse.setText(reponse);
        // txtReponse.setText(getIntent().getStringExtra(RESPONSE_KEY));
        btnRetour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                if(reponse == null)
                    setResult(RESULT_CANCELED,intent);
                else
                    setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
    private void init(){
        txtReponse = findViewById(R.id.txtReponse);
        btnRetour = findViewById(R.id.btnRetour);
    }
}