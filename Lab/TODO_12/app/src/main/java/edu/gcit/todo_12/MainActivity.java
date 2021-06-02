package edu.gcit.todo_12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void donut(View view) {
       Toast toast = Toast.makeText(this, "You have ordered donut", Toast.LENGTH_SHORT);
       toast.show();
    }

    public void icecream(View view) {
        Toast toast = Toast.makeText(this, "You have ordered icecream sandwitch", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void froyo(View view) {
        Toast toast = Toast.makeText(this, "You have ordered froyo", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void call(View view) {
        Uri uri = Uri.parse("tel:17492872");
        Intent intent = new Intent(Intent.ACTION_DIAL, uri);
        startActivity(intent);
    }
}