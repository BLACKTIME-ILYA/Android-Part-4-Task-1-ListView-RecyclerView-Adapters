package com.sourceit.task1.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

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

        ListView contact_list = (ListView) findViewById(R.id.contact_list);
        contact_list.setAdapter(new MyAdapter(this, contacts));

        contact_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                openInformation(position);
            }
        });
    }


    private class MyAdapter extends ArrayAdapter<Contact> {
        public MyAdapter(Context context, ArrayList<Contact> objects) {
            super(context, R.layout.contact, objects);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            View rowView = convertView;

            if (rowView == null) {
                rowView = getLayoutInflater().inflate(R.layout.contact, parent, false);
                holder = new ViewHolder();
                holder.name = (TextView) rowView.findViewById(R.id.contact_name);
                holder.email = (TextView) rowView.findViewById(R.id.contact_email);
                holder.image = (ImageView) rowView.findViewById(R.id.contact_icon);
                rowView.setTag(holder);
            } else holder = (ViewHolder) rowView.getTag();

            Contact contact = getItem(position);
            holder.name.setText(contact.getName());
            holder.email.setText(contact.getEmail());
            holder.image.setImageResource(contact.getImage());

            return rowView;
        }

        class ViewHolder {
            public TextView name;
            public TextView email;
            public ImageView image;
        }
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
