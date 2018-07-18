package edu.cpp.cs499.snookinfo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Results extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results);


        String user1 = getIntent().getExtras().getString("user1_name");
        String user2 = getIntent().getExtras().getString("user2_name");

        int user1Score = getIntent().getExtras().getInt("user1_score");
        int user2Score = getIntent().getExtras().getInt("user2_score");

        int user1break = getIntent().getExtras().getInt("user1_break");
        int user2break = getIntent().getExtras().getInt("user2_break");

        long startTime = getIntent().getExtras().getLong("start_time");
        long finishTime = getIntent().getExtras().getLong("finish_time");

        // DATABASE

        MyDbAdapter helper = new MyDbAdapter(this);
        long id = helper.insertData(String.valueOf(startTime), user1, user2, String.valueOf(user1Score), String.valueOf(user2Score));
        if (id > 0) {
            Toast.makeText(this, "Match saved successfully", Toast.LENGTH_LONG).show();
        }


        TextView winner = findViewById(R.id.winner_declaration);
        if (user1Score > user2Score) {
            winner.setText(user1 + " wins");
        } else if (user1Score < user2Score) {
            winner.setText(user2 + " wins");
        } else {
            winner.setText(" Math Draw");
        }

        TextView user1_name = findViewById(R.id.user1_name_results);
        TextView user1_score = findViewById(R.id.user1_score_results);
        TextView user1_break = findViewById(R.id.user1_break_results);

        TextView user2_name = findViewById(R.id.user2_name_results);
        TextView user2_score = findViewById(R.id.user2_score_results);
        TextView user2_break = findViewById(R.id.user2_break_results);

        user1_name.setText(user1);
        user1_score.setText(Integer.toString(user1Score));
        user1_break.setText(Integer.toString(user1break));

        user2_name.setText(user2);
        user2_score.setText(Integer.toString(user2Score));
        user2_break.setText(Integer.toString(user2break));

        TextView duration = findViewById(R.id.duration);

        long matchTimeSec = (finishTime - startTime) % 60;
        long matchTimeMin = (finishTime - startTime) / 60;

        duration.setText("Duration :  "+ matchTimeMin + " Minutes " + matchTimeSec + " Seconds");
//
        Date date = new java.util.Date(startTime*1000L);
// the format of your date
        SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
// give a timezone reference for formatting (see comment at the bottom)
//        sdf.setTimeZone(java.util.TimeZone.getTimeZone("GMT-4"));
        String formattedDate = sdf.format(date);
//        System.out.println(formattedDate);

//        duration.setText(formattedDate);

        Button home = findViewById(R.id.home_button);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotoHome = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(gotoHome);
            }
        });

    }
}
