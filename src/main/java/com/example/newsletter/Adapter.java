package com.example.newsletter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.Viewholder>
{
    Context context;
    ArrayList<Model> modelArrayList;

    public Adapter(Context context, ArrayList<Model> modelArrayList)
    {
        this.context = context;
        this.modelArrayList = modelArrayList;
    }

    @NonNull
    @Override
    public Adapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        @SuppressLint("InflateParams")
        View view = LayoutInflater.from(context).inflate(R.layout.layout_items, parent, false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.Viewholder holder, @SuppressLint("RecyclerView") int position)
    {
        Model currentModel = modelArrayList.get(position);
        holder.mheading.setText(currentModel.getTitle());
        holder.mcontext.setText(currentModel.getDescription());
        holder.mauthor.setText(currentModel.getAuthor());
        holder.mtime.setText(currentModel.getPublishedAt());
        Glide.with(context).load(currentModel.getUrlToImage()).into(holder.imageView);


        holder.cardView.setOnClickListener(view ->
        {
            Intent intent = new Intent(context, WebView.class);
            intent.putExtra("url", modelArrayList.get(position).getUrl());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }

    public static class Viewholder extends RecyclerView.ViewHolder
    {
        TextView mheading, mcontext, mauthor, mtime;
        CardView cardView;
        ImageView imageView;

        public Viewholder(@NonNull View itemView)
        {
            super(itemView);

            mheading = itemView.findViewById(R.id.mainheading);
            mcontext = itemView.findViewById(R.id.content);
            mauthor = itemView.findViewById(R.id.author);
            imageView = itemView.findViewById(R.id.imageview);
            mtime = itemView.findViewById(R.id.time);
            cardView = itemView.findViewById(R.id.cardview);
        }
    }
}
