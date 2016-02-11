package com.sourceit.task1.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.sourceit.task1.R;
import com.sourceit.task1.model.Contact;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private final int DEFAULT = 20;
    ArrayList<Contact> contacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);


        contacts = new ArrayList<>();
        for (int i = 0; i < DEFAULT; i++) {
            contacts.add(new Contact("Name" + i, "Email@" + i, "Adress " + i, R.drawable.ic_contact_phone_black_48dp));
        }

        RecyclerView contact_list = (RecyclerView) findViewById(R.id.contact_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        contact_list.setLayoutManager(layoutManager);
        contact_list.setAdapter(new RecyclerViewAdapter(contacts, new OnItemClickWatcher() {
            @Override
            public void onItemClick(View v, int position, Object item) {
                openInformation(position);
            }
        }));
    }

    private void openInformation(int position) {
        Intent intent = new Intent(this, Information.class);
        Contact contact_temp = contacts.get(position);
        intent.putExtra("name", contact_temp.getName());
        intent.putExtra("email", contact_temp.getEmail());
        intent.putExtra("adress", contact_temp.getAdress());
        intent.putExtra("image", contact_temp.getImage());
        startActivity(intent);
    }
}
