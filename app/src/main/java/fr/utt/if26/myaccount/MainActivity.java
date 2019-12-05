package fr.utt.if26.myaccount;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    Button ajouteButton;
    private LineViewModel mLineViewModel;

    //// Fang ran commit

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ajouteButton = findViewById(R.id.main_button_ajouter);
        ajouteButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AjouteActivity.class);
                startActivity(intent);
            }
        });
        recyclerView=findViewById(R.id.main_recyclerview);
        final AccountAdapter adapter = new AccountAdapter(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        mLineViewModel = ViewModelProviders.of(this).get(LineViewModel.class);
        mLineViewModel.getmAllLines().observe(this, new Observer<List<LineEntity>>() {
            @Override
            public void onChanged(@Nullable final List<LineEntity> lineEntities) {
                adapter.setAccount(lineEntities);
            }
        });
    }
}
