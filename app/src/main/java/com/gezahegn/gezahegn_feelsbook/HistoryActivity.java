package com.gezahegn.gezahegn_feelsbook;

import android.app.ListFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.gezahegn.gezahegn_feelsbook.HistoryList;

import java.util.ArrayList;
import java.util.Collection;

//import static com.gezahegn.gezahegn_feelsbook.HistoryList.historyList;

public class HistoryActivity extends AppCompatActivity {

//    The historyList array has been imported from the other file HistoryList.java
    public ListView historyListView;
    public HistoryList hist;
    public Collection<Emotions> historyCollection;
//    public ArrayList<String> testArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history_activity);
        historyListView = (ListView)findViewById(R.id._historyListView);

        ArrayList <String> testArray = new ArrayList<String>();
        testArray.add("Hello");
        testArray.add("What");
        testArray.add("Help");



//        historyCollection = historyList.getHistory();
//        ArrayList<Emotions> historyCollection2List = new ArrayList(historyCollection);

        // This is the array adapter, it takes the context of the activity as a
        // first parameter, the type of list view as a second parameter and your
        // array as a third parameter.
//        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
//                this,
//                android.R.layout.simple_list_item_1,
//                testArray
//        );
//
//        historyListView.setAdapter(arrayAdapter);


    }

}
