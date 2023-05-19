package com.example.pr3_gurdzhi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private BlankFragment blank = new BlankFragment();
    private BlankFragment2 blank2 = new BlankFragment2();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container_view, BlankFragment.class, null)
                .commit();
    }
}