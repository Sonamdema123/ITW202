package com.example.todo_12;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
//import android.widget.Toolbar;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.todo_13";
    private String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }
    public void displayToast(String message){
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
    }

    public void donut(View view) {
        message = getString(R.string.donut_text);
        displayToast(message);
    }

    public void iceCream(View view) {
        message = getString(R.string.ice_text);
        displayToast(message);
    }

    public void Froyo(View view) {
       message = getString(R.string.froyo_text);
       displayToast(message);
    }

    public void Shop(View view) {
        Intent intent = new Intent (MainActivity.this, Order.class);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        switch(item.getItemId()){
            case R.id.action_shopping:
                Intent intent = new Intent(MainActivity.this,Order.class);
                startActivity(intent);
                return true;
            case R.id.action_order:
                displayToast("Order");
                return true;
            case R.id.action_status:
                displayToast("status");
                return true;
            case R.id.action_favourites:
                displayToast("Favourites");
                return true;
            case R.id.action_contact:
                displayToast("contact");
                return true;
            case R.id.action_about:
                displayToast("about");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

//    public void onClick(View view) {
//        Intent intent = new Intent(Intent.ACTION_DIAL);
//        intent.setData(Uri.parse("tel:17486014"));
//        startActivity(intent);
//    }

}