package edu.cpp.cs499.snookinfo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

public class Details extends AppCompatActivity{

    private  String user1;
    private  String user2;
    private long unixStartTime;

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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details);

        Button startButton = findViewById(R.id.start_button);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText user1EditText = findViewById(R.id.user1);
                EditText user2EditText = findViewById(R.id.user2);

                setUser1(user1EditText.getText().toString());
                setUser2(user2EditText.getText().toString());

                unixStartTime = System.currentTimeMillis() / 1000L;
//                Log.i("TAG", "onClick: "+unixStartTime);



                if ((getUser1().matches("[a-zA-Z]+")) && (getUser2().matches("[a-zA-Z]+")) && !getUser1().equalsIgnoreCase(getUser2())) {
                    Intent gotoScoreboard = new Intent(getApplicationContext(),ScoreBoard.class);
                    gotoScoreboard.putExtra("user1",getUser1());
                    gotoScoreboard.putExtra("user2", getUser2());
                    gotoScoreboard.putExtra("unixStartTime",unixStartTime);

                    startActivity(gotoScoreboard);
                } else {
                    Toast.makeText(Details.this,"Enter valid name",Toast.LENGTH_LONG).show();
                }


            }
        });




    }
}
