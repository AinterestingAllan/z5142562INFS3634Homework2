package com.example.myapplication;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    static private ArrayList<Item> ay;
    private String tag;
    AppCompatActivity appCompatActivity;

    public RecyclerViewAdapter( String tag,
                               AppCompatActivity appCompatActivity) {
        this.tag = tag;
        this.appCompatActivity = appCompatActivity;
    }

    public void setData (ArrayList<Item> ay) {
        this.ay = ay;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (tag.equals("main")) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
        } else {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.list_item2, parent, false);
            return new ViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Item item = ay.get(position);
        if (tag.equals("main")) {
            holder.textView.setText(item.getName());
            holder.imageView.setImageResource(item.getImage2());
        } else {
            holder.name2.setText(item.getName());
            holder.imageView3.setImageResource(item.getImage2());
            holder.orderNumber.setText(item.getNumber()+"");
            holder.orderPrice.setText(item.getCost()+ "$");
        }
    }

    @Override
    public int getItemCount() {
        return ay.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView imageView;
        TextView textView;
        ImageView imageView3;
        TextView name2;
        TextView orderNumber;
        TextView orderPrice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);

            imageView3 = itemView.findViewById(R.id.imageView3);
            name2 = itemView.findViewById(R.id.name2);
            orderNumber = itemView.findViewById(R.id.orderNumber);
            orderPrice = itemView.findViewById(R.id.order_price);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
                // onNoteListener.onNoteClick(getAdapterPosition());
            Intent intent = new Intent(appCompatActivity.getApplicationContext(),
                    TargetActivity.class);
            Item item;
            int  id = getAdapterPosition() + 1;
            if (tag.equals("main")) {
                item = FakeDatabase.getItemById(id);
                intent.putExtra("ID", item.getId());
                appCompatActivity.startActivity(intent);
            }
        }

    }

}

// 1 RecyclerViewAdapter.java
// （1 onCreateViewHolder 2 onBindViewHolder 3 getItemCount）
// --> RecyclerViewAdapter.ViewHolder 控制具体一个item
// item.xml
// 数据 itemsData (ArrayList)