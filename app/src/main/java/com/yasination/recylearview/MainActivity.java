package com.yasination.recylearview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    HashMap<String,String>hashMap;
    ArrayList<HashMap<String,String>> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);

        arrayList = new ArrayList<>();


        hashMap = new HashMap<>();
        hashMap.put("video_id","HYcHfYprm5c");
        hashMap.put("title", "This is video title 1 ");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("video_id","jkL8SYdFAw4");
        hashMap.put("title", "This is video title 2 ");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("video_id","jjp9SPyEB7k");
        hashMap.put("title", "This is video title 3 ");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("video_id","VdE5aY6kQoU");
        hashMap.put("title", "This is video title 4 ");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("video_id","HYcHfYprm5c");
        hashMap.put("title", "This is video title 5 ");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("video_id","jkL8SYdFAw4");
        hashMap.put("title", "This is video title 6 ");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("video_id","jjp9SPyEB7k");
        hashMap.put("title", "This is video title 7 ");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("video_id","VdE5aY6kQoU");
        hashMap.put("title", "This is video title 8 ");
        arrayList.add(hashMap);


        MyAdapter myAdapter = new MyAdapter();
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));



    }
    //-----------------------------------onCreate Ends-----------

    private class MyAdapter extends RecyclerView.Adapter<MyAdapter.myViewHolder>{
        private class myViewHolder extends RecyclerView.ViewHolder{
            ImageView imageView;
            TextView textView;

            public myViewHolder(@NonNull View itemView) {
                super(itemView);
                imageView = itemView.findViewById(R.id.imageView);
                textView  = itemView.findViewById(R.id.textView);
            }
        }

        @NonNull
        @Override
        public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = getLayoutInflater();
            View myView = layoutInflater.inflate(R.layout.recyclear_item,parent,false);

            return new myViewHolder(myView);
        }

        @Override
        public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
          //  holder.textView.setText("Item Position: "+position);
            hashMap = arrayList.get(position);
            String title = hashMap.get("title");
            String video_id = hashMap.get("video_id");
            String imageURL = "https://img.youtube.com/vi/"+video_id+"/0.jpg";
            holder.textView.setText(title);
            Picasso.get()
                    .load(imageURL)
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .into(holder.imageView);

        }

        @Override
        public int getItemCount() {
            return arrayList.size();
        }


    }
}