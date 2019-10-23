package com.example.projectshop;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.io.Serializable;
import java.util.ArrayList;



public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MainAdapter.ItemClickListener itemClickListener = new MainAdapter.ItemClickListener() {
        @Override
        public void onItemClick(Person item, int position) {
            Intent intent = new Intent(MainActivity.this, DetailedActivity.class);
            //intent.putExtra("id", item.getID());
            intent.putExtra("image",item.getImage());
            intent.putExtra("name", item.getName());
            intent.putExtra("date", item.getDateOfBirth());
            intent.putExtra("description", item.getDescription());
            startActivity(intent);

        }
    };

    private ArrayList<Person> persons;
    public void initializeData(){
        persons = new ArrayList<>();

        for(int i = 0; i < 100; i++) {
            persons.add(new Person(" Robert Anthony De Niro",
                    "American actor famous for his uncompromising portrayals of violent and abrasive characters and, later in his career, for his comic depictions of cranky old men.",
                    "17.08.1943", R.drawable.ic_launcher_background ));
        }
    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeData();
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        MainAdapter mainAdapter = new MainAdapter(persons, itemClickListener);
        recyclerView.setAdapter(mainAdapter);
    }
}