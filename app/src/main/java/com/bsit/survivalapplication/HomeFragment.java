package com.bsit.survivalapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bsit.survivalapplication.Adapter.HourlyAdapter;
import com.bsit.survivalapplication.Domains.Hourly;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private RecyclerView.Adapter adapterHourly;
    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        initRecyclerview(view);
        return view;
    }

    private void initRecyclerview(View view) {
        ArrayList<Hourly> items = new ArrayList<>();

        items.add(new Hourly("9 PM", 28, "cloudy"));
        items.add(new Hourly("11 PM", 30, "sunny"));
        items.add(new Hourly("12 PM", 26, "wind"));
        items.add(new Hourly("1 AM", 23, "rainy"));
        items.add(new Hourly("2 AM", 22, "storm"));

        recyclerView = view.findViewById(R.id.view1);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false));

        adapterHourly = new HourlyAdapter(items);
        recyclerView.setAdapter(adapterHourly);
    }
}