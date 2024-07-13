package com.bsit.survivalapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class AboutFragment extends Fragment {

    // ... Other existing code

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_about, container, false);

        // Find all ImageViews
        ImageView image1 = view.findViewById(R.id.image1);
        ImageView image2 = view.findViewById(R.id.image2);
        ImageView image3 = view.findViewById(R.id.image3);
        ImageView image4 = view.findViewById(R.id.image4);

        // Set OnClickListener for each ImageView
        image1.setOnClickListener(v -> showDescription("Description 1"));
        image2.setOnClickListener(v -> showDescription("Description 2"));
        image3.setOnClickListener(v -> showDescription("Description 3"));
        image4.setOnClickListener(v -> showDescription("Description 4"));

        return view;
    }

    // Method to show description (you can animate this as per your requirement)
    private void showDescription(String description) {
        // Here, you can implement the sliding down animation or simply update a TextView below the images
        Toast.makeText(getActivity(), description, Toast.LENGTH_SHORT).show();
        // Example: Implement sliding down animation using property animations
        // Assuming you have a TextView for description below the images
        // descriptionTextView.setText(description);
        // descriptionTextView.setVisibility(View.VISIBLE);
        // descriptionTextView.animate().alpha(1.0f).setDuration(500).start();
    }
}
