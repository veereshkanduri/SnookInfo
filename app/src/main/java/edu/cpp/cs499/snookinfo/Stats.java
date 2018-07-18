package edu.cpp.cs499.snookinfo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class Stats extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stats);

        MyDbAdapter helper = new MyDbAdapter(this);
        ArrayList<ReadData> objects = helper.getData();

        ListView lv = findViewById(R.id.my_stats_list);
        StatsAdapter adapter = new StatsAdapter(this, 0, objects);
        lv.setAdapter(adapter);

    }
}
