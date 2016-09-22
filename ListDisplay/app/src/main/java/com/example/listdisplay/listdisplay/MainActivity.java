package com.example.listdisplay.listdisplay;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.EditText;
import android.app.Activity;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends Activity {

    private ArrayList<Article> items =  new ArrayList<Article>();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView1 = (ListView) findViewById(R.id.listView1);


                items.add(new Article(1, "Prime Numbers", 21.50, "https://en.wikipedia.org/wiki/Prime_number"));
                items.add (new Article(2, "Natural Numbers", 15.99, "https://en.wikipedia.org/wiki/Natural_number"));
                items.add (new Article(3, "Pythagorean Theorem", 14.90, "https://en.wikipedia.org/wiki/Pythagorean_theorem"));
                items.add(new Article(4, "Counting Cards", 7.99, "https://en.wikipedia.org/wiki/Card_counting"));
                items.add(new Article(5, "Lambda Calculus", 10.00, "https://en.wikipedia.org/wiki/Lambda_calculus"));


        ArrayAdapter<Article> adapter = new ArrayAdapter<Article>(this,
                android.R.layout.simple_list_item_1, items);

        listView1.setAdapter(adapter);

        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {


                String website = items.get(position).getWebsite();
                Uri uri = Uri.parse(website);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);

                //WebView webview = new WebView(this);
                //setContentView(webview);
                //webview.loadUrl(website);

            }
        });

    }


    public void NewsFeed(View view) {
        WebView webview = new WebView(this);
        setContentView(webview);
        webview.loadUrl("https://en.wikipedia.org/wiki/Lambda_calculus");
    }


    public void Books(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.viralandroid.com"));
        startActivity(browserIntent);
    }

    public void Journals(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.viralandroid.com"));
        startActivity(browserIntent);
    }

    public void Magazines(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.viralandroid.com"));
        startActivity(browserIntent);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // Check if the key event was the Back button and if there's history
        WebView myWebView;
        myWebView = (WebView) findViewById(R.id.activity_main_webview);
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        if ((keyCode == KeyEvent.KEYCODE_BACK) && myWebView.canGoBack()) {
            myWebView.goBack();
            return true;
        }
        // If it wasn't the Back key or there's no web page history, bubble up to the default
        // system behavior (probably exit the activity)
        return super.onKeyDown(keyCode, event);
    }
}
