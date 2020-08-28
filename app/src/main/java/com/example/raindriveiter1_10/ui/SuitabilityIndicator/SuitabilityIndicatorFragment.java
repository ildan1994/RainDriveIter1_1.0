package com.example.raindriveiter1_10.ui.SuitabilityIndicator;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.raindriveiter1_10.R;

public class SuitabilityIndicatorFragment extends Fragment {

    private SuitabilityIndicatorViewModel suitabilityIndicatorViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        suitabilityIndicatorViewModel =
                ViewModelProviders.of(this).get(SuitabilityIndicatorViewModel.class);
        View root = inflater.inflate(R.layout.fragment_suitability_indicator, container, false);
        final TextView textView = root.findViewById(R.id.text_gallery);
        suitabilityIndicatorViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}