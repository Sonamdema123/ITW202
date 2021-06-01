package com.example.todo_25;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper myDB;
    EditText editName, editSurname, editMarks, editTextId;
    Button btnAddData;
    Button btnViewAll;
    Button btnUpdate;
    Button btnDelete;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDB = new DatabaseHelper(this);
        editName = findViewById(R.id.Firstname);
        editSurname = findViewById(R.id.LastName);
        editMarks = findViewById(R.id.ITW202);
        editTextId = findViewById(R.id.ID);
        btnAddData = findViewById(R.id.button);
        btnViewAll =findViewById(R.id.button2);
        btnUpdate = findViewById(R.id.button3);
        btnDelete = findViewById(R.id.button4);
    }

    public void AddData(View view) {
        boolean isInserted = myDB.insertData(editTextId.getText().toString(),
                editName.getText().toString(),
                editSurname.getText().toString(),
                editMarks.getText().toString());
        if (isInserted == true)
            Toast.makeText(MainActivity.this, "Data Inserted",Toast.LENGTH_LONG).show();
        else

            Toast.makeText(MainActivity.this, "Data Not Inserted",Toast.LENGTH_LONG).show();
    }

    public void showMessage(String title, String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }

    public void ViewAll(View view) {
        Cursor res = myDB.getAllData();
        if (res.getCount() == 0){
            //show message
            showMessage("Error", "Nothing Found");
            return;
        }
        //Those classes work with string
        StringBuffer buffer = new StringBuffer();
        //first Cursor point to -1
        while (res.moveToNext()){

            buffer.append("Student Id: "+res.getString(0)+"\n");
            buffer.append("First Name: "+res.getString(1)+"\n");
            buffer.append("Last Name "+res.getString(2)+"\n");
            buffer.append("ITW202 Marks: "+res.getString(3)+"\n");

        }
        //show all data
        showMessage("List of students", buffer.toString());
    }

    public void Update(View view) {
        //sending text that we want to update
        //updated return type should be boolean
        boolean isUpdate = myDB.updateData(editTextId.getText().toString(),
                editName.getText().toString(),
                editSurname.getText().toString(),
                editMarks.getText().toString());
        if (isUpdate == true)
            Toast.makeText(MainActivity.this, "Data Updated",Toast.LENGTH_LONG).show();
        else

            Toast.makeText(MainActivity.this, "Data Not Updated",Toast.LENGTH_LONG).show();
    }

    public void Delete(View view) {
        Integer deletedRows = myDB.deleteData(editTextId.getText().toString());
        if (deletedRows > 0)
            Toast.makeText(MainActivity.this, "Data Deleted", Toast.LENGTH_LONG).show();
        else
            Toast.makeText(MainActivity.this,"Data Not Deleted ", Toast.LENGTH_LONG).show();

    }
}