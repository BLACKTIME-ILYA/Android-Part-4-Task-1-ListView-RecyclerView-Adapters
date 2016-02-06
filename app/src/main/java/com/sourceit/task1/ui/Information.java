package com.sourceit.task1.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.sourceit.task1.R;

public class Information extends AppCompatActivity {

    private ImageView image;
    private TextView name;
    private TextView email;
    private TextView adress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        init();

        Intent intent = getIntent();
        image.setImageResource(intent.getIntExtra("image", 0));
        name.setText(intent.getStringExtra("name"));
        email.setText(intent.getStringExtra("email"));
        adress.setText(intent.getStringExtra("adress"));
    }

    private void init() {
        image = (ImageView) findViewById(R.id.information_icon);
        name = (TextView) findViewById(R.id.information_name);
        email = (TextView) findViewById(R.id.information_email);
        adress = (TextView) findViewById(R.id.information_adress);
    }
}
