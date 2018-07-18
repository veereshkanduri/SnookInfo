package edu.cpp.cs499.snookinfo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StatsAdapter extends ArrayAdapter<ReadData> {

    Context context;
    ArrayList<ReadData> objects;
    public StatsAdapter(@NonNull Context context, int resource, @NonNull List<ReadData> objects) {
        super(context, 0, objects);
        this.context = context;
        this.objects = (ArrayList <ReadData>) objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ReadData currentObject = objects.get(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.stats_element,parent,false);
        }
        TextView players = convertView.findViewById(R.id.players);
        TextView scores = convertView.findViewById(R.id.scores);
        TextView event = convertView.findViewById(R.id.event);

      players.setText(currentObject.getName1() +"     vs     " + currentObject.getName2());
      scores.setText(currentObject.getScore1() +"           " + currentObject.getScore2());
        Date date = new java.util.Date(Long.parseLong(currentObject.begin) * 1000L);
        SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
        String formattedDate = sdf.format(date);
      event.setText(formattedDate);

        return convertView;
    }
}
