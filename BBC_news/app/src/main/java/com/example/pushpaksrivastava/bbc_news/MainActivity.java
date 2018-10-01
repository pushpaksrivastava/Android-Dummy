package com.example.pushpaksrivastava.bbc_news;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.android.volley.manager.RequestManager;

import java.util.Map;

public class MainActivity extends AppCompatActivity implements RequestManager.RequestListener {
String baseurl="https://newsapi.org/v1/articles?source=%s&sortBy=top&" +
        "apiKey=3fc8a6525ecc43458b5c7e0f6bc942c4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public void onRequest() {

    }

    @Override
    public void onSuccess(String s, Map<String, String> map, String s1, int i) {

    }

    @Override
    public void onError(String s, String s1, int i) {

    }
}
