package com.example.raindriveiter1_10.ui.RainDriveQuiz;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.raindriveiter1_10.MainActivity;
import com.example.raindriveiter1_10.QuizActivity;
import com.example.raindriveiter1_10.R;

import static android.app.Activity.RESULT_OK;

public class RainDriveQuizFragment extends Fragment {
    private static final int REQUEST_CODE_QUIZ = 1;
    private RainDriveQuizViewModel rainDriveQuizViewModel;
    private Button quiz_start_btn;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        rainDriveQuizViewModel =
                ViewModelProviders.of(this).get(RainDriveQuizViewModel.class);
        View root = inflater.inflate(R.layout.fragment_raindrivequiz, container, false);
//        final TextView textView = root.findViewById(R.id.text_slideshow);
//        rainDriveQuizViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        quiz_start_btn = root.findViewById(R.id.quiz_start_btn);
        quiz_start_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startQuiz();
            }
        });
        return root;
    }

    private void startQuiz() {
        Intent intent = new Intent(getContext(), QuizActivity.class );
        startActivityForResult(intent, REQUEST_CODE_QUIZ);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_QUIZ) {
            if (resultCode == RESULT_OK) {
                int score = data.getIntExtra(QuizActivity.EXTRA_SCORE, 0);
                if (score > 3) {
                    Toast.makeText(getContext(), "well done", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getContext(), "stupid, go check this link", Toast.LENGTH_SHORT).show();
                    quiz_start_btn.setText("link");
                    quiz_start_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String url = "https://mylearners.vic.gov.au/Stages/Stage0/SD-First-on-Ls";
                            Intent i = new Intent(Intent.ACTION_VIEW);
                            i.setData(Uri.parse(url));
                            startActivity(i);
                        }
                    });
                }
            }
        }


    }
}