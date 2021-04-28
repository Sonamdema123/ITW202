package com.example.implicitintents;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText mOperandOneEdtTxt;
    private EditText mOperandTwoEdtTxt;
    private TextView mResultTextView;
    private Calculator mCalculator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mOperandOneEdtTxt= findViewById(R.id.editText);
        mOperandTwoEdtTxt = findViewById(R.id.editText1);
        mResultTextView = findViewById(R.id.textView);

        mCalculator = new Calculator();
    }

    public void Add(View view) {
        String operandOne = mOperandOneEdtTxt.getText().toString();
        String operandTwo = mOperandTwoEdtTxt.getText().toString();

        double value = mCalculator.add(Double.valueOf(operandOne), Double.valueOf(operandTwo));
        mResultTextView.setText(String.valueOf(value));
    }

    public void Sub(View view) {
        String operandOne = mOperandOneEdtTxt.getText().toString();
        String operandTwo = mOperandTwoEdtTxt.getText().toString();

        double value = mCalculator.sub(Double.valueOf(operandOne), Double.valueOf(operandTwo));
        mResultTextView.setText(String.valueOf(value));
    }

    public void Mul(View view) {
        String operandOne = mOperandOneEdtTxt.getText().toString();
        String operandTwo = mOperandTwoEdtTxt.getText().toString();

        double value = mCalculator.mul(Double.valueOf(operandOne), Double.valueOf(operandTwo));
        mResultTextView.setText(String.valueOf(value));
    }

    public void Div(View view) {
        String operandOne = mOperandOneEdtTxt.getText().toString();
        String operandTwo = mOperandTwoEdtTxt.getText().toString();

        double value = mCalculator.div(Double.valueOf(operandOne), Double.valueOf(operandTwo));
        mResultTextView.setText(String.valueOf(value));
    }
}