package com.example.todo_22;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<String> {
    private EditText mBookInput;
    private TextView mTitleText;
    private TextView mAuthorText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBookInput = findViewById(R.id.bookInput);
        mTitleText = findViewById(R.id.titleText);
        mAuthorText = findViewById(R.id.authorText);

        if(getSupportLoaderManager().getLoader(0)!=null){
            getSupportLoaderManager().initLoader(0,null,this);
        }
    }

    public void searchBook(View view) {
        String queryString = mBookInput.getText().toString();

        //new FetchBook(mTitleText, mAuthorText).execute(queryString);
        //to check network connection in phone
        ConnectivityManager connMgr = ((ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE));
        NetworkInfo networkInfo = null;
        if (connMgr != null){
            networkInfo = connMgr.getActiveNetworkInfo();
        }
        if (networkInfo != null && networkInfo.isConnected() && queryString.length() != 0){
            //
            Bundle queryBundle = new Bundle();
            queryBundle.putString("queryString", queryString);
            getSupportLoaderManager().restartLoader(0, queryBundle,this);
            //
           // new FetchBook(mTitleText, mAuthorText).execute(queryString);
            mAuthorText.setText("");
            mTitleText.setText("Loading...");
        }
        else{
            if (queryString.length() == 0){
                mAuthorText.setText("");
                mTitleText.setText("Please enter a search term");
            }else{
                mAuthorText.setText("");
                mTitleText.setText("Please check your network connection and try again");
            }
        }

    }

    @NonNull
    @Override
    public Loader<String> onCreateLoader(int id, @Nullable Bundle args) {//create loader class
        String queryString = "";

        if (args != null){
            queryString = args.getString("queryString");
        }
        return new BookLoader(this, queryString);
    }

    @Override
    public void onLoadFinished(@NonNull Loader<String> loader, String data) {
        try{
            JSONObject jsonObject = new JSONObject(data);
            JSONArray itemsArray = jsonObject.getJSONArray("items");
            int i = 0;
            String title = null;
            String authors = null;
            while (i < itemsArray.length() && (authors == null && title == null)){
                //get current item info
                JSONObject book = itemsArray.getJSONObject(i);
                JSONObject volumeInfo = book.getJSONObject("volumeInfo");
                try{
                    title = volumeInfo.getString("title");
                    authors = volumeInfo.getString("authors");
                }catch(Exception e){
                    e.printStackTrace();
                }
                //move to the next item
                i++;
            }

        }catch (JSONException e){

            e.printStackTrace();
        }
    }

    @Override
    public void onLoaderReset(@NonNull Loader<String> loader) {

    }
}