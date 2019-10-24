package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        RecyclerView recyclerView = findViewById(R.id.rc_2);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        RecyclerViewAdapter articleAdapter = new RecyclerViewAdapter("main2",
                this);
        articleAdapter.setData(FakeDatabase.getAllOrders());
        recyclerView.setAdapter(articleAdapter);

        double totalCost = 0;
        for (int i = 0; i < FakeDatabase.getAllOrders().size(); i++) {
            Item item = FakeDatabase.getAllOrders().get(i);
            totalCost = totalCost + item.getCost() * item.getNumber();
        }

        TextView textView2 = findViewById(R.id.textView2);
        textView2.setText("The total cost are " + totalCost +" $");
    }

}
