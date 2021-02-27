package com.duytien.workout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.SurfaceControl;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity implements WorkoutListFragment.Listener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    public void itemClicked(long id) {
        FrameLayout fragmentContainter = findViewById(R.id.frag_container);
        if(fragmentContainter == null) {
            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra(Intent.EXTRA_INDEX, id);
            startActivity(intent);
        }
        else{
            WorkoutDetailFragment workoutDetailFragment = new WorkoutDetailFragment();
            FragmentTransaction frTransaction = getSupportFragmentManager().beginTransaction();

            workoutDetailFragment.setWorkoutId(id);

            frTransaction.replace(R.id.frag_container, workoutDetailFragment);
            frTransaction.addToBackStack(null);
            frTransaction.commit();
        }
    }
}