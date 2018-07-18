package edu.cpp.cs499.snookinfo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String user1;
        String user2;

        Button newGame = findViewById(R.id.new_game_button);
        newGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                setContentView(R.layout.details);


                Intent gotoDetails = new Intent(getApplicationContext(),Details.class);
                startActivity(gotoDetails);
            }
        });


        Button viewStats = findViewById(R.id.view_stats_button);
        viewStats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotoStats = new Intent(getApplicationContext(), Stats.class);
                startActivity(gotoStats);

            }
        });


    }
}
