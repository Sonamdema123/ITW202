package edu.gcit.todo_12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "edu.gcit.todo4";
    String popupMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

public void donut(View view) {
        popupMsg = getString(R.string.donut_Text);
        displayPopupMsg(popupMsg);
}

    public void icecream(View view) {
        popupMsg = getString(R.string.ice_Text);
        displayPopupMsg(popupMsg);
    }

    public void froyo(View view) {
        popupMsg = getString(R.string.froyo_Text);
        displayPopupMsg(popupMsg);
    }
    private void displayPopupMsg(String popUpMsg) {
        Toast.makeText(getApplicationContext(), popUpMsg, Toast.LENGTH_LONG).show();
    }

    public void shop(View view) {
        Intent intent = new Intent(MainActivity.this, shopActivity.class);
        intent.putExtra(EXTRA_MESSAGE, popupMsg);
        startActivity(intent);

    }
}