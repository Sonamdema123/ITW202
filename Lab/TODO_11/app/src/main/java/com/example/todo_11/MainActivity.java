package com.example.todo_11;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public TextView mTextView;
    private String[] changeColor = {"purple_200","purple_500","purple_700","teal_200","teal_700","black","white"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView =  findViewById(R.id.text);
    }

    public void changeColor(View view) {
        Random obj = new Random();
        String color = changeColor[obj.nextInt(7)];
        int colorRes = getResources().getIdentifier(color,"color",getApplicationContext().getPackageName());
        //int colorValue = getResources().getColor();
        int colorValue = ContextCompat.getColor(this,colorRes);
        mTextView.setTextColor(colorValue);
    }
}