package com.taskfoundation.timestable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);

        final ListView listViewTimesTable = (ListView) findViewById(R.id.listView);

        int max = 20;
        int startingPosition = 1;

        seekBar.setMax(max);
        seekBar.setProgress(startingPosition);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int min = 1;
                int timesTableNumber;

                if (i < min) {
                    timesTableNumber = min;
                    seekBar.setProgress(min);
                } else {
                    timesTableNumber = i;
                }

                ArrayList<String> content = new ArrayList<String>();

                for (int j = 1; j < 100; j++) {
                    content.add(Integer.toString(j * timesTableNumber));
                }

                ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,content);

                listViewTimesTable.setAdapter(arrayAdapter);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}