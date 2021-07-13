package com.jaxadev.qaysibiriyaxshi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Button btnEnter;
    EditText editText;
    Spinner spinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnEnter = findViewById(R.id.btn_enter);
        editText = findViewById(R.id.edt_answer);
        spinner = findViewById(R.id.sp_spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.items,
                R.layout.support_simple_spinner_dropdown_item
        );

        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(this);


        btnEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String editTextText = editText.getText().toString();

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);

                if (!editTextText.equals("")) {
                    intent.putExtra(getString(R.string.answer), editTextText);
                    startActivity(intent);
                }

            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//        Toast.makeText(this,parent.getItemAtPosition(position).toString(),Toast.LENGTH_LONG).show();
        Snackbar.make(spinner, parent.getItemAtPosition(position).toString(), Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}