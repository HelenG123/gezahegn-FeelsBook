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
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

//import static com.gezahegn.gezahegn_feelsbook.HistoryListController.historyList2;


public class MainActivity extends AppCompatActivity {

    public static HistoryListController historyListController = new HistoryListController();

    // The comment and date attribute for each instance of the Emotion class
    public EditText mainComment;
//    public static HistoryList historyList3;

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

        /*------------------------THE 6 EMOTION BUTTONS SECTION --------------------------*/

        // Initialize all 6 emotion buttons
        joyButton = (ImageButton) findViewById(R.id.joyButton);
        angryButton = (ImageButton) findViewById(R.id.angryButton);
        loveButton = (ImageButton) findViewById(R.id.loveButton);
        sadButton = (ImageButton) findViewById(R.id.sadButton);
        surpriseButton = (ImageButton) findViewById(R.id.surpriseButton);
        fearButton = (ImageButton) findViewById(R.id.fearButton);

        //Initialize the mainComment
        mainComment = (EditText) findViewById(R.id.mainComment);

        // Initialize an instance of the HistoryList class
        final HistoryList historyList1 = new HistoryList();



        // Resource: https://stackoverflow.com/questions/16473315/multiple-imagebuttons-for-one-purpose-in-a-fragment
        View.OnClickListener emojiPressedListener = new View.OnClickListener() {
            // When one of the emoji buttons has been clicked
            @Override
            public void onClick(View view) {

                // ContentDescription is set for each emotion. For instance, joyButton's ContentDescription is joy.
                String emotionType = (String)view.getContentDescription();
                //for testing: Log.d("Status:", emotionType);

                // Update the emotionCounter dictionary/HashMap. Increment for the specific emotion.
                Integer updatedVal = emotionCounter.get(emotionType) + 1;
                emotionCounter.put(emotionType, updatedVal);
                // for testing: Log.d(emotionType, "Value: " + updatedVal);

                // Store whatever text was written in the comment, then clear the comment box.
                String currComment = mainComment.getText().toString();
                mainComment.getText().clear();

                // Store the timestamp in the ISO-8601 format
                // Resource: https://stackoverflow.com/questions/13515168/android-time-in-iso-8601
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.CANADA);
                String currTime = sdf.format(new Date());
                // for testing: Log.d("Current Time", " " + currTime);

                // Create an instance of the Emotions class
                Emotions currEmotion = new Emotions(emotionType, currComment, currTime);
                // for testing: Log.d("TESTING OBJECT", "Instance: " + currEmotion.comment);

                historyListController.addEmotion(currEmotion);
//                historyList2.addEmotion(currEmotion);
//                historyList1.addEmotion(currEmotion);
                // for testing:
//                Log.d("TESTING OBJECT", "Instance: " + historyList1.getHistory());
                }

//                HistoryList historyList3 =

            };

        // Set the OnClickListeners for the 6 emotion buttons so that when pressed,
        // it'll call the method above.
        joyButton.setOnClickListener(emojiPressedListener);
        angryButton.setOnClickListener(emojiPressedListener);
        loveButton.setOnClickListener(emojiPressedListener);
        sadButton.setOnClickListener(emojiPressedListener);
        surpriseButton.setOnClickListener(emojiPressedListener);
        fearButton.setOnClickListener(emojiPressedListener);


        /*------------------------HISTORY AND COUNT SECTION-------------------------------*/

        // Initialize the HISTORY and COUNT button
        historyButton = (Button)findViewById(R.id.historyButton);
        countButton = (Button)findViewById(R.id.countButton);

        // When the HISTORY button is clicked, redirect to the HistoryActivity page
        historyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /* Intent is just like glue which helps to navigate one activity to another. */


                Intent intent = new Intent(MainActivity.this, HistoryActivity.class);
//                intent.putExtra("array_list", historyList1);
//                Bundle bundle = new Bundle();
//                bundle.putSerializable("array_list", historyList1);
//                intent.putExtras(bundle);
                startActivity(intent); // startActivity allow you to move to the other activity
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

//    public void add2HistoryList(View v) {
//        Toast.makeText(this, "Choose an Emotion", Toast.LENGTH_SHORT).show();
////        HistoryListController hl = new HistoryListController();
//        try {
//            Emotions e = hl.chooseEmotion();
//        } catch (EmptyHistoryListException e) {
//            Toast.makeText(this, "The history list is empty.", Toast.LENGTH_SHORT).show();
//        }
//    }

}
