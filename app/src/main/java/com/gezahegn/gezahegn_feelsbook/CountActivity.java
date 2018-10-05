package com.gezahegn.gezahegn_feelsbook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Iterator;

import static com.gezahegn.gezahegn_feelsbook.MainActivity.emotionCounter;

public class CountActivity extends AppCompatActivity {

    // The 6 counters
    public TextView joyCounter;
    public TextView angerCounter;
    public TextView loveCounter;
    public TextView sadCounter;
    public TextView surpriseCounter;
    public TextView fearCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.count_activity);

        // Initialize all 6 emotion counters
        joyCounter = (TextView) findViewById(R.id.joyCounter);
        angerCounter = (TextView) findViewById(R.id.angerCounter);
        loveCounter = (TextView) findViewById(R.id.loveCounter);
        sadCounter = (TextView) findViewById(R.id.sadCounter);
        surpriseCounter = (TextView) findViewById(R.id.surpriseCounter);
        fearCounter = (TextView) findViewById(R.id.fearCounter);

        // Iterate through the HashMap, checking each emotion and its value
        // Update the TextView to the specific emotion's counter value.
        for (String key: emotionCounter.keySet()) {
            if (key.equals("joy")) {
                joyCounter.setText(emotionCounter.get(key).toString());
            }
            else if (key.equals("angry")) {
                angerCounter.setText(emotionCounter.get(key).toString());
            }
            else if (key.equals("love")) {
                loveCounter.setText(emotionCounter.get(key).toString());
            }
            else if (key.equals("sad")) {
                sadCounter.setText(emotionCounter.get(key).toString());
            }
            else if (key.equals("surprise")) {
                surpriseCounter.setText(emotionCounter.get(key).toString());
            }
            else {
                fearCounter.setText(emotionCounter.get(key).toString());
            }
        }


    }
}
