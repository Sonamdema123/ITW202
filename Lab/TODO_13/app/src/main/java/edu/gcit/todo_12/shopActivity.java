package edu.gcit.todo_12;

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

public class shopActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private TextView mex_intent;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        mex_intent = findViewById(R.id.ex_intent);
        spinner = findViewById(R.id.spinnerPhone);

        Intent obj = getIntent();
        String message = obj.getStringExtra(MainActivity.EXTRA_MESSAGE);
        mex_intent.setText(message);

        if (spinner != null){
            spinner.setOnItemSelectedListener(this);
        }

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array
                .spinner_label, R.layout.support_simple_spinner_dropdown_item);
        if (spinner != null){
            spinner.setAdapter(adapter);
        }
    }

    private void displayPopupMsg(String popUpMsg) {
        Toast.makeText(getApplicationContext(), popUpMsg, Toast.LENGTH_LONG).show();
    }

    public void onclickRaddio(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()){
            case R.id.radbtn1:
                displayPopupMsg(getString(R.string.same_day_messenger_service));
                break;
            case R.id.radbtn2:
                displayPopupMsg(getString(R.string.next_day_group_delivery));
                break;
            case R.id.radbtn3:
                displayPopupMsg(getString(R.string.pick_up));
                break;
            default:
                break;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String mMessage = parent.getItemAtPosition(position).toString();
        displayPopupMsg(mMessage);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}