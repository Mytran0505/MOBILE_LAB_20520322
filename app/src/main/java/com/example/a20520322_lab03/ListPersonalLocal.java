package com.example.a20520322_lab03;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListPersonalLocal extends AppCompatActivity {
    ListView lvPersonal;
    Database database;
    ArrayList<Personal> arrayPersonal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_personal_local);
        lvPersonal = (ListView) findViewById(R.id.listViewPersonalLocal);
        ArrayAdapter<Personal> adapter = new ArrayAdapter<Personal>(
                ListPersonalLocal.this,
                android.R.layout.simple_list_item_1,
                arrayPersonal
        );
        Cursor dataPersonal = database.GetData("Select * from Personal");
        while (dataPersonal.moveToNext()){
            String fullname = dataPersonal.getString(1);
            int id = dataPersonal.getInt(0);
            String phone = dataPersonal.getString(2);
            arrayPersonal.add(new Personal(id, fullname, phone));
        }
        adapter.notifyDataSetChanged();
        lvPersonal.setAdapter(adapter);

    }
}