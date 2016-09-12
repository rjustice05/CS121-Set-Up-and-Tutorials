package com.example.listdisplay.listdisplay;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView1 = (ListView) findViewById(R.id.listView1);

        Article[] items = {
                new Article(1, "Prime Numbers", 21.50, "https://en.wikipedia.org/wiki/Prime_number"),
                new Article(2, "Natural Numbers", 15.99, "https://en.wikipedia.org/wiki/Natural_number"),
                new Article(3, "Pythagorean Theorem", 14.90, "https://en.wikipedia.org/wiki/Pythagorean_theorem"),
                new Article(4, "Counting Cards", 7.99, "https://en.wikipedia.org/wiki/Card_counting"),
                new Article(5, "Lambda Calculus", 10.00, "https://en.wikipedia.org/wiki/Lambda_calculus"),
        };

        ArrayAdapter<Article> adapter = new ArrayAdapter<Article>(this,
                android.R.layout.simple_list_item_1, items);

        listView1.setAdapter(adapter);

        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {

                String item = ((TextView)view).getText().toString();

                Toast.makeText(getBaseContext(), item, Toast.LENGTH_LONG).show();

            }
        });

    }
}
