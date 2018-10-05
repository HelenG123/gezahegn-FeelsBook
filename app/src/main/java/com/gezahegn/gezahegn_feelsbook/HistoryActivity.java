package com.gezahegn.gezahegn_feelsbook;

import android.app.ListFragment;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.gezahegn.gezahegn_feelsbook.HistoryList;

import java.util.ArrayList;
import java.util.Collection;

import static android.os.UserHandle.readFromParcel;

//import static com.gezahegn.gezahegn_feelsbook.MainActivity.historyList1;

//import static com.gezahegn.gezahegn_feelsbook.HistoryList.historyList;

public class HistoryActivity extends MainActivity {

//    The historyList array has been imported from the other file HistoryList.java
    public ListView historyListView;
//    public HistoryList hist;
    public Collection<Emotions> historyCollection;
    public static ArrayList<String> formattedArray = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history_activity);
        historyListView = (ListView)findViewById(R.id._historyListView);

        // for testing: Log.d("HELLO", " "+ HistoryListController.getHistoryList().getHistory());
        ArrayList<Emotions> testArray = HistoryListController.getHistoryList().getHistory();

        // Iterate over the testArray and format it with the timestamp, comment, and emotion.
        for (Emotions emotion: testArray) {
            Log.d("Print", " " + emotion.getTimestamp());
            String currEmotion = "Date: " + emotion.getTimestamp() +
                                  "\nEmotion: " + emotion.getEmotionType() +
                                  "\nComment: " + emotion.getComment();
            formattedArray.add(currEmotion);
//            try {
//                formattedArray.add("Date"
////                    "Date: " + emotion.getTimestamp() +
////                            " Emotion: " + emotion.getEmotionType() +
////                            " Comment: " + emotion.getComment()
//                );
//            } catch (EmptyHistoryListException) {
//
//            }
        }

        // This is the array adapter, it takes the context of the activity as a
        // first parameter, the type of list view as a second parameter and your
        // array as a third parameter.
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                formattedArray
        );
//
        historyListView.setAdapter(arrayAdapter);

//        Intent intent = this.getIntent();
//        Bundle bundle = intent.getExtras();
//        Bundle extras = this.getIntent().getExtras();
//        if (extras != null) {
//            HistoryList historyList1 = (HistoryList)getIntent().getSerializableExtra("array_list");
//        }

        // Initialize an instance of the HistoryList class
//        HistoryList tempList = new HistoryList();
//        Log.d("Status:", " " + historyList1);

//        ArrayList <String> testArray = new ArrayList<String>();
//        testArray.add("Hello");
//        testArray.add("What");
//        testArray.add("Help");



//        historyCollection = historyList.getHistory();
//        ArrayList<Emotions> historyCollection2List = new ArrayList(historyCollection);



    }

}
