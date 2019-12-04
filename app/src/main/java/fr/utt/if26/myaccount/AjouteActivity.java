package fr.utt.if26.myaccount;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class AjouteActivity extends AppCompatActivity {
    Boolean expense=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajoute);



        //for changing button color
        final Button incomeButton = findViewById(R.id.ajoute_button_income);
        final Button expenseButton = findViewById(R.id.ajoute_button_expense);
        final DatePicker datePicker= (DatePicker) findViewById(R.id.ajoute_datepicker);
        final EditText titleEd=findViewById(R.id.ajoute_title_ed);
        final EditText amountEd=findViewById(R.id.ajoute_amount_ed);


        final Spinner mySpinner = (Spinner) findViewById(R.id.ajoute_category_spinner);
        Button validerBt = findViewById(R.id.ajoute_button_valider);


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

        validerBt.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int   day  = datePicker.getDayOfMonth();
                int   month= datePicker.getMonth() + 1;
                int   year = datePicker.getYear();
                String title = titleEd.getText().toString();
                Double amount = Double.parseDouble(amountEd.getText().toString());
                String category = mySpinner.getSelectedItem().toString();


                Log.v("mjy",expense+" "+day+" "+month+" "+year+" "+title+amount+category);
            }
        });
    }
}
