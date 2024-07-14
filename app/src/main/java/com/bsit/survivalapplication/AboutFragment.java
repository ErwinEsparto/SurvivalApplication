package com.bsit.survivalapplication;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class AboutFragment extends Fragment {

    private TextView descriptionTextView; // Assuming you have a TextView for description

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

        // Find and assign descriptionTextView
        descriptionTextView = view.findViewById(R.id.descriptionTextView);

        return view;
    }

    // Method to show description with animation
    private void showDescription(String description) {
        // Update the description TextView with the new text
        descriptionTextView.setText(description);

        // Animate the visibility of the description TextView
        descriptionTextView.setVisibility(View.VISIBLE);
        ObjectAnimator alphaAnimator = ObjectAnimator.ofFloat(descriptionTextView, "alpha", 0.0f, 1.0f);
        alphaAnimator.setDuration(500); // Animation duration in milliseconds
        alphaAnimator.start();
    }
}
