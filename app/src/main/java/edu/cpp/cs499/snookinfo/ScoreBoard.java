package edu.cpp.cs499.snookinfo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class ScoreBoard extends AppCompatActivity {

    private Boolean user1Status;
    private Boolean user2Status;

    private int user1Score;
    private int user2Score;

    private int user1CurrentBreak;
    private int user2CurrentBreak;


    private long finishTime;
    private long startTime;

    private String user1;
    private String user2;

    public String getUser1() {
        return user1;
    }

    public void setUser1(String user1) {
        this.user1 = user1;
    }

    public String getUser2() {
        return user2;
    }

    public void setUser2(String user2) {
        this.user2 = user2;
    }

    ArrayList<Integer> user1Breaks = new ArrayList <>();
    ArrayList<Integer> user2Breaks = new ArrayList <>();

    public int getUser1CurrentBreak() {
        return user1CurrentBreak;
    }

    public void setUser1CurrentBreak(int user1CurrentBreak) {
        this.user1CurrentBreak = user1CurrentBreak;
    }

    public int getUser2CurrentBreak() {
        return user2CurrentBreak;
    }

    public void setUser2CurrentBreak(int user2CurrentBreak) {
        this.user2CurrentBreak = user2CurrentBreak;
    }

    public long getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(long finishTime) {
        this.finishTime = finishTime;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public int getUser1Score() {
        return user1Score;
    }

    public void setUser1Score(int user1Score) {
        this.user1Score = user1Score;
    }

    public int getUser2Score() {
        return user2Score;
    }

    public void setUser2Score(int user2Score) {
        this.user2Score = user2Score;
    }

    public Boolean getUser1Status() {
        return user1Status;
    }

    public void setUser1Status(Boolean user1Status) {
        this.user1Status = user1Status;
    }

    public Boolean getUser2Status() {
        return user2Status;
    }

    public void setUser2Status(Boolean user2Status) {
        this.user2Status = user2Status;
    }

    public int getMax(ArrayList<Integer> list) {
        int max = Integer.MIN_VALUE;
        for(int i=0; i<list.size(); i++){
            if(list.get(i) > max){
                max = list.get(i);
            }
        }
        if (max > 0) {
            return max;
        } else {
            return 0;
        }

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scoreboard);



        // set the player names after the creation of the game
        TextView user1Heading = findViewById(R.id.user1_heading);
        TextView user2Heading = findViewById(R.id.user2_heading);

        // get the values from the previous intent
        setUser1(getIntent().getExtras().getString("user1"));
         setUser2(getIntent().getExtras().getString("user2"));

        setStartTime(getIntent().getExtras().getLong("unixStartTime"));

        user1Heading.setText(user1);
        user2Heading.setText(user2);

        //display the user1 as default first player an d show when game starts
        final TextView currentPlayerName = findViewById(R.id.current_player_name);
        currentPlayerName.setText(user1);

        setUser1Status(true);
        setUser2Status(false);
        setUser1Score(0);
        setUser2Score(0);
        setUser1CurrentBreak(0);
        setUser2CurrentBreak(0);

        final TextView user1_score = findViewById(R.id.user1_score);
        final TextView user2_score = findViewById(R.id.user2_score);
        final TextView current_break_score = findViewById(R.id.current_break_score);

        Button redButton = findViewById(R.id.red_ball_button);
        Button yellowButton = findViewById(R.id.yellow_ball_button);
        Button greenButton = findViewById(R.id.green_ball_button);
        Button brownButton = findViewById(R.id.brown_ball_button);
        Button blueButton = findViewById(R.id.blue_ball_button);
        Button pinkButton = findViewById(R.id.pink_ball_button);
        Button blackButton = findViewById(R.id.black_ball_button);
        Button breakButton = findViewById(R.id.break_button);
        Button foulButton = findViewById(R.id.foul_button);
        Button finishButton = findViewById(R.id.finish_button);

        redButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getUser1Status()) {
                    setUser1Score(getUser1Score() + 1);
                    setUser1CurrentBreak(getUser1CurrentBreak() + 1);
                    user1_score.setText(Integer.toString(getUser1Score()));
                    current_break_score.setText(Integer.toString(getUser1CurrentBreak()));

                } else {
                    setUser2Score(getUser2Score() + 1);
                    setUser2CurrentBreak(getUser2CurrentBreak() + 1);
                    user2_score.setText(Integer.toString(getUser2Score()));
                    current_break_score.setText(Integer.toString(getUser2CurrentBreak()));
                }
            }
        });
        yellowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getUser1Status()) {
                    setUser1Score(getUser1Score() + 2);
                    setUser1CurrentBreak(getUser1CurrentBreak() + 2);
                    user1_score.setText(Integer.toString(getUser1Score()));
                    current_break_score.setText(Integer.toString(getUser1CurrentBreak()));
                } else {
                    setUser2Score(getUser2Score() + 2);
                    setUser2CurrentBreak(getUser2CurrentBreak() + 2);
                    user2_score.setText(Integer.toString(getUser2Score()));
                    current_break_score.setText(Integer.toString(getUser2CurrentBreak()));
                }
            }
        });
        greenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getUser1Status()) {
                    setUser1Score(getUser1Score() + 3);
                    setUser1CurrentBreak(getUser1CurrentBreak() + 3);
                    user1_score.setText(Integer.toString(getUser1Score()));
                    current_break_score.setText(Integer.toString(getUser1CurrentBreak()));
                } else {
                    setUser2Score(getUser2Score() + 3);
                    setUser2CurrentBreak(getUser2CurrentBreak() + 3);
                    user2_score.setText(Integer.toString(getUser2Score()));
                    current_break_score.setText(Integer.toString(getUser2CurrentBreak()));
                }
            }
        });
        brownButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getUser1Status()) {
                    setUser1Score(getUser1Score() + 4);
                    setUser1CurrentBreak(getUser1CurrentBreak() + 4);
                    user1_score.setText(Integer.toString(getUser1Score()));
                    current_break_score.setText(Integer.toString(getUser1CurrentBreak()));
                } else {
                    setUser2Score(getUser2Score() + 4);
                    setUser2CurrentBreak(getUser2CurrentBreak() + 4);
                    user2_score.setText(Integer.toString(getUser2Score()));
                    current_break_score.setText(Integer.toString(getUser2CurrentBreak()));
                }
            }
        });
        blueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getUser1Status()) {
                    setUser1Score(getUser1Score() + 5);
                    setUser1CurrentBreak(getUser1CurrentBreak() + 5);
                    user1_score.setText(Integer.toString(getUser1Score()));
                    current_break_score.setText(Integer.toString(getUser1CurrentBreak()));
                } else {
                    setUser2Score(getUser2Score() + 5);
                    setUser2CurrentBreak(getUser2CurrentBreak() + 5);
                    user2_score.setText(Integer.toString(getUser2Score()));
                    current_break_score.setText(Integer.toString(getUser2CurrentBreak()));
                }
            }
        });
        pinkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getUser1Status()) {
                    setUser1Score(getUser1Score() + 6);
                    setUser1CurrentBreak(getUser1CurrentBreak() + 6);
                    user1_score.setText(Integer.toString(getUser1Score()));
                    current_break_score.setText(Integer.toString(getUser1CurrentBreak()));
                } else {
                    setUser2Score(getUser2Score() + 6);
                    setUser2CurrentBreak(getUser2CurrentBreak() + 6);
                    user2_score.setText(Integer.toString(getUser2Score()));
                    current_break_score.setText(Integer.toString(getUser2CurrentBreak()));
                }
            }
        });
        blackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getUser1Status()) {
                    setUser1Score(getUser1Score() + 7);
                    setUser1CurrentBreak(getUser1CurrentBreak() + 7);
                    user1_score.setText(Integer.toString(getUser1Score()));
                    current_break_score.setText(Integer.toString(getUser1CurrentBreak()));
                } else {
                    setUser2Score(getUser2Score() + 7);
                    setUser2CurrentBreak(getUser2CurrentBreak() + 7);
                    user2_score.setText(Integer.toString(getUser2Score()));
                    current_break_score.setText(Integer.toString(getUser2CurrentBreak()));
                }
            }
        });


        breakButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getUser1Status()) {
                    setUser1Status(false);
                    setUser2Status(true);
                    user1Breaks.add(getUser1CurrentBreak());
                    setUser1CurrentBreak(0);
                    current_break_score.setText("00");
                    currentPlayerName.setText(getUser2());
                } else {
                    setUser1Status(true);
                    setUser2Status(false);
                    user2Breaks.add(getUser2CurrentBreak());
                    setUser2CurrentBreak(0);
                    current_break_score.setText("00");
                    currentPlayerName.setText(getUser1());
                }
            }
        });


        foulButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getUser1Status()) {
                    setUser1Status(false);
                    setUser2Status(true);
                    setUser1CurrentBreak(getUser1CurrentBreak() - 4);
                    setUser1Score(getUser1Score() - 4);
                    user1Breaks.add(getUser1CurrentBreak());
                    setUser1CurrentBreak(0);
                    current_break_score.setText("00");
                    currentPlayerName.setText(getUser2());
                    user1_score.setText(Integer.toString(getUser1Score()));
                } else {
                    setUser1Status(true);
                    setUser2Status(false);
                    setUser2CurrentBreak(getUser2CurrentBreak() - 4);
                    user2Breaks.add(getUser2CurrentBreak());
                    setUser2Score(getUser2Score() - 4);
                    setUser2CurrentBreak(0);
                    current_break_score.setText("00");
                    currentPlayerName.setText(getUser1());
                    user2_score.setText(Integer.toString(getUser2Score()));
                }
            }
        });

        finishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                setFinishTime(System.currentTimeMillis() / 1000L);

                Intent gotoResults = new Intent(getApplicationContext(), Results.class);


                gotoResults.putExtra("user1_name",  getUser1());
                gotoResults.putExtra("user2_name", getUser2());

                gotoResults.putExtra("user1_score", getUser1Score());
                gotoResults.putExtra("user2_score", getUser2Score());

                gotoResults.putExtra("user1_break", getMax(user1Breaks));
                gotoResults.putExtra("user2_break", getMax(user2Breaks));

                gotoResults.putExtra("start_time", getStartTime());
                gotoResults.putExtra("finish_time", getFinishTime());

                startActivity(gotoResults);


            }
        });








    }
}
