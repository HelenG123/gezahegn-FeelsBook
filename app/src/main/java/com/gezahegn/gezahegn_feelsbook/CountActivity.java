package com.gezahegn.gezahegn_feelsbook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

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

    }
}
