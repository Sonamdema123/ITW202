package com.example.implicitintents;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText mEditTextWebsite;
    private EditText mEditTextLocation;
    private EditText mEditTextShare;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEditTextWebsite = findViewById(R.id.editText);
        mEditTextLocation = findViewById(R.id.editText1);
        mEditTextShare = findViewById(R.id.editText2);
    }
    public void Website (View view){
        String web = mEditTextWebsite.getText().toString();
        Uri url = Uri.parse(web);
        Intent intent = new Intent(Intent.ACTION_VIEW,url);

        if(intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }
        else{
            Log.d("Implicit Intents", "Error Message");
        }
    }


    public void location(View view) {
        String loc = mEditTextLocation.getText().toString();
        Uri url = Uri.parse("geo:0,0?q=" + loc);
        Intent intent = new Intent(Intent.ACTION_VIEW,url);

        if(intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }
        else{
            Log.d("Implicit Intents", "Error Message");
        }
    }

    public void Share(View view) {
        String txt = mEditTextShare.getText().toString();
        String mimeType = "text/plain";
        ShareCompat.IntentBuilder
                .from(this)
                .setType(mimeType)
                .setChooserTitle("share this text with:")
                .setText(txt)
                .startChooser();
    }
}