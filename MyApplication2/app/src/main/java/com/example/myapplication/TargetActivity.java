package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class TargetActivity extends AppCompatActivity {

    TextView name;
    ImageView imageView2;
    TextView desc;
    TextView price;
    Button left;
    Button right;
    TextView number;
    Button commit;
    int mark;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_target);
        name = findViewById(R.id.name);
        imageView2 = findViewById(R.id.imageView2);
        desc = findViewById(R.id.desc);
        price = findViewById(R.id.price);
        left = findViewById(R.id.left);
        right = findViewById(R.id.right);
        number = findViewById(R.id.number);
        commit = findViewById(R.id.commit);

        Intent intent = getIntent();
        int id = intent.getIntExtra("ID",0);
        mark = 0;

        Item clickedItem = FakeDatabase.getItemById(id);
        name.setText(clickedItem.getName());
        imageView2.setImageResource(clickedItem.getImage2());
        desc.setText(clickedItem.getDescription());
        price.setText(clickedItem.getCost()+" $ : ");
        number.setText(mark+"");

        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                mark++;
                number.setText(mark+"");
            }
        });

        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if(mark <= 0) {
                } else {
                    mark--;
                    number.setText(mark+"");
                }
            }
        });



        commit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = getIntent();
                int id = intent.getIntExtra("ID",0);
                Item item = FakeDatabase.items.get(id);
                int itemPastNumber = item.getNumber();
                item.setNumber(item.getNumber()+mark);

                if (itemPastNumber==0){
                    FakeDatabase.orders.put(FakeDatabase.orderMealNumber,item);
                    FakeDatabase.orderMealNumber++;
                } else {
                    for (int x : FakeDatabase.orders.keySet()) {
                        if (FakeDatabase.orders.get(x).equals(item)) {
                            FakeDatabase.orders.put(x,item);
                        }
                    }
                }

                Toast.makeText(TargetActivity.this, "commit success",
                        Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent2);
            }
        });
    }


}
