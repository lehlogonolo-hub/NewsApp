package com.example.newsletter;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HealthFragment extends Fragment
{
    String newsApi = "94710bfc54a44f1a9796e81a0bd2e446";
    ArrayList<Model> modelArrayList;
    Adapter adapter;
    String country = "sa";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        @SuppressLint("InflateParams")
        View view = inflater.inflate(R.layout.healthfragment, null);

        RecyclerView recyclerViewHealth = view.findViewById(R.id.recyclerviewhealth);
        modelArrayList = new ArrayList<>();
        recyclerViewHealth.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new Adapter(getContext(), modelArrayList);
        recyclerViewHealth.setAdapter(adapter);

        findNews();

        return view;
    }

    private void findNews()
    {
        String category = "health";
        ApiUtilities.getApiInterface().getCategoryNews(country, category, 50, newsApi).enqueue(new Callback<News>()
        {
            @Override
            public void onResponse(@NonNull Call<News> call, @NonNull Response<News> response) {

            }

            @Override
            public void onFailure(@NonNull Call<News> call, @NonNull Throwable t) {

            }
        });
    }
}