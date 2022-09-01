package com.example.movies;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.google.android.material.bottomnavigation.BottomNavigationView;

@AndriodEntryPoint
public class MainActivity<ActivityMainBinding> extends AppCompatActivity {
    private ActivityMainBinding binding;
    NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        //Getting the Navigation Controller

        navController = Navigation.findNavController(MainActivity.this, R.id.fragment);

        binding.bottomBar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.fragmentFirst:
                        navController.navigate(R.id.fragmentFirst);
                        return true;
                    case R.id.fragmentSecond:
                        navController.navigate(R.id.fragmentSecond);
                        return true;
                    case R.id.fragmentThird:
                        navController.navigate(R.id.fragmentThird);
                        return true;
                    case R.id.fragmentFourth:
                        navController.navigate(R.id.fragmentFourth);
                        return true;
                }
                return false;
            }
        });
    }
}