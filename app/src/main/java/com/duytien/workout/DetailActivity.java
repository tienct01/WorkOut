package com.duytien.workout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        WorkoutDetailFragment detailFrag =(WorkoutDetailFragment) getSupportFragmentManager().findFragmentById(R.id.detail_frag);
        Intent intent = getIntent();
        Long id = intent.getLongExtra(Intent.EXTRA_INDEX, 0);
        detailFrag.setWorkoutId(id);
    }
}