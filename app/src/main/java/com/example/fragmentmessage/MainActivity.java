package com.example.fragmentmessage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements fragment1.fragment1listener, fragment2.fragment2listener{

    private fragment1 fragment1;
    private fragment2 fragment2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragment1 = new fragment1();
        fragment2 = new fragment2();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frag1,fragment1)
                .replace(R.id.frag2,fragment2)
                .commit();
    }

    @Override
    public void textinput1(CharSequence input) {
        fragment2.updateTextView(input);

    }

    @Override
    public void textinput2(CharSequence input) {
        fragment1.updateTextView(input);

    }
}