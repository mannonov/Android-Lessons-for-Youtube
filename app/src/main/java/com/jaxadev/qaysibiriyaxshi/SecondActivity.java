package com.jaxadev.qaysibiriyaxshi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView textView;

    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textView = findViewById(R.id.tv_your_input_answer);

        bundle = getIntent().getExtras();

        textView.setText(bundle.getString(getString(R.string.answer)));

    }
}