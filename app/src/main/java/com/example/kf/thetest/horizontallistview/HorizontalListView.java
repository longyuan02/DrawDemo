package com.example.kf.thetest.horizontallistview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.kf.thetest.R;

public class HorizontalListView extends AppCompatActivity {
    private ListView lv_horizontal;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horizontallistview);
        lv_horizontal= (ListView) findViewById(R.id.lv_horizontal);

    }

}
