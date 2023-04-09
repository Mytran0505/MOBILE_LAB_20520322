package com.example.a20520322_lab02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText editFullName;
    EditText editCrossSalary;
    Button btnCalculator;
    ListView lvPersonalNetSalary;
    ArrayList<PesonalSalary> arrayPesonalSalary;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editFullName = (EditText) findViewById(R.id.editTextFullName);
        editCrossSalary = (EditText) findViewById(R.id.editTextGrossSalary);
        btnCalculator = (Button) findViewById(R.id.buttonCalculator);
        lvPersonalNetSalary = (ListView) findViewById(R.id.listViewPersonalNetSalary);
        arrayPesonalSalary = new ArrayList<PesonalSalary>();

        ArrayAdapter<PesonalSalary> adapter = new ArrayAdapter<PesonalSalary>(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                arrayPesonalSalary
        );
        btnCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PesonalSalary ps = new PesonalSalary();
                ps.setFullName(editFullName.getText().toString());
                long CrossSalary = Long.parseLong(editCrossSalary.getText().toString());
                long a =(long) (CrossSalary - CrossSalary *0.105);
                if ( a <= 11000000)
                    ps.setSalary(a);
                else
                    ps.setSalary((long)(a - (a-11000000)*0.05));
                arrayPesonalSalary.add(ps);
                adapter.notifyDataSetChanged();
            }
        });
        lvPersonalNetSalary.setAdapter(adapter);
    }
}