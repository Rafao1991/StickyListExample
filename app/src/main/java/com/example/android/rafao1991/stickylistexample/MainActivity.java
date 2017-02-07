package com.example.android.rafao1991.stickylistexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.Arrays;
import java.util.List;

import se.emilsjolander.stickylistheaders.StickyListHeadersListView;

public class MainActivity extends AppCompatActivity {

    StickyListHeadersListView stickylistview;
    MainAdapter mainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        stickylistview = (StickyListHeadersListView) findViewById(R.id.stickylistview_main);
        mainAdapter = new MainAdapter(this, getData());
        stickylistview.setAdapter(mainAdapter);
    }

    private List<String> getData() {
        return Arrays.asList(
                "Rafao",
                "Rapha",
                "Thalera",
                "Heleno",
                "Luiz");
    }
}
