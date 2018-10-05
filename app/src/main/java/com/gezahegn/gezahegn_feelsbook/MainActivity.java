/*
FeelsBook: Make a simple, attractive, intuitive, mobile app to record feelings quickly.

Copyright (C) 2018 Helen Gezahegn gezahegn@ualberta.ca

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.
This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
GNU General Public License for more details.
You should have received a copy of the GNU General Public License
along with this program. If not, see <http://www.gnu.org/licenses/>.
*/

package com.gezahegn.gezahegn_feelsbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    // The history and count button that redirect to two different activities
    public Button historyButton;
    public Button countButton;

    // The 6 emotions/emoji buttons
    public ImageButton joyButton;
    public ImageButton angryButton;
    public ImageButton loveButton;
    public ImageButton sadButton;
    public ImageButton surpriseButton;
    public ImageButton fearButton;
    public static Map<String, Integer> emotionCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the counter. It's a dictionary/HashMap that will keep track of all the emotions
        emotionCounter = new HashMap<String, Integer>() {{
            put("joy", 0);
            put("angry", 0);
            put("love", 0);
            put("sad", 0);
            put("surprise", 0);
            put("fear", 0);

        }};

        /*------------------------THE 6 EMOTIONS SECTION --------------------------*/

        // Initialize all 6 emotions
        joyButton = (ImageButton) findViewById(R.id.joyButton);
        angryButton = (ImageButton) findViewById(R.id.angryButton);
        loveButton = (ImageButton) findViewById(R.id.loveButton);
        sadButton = (ImageButton) findViewById(R.id.sadButton);
        surpriseButton = (ImageButton) findViewById(R.id.surpriseButton);
        fearButton = (ImageButton) findViewById(R.id.fearButton);

        // Resource: https://stackoverflow.com/questions/16473315/multiple-imagebuttons-for-one-purpose-in-a-fragment
        View.OnClickListener emojiPressedListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // ContentDescription is set for each emotion.
                // For instance, joyButton's ContentDescription is joy.
                String emotionType = (String)view.getContentDescription();
                //for testing: Log.d("Status:", emotionType);

                // Update the emotionCounter dictionary/HashMap
                // Increment for the specific emotion
                Integer updatedVal = emotionCounter.get(emotionType) + 1;
                emotionCounter.put(emotionType, updatedVal);
                // for testing:
                Log.d(emotionType, "Value: " + updatedVal);



                }
            };


        joyButton.setOnClickListener(emojiPressedListener);
        angryButton.setOnClickListener(emojiPressedListener);
        loveButton.setOnClickListener(emojiPressedListener);
        sadButton.setOnClickListener(emojiPressedListener);
        surpriseButton.setOnClickListener(emojiPressedListener);
        fearButton.setOnClickListener(emojiPressedListener);


        /*------------------------HISTORY AND COUNT SECTION------------------------*/

        // Initialize the HISTORY and COUNT button
        historyButton = (Button)findViewById(R.id.historyButton);
        countButton = (Button)findViewById(R.id.countButton);

        // When the HISTORY button is clicked, redirect to the ListHistoryActivity page
        historyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /* Intent is just like glue which helps to navigate one activity
                * to another. */
                Intent intent = new Intent(MainActivity.this, ListHistoryActivity.class);
                startActivity(intent); // startActivity allow you to move
            }
        });

        // When the COUNT button is pressed, redirect to the CountActivity
        countButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CountActivity.class);
                startActivity(intent);
            }
        });

    }

    public void onClick(ImageButton emotionType) {
        Log.d("Emotion:", "hello");
    }

//    public View.OnClickListener emojiPressed() = new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//        Emotions currEmotion = new Emotions(emotionType);
//        Log.d("hello", "emojiPressed:");
//        // Increment the count for that specific emotion
//        Integer updatedVal = emotionCounter.get(emotionType) + 1;
//        emotionCounter.put(emotionType, updatedVal);
//    }

}
