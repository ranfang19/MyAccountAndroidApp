package fr.utt.if26.myaccount;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    Button ajouteButton;
    ArrayList<Line> account;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.main_recyclerview);
        ajouteButton = findViewById(R.id.main_button_ajouter);

        ajouteButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AjouteActivity.class);
                startActivity(intent);
            }
        });

        account = new ArrayList<>();
        for (int i=0;i<10;i++){
            Line oneLine = new Line("Shopping "+i,4,12,2019,22.99,"Food",true);
            account.add(oneLine);
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new AccountAdapter(account);
        recyclerView.setAdapter(adapter);
    }
}
