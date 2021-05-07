package com.example.todo_12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Order extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private TextView textView;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        textView = findViewById(R.id.textView1);
        spinner = findViewById(R.id.action_bar_spinner);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        textView.setText(message);

        if (spinner != null){
            spinner.setOnItemSelectedListener(this);
        }

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.array_label, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        if(spinner != null){
            spinner.setAdapter(adapter);
        }
    }
    public void displayToast(String message){
        Toast.makeText(getApplicationContext(),message, Toast.LENGTH_SHORT).show();
    }
    public void onRadioChecked(View view) {
        boolean checked = ((RadioButton)view).isChecked();

        switch (view.getId()){
            case R.id.SameDay:
                displayToast(getString(R.string.sameDay));
                break;

            case R.id.NextDay:
                displayToast(getString(R.string.nextDay));
                break;

            case R.id.Pickup:
                displayToast(getString(R.string.pickUp));
                break;
            default:
                break;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String SpinnerMessage = parent.getItemAtPosition(position).toString();
        displayToast(SpinnerMessage);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}