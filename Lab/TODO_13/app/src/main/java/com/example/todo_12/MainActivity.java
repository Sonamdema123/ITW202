package com.example.todo_12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.todo_13";
    private String message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void displayToast(String message){
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
    }

    public void donut(View view) {
        message = "You ordered a donut";
        displayToast(message);
    }

    public void iceCream(View view) {
        message = "You ordered an Ice Cream";
        displayToast(message);
    }

    public void Froyo(View view) {
       message = "You ordered a Froyo";
       displayToast(message);
    }

    public void Phone(View view) {
        Intent intent = new Intent (MainActivity.this, Order.class);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
//    public void onClick(View view) {
//        Intent intent = new Intent(Intent.ACTION_DIAL);
//        intent.setData(Uri.parse("tel:17486014"));
//        startActivity(intent);
//    }

}