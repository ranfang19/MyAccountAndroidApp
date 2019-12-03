package fr.utt.if26.myaccount;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AjouteActivity extends AppCompatActivity {
    Boolean expense=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajoute);

        final Button incomeButton = findViewById(R.id.ajoute_button_income);
        final Button expenseButton = findViewById(R.id.ajoute_button_expense);
        incomeButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                expenseButton.setBackgroundColor(getResources().getColor(R.color.colorPrimaryLight));
                incomeButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                expense=false;
            }
        });
        expenseButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                incomeButton.setBackgroundColor(getResources().getColor(R.color.colorPrimaryLight));
                expenseButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                expense=true;
            }
        });
    }
}
