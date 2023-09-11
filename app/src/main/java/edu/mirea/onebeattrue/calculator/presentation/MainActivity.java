package edu.mirea.onebeattrue.calculator.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import edu.mirea.onebeattrue.calculator.R;
import edu.mirea.onebeattrue.calculator.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        edu.mirea.onebeattrue.calculator.databinding.ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


    }
}