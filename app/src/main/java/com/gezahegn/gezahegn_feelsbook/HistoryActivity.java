package com.gezahegn.gezahegn_feelsbook;

import android.app.ListFragment;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.gezahegn.gezahegn_feelsbook.HistoryList;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static android.os.UserHandle.readFromParcel;

//import static com.gezahegn.gezahegn_feelsbook.MainActivity.historyList1;

//import static com.gezahegn.gezahegn_feelsbook.HistoryList.historyList;

public class HistoryActivity extends MainActivity {

//    The historyList array has been imported from the other file HistoryList.java
    public ListView historyListView;
//    public HistoryList hist;
    public Collection<Emotions> historyCollection;
    public ArrayList<String> formattedArray = new ArrayList<String>();
    public List<String> myArraySpinner = new ArrayList<String>();

    public Button saveEditButton;
    public Button saveDeleteButton;

    // The inputs
    public EditText editInput;
    public EditText deleteInput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history_activity);
        historyListView = (ListView) findViewById(R.id._historyListView);

        saveEditButton = (Button) findViewById(R.id.saveEditButton);
        saveDeleteButton = (Button) findViewById(R.id.saveDeleteButton);

        editInput = (EditText) findViewById(R.id.editInput);
        deleteInput = (EditText) findViewById(R.id.deleteInput);

        historyListView.setAdapter(null);

        // Add the 6 emotions to the dropdown Spinner menu
        for (String emotion : emotionCounter.keySet()) {
            myArraySpinner.add(emotion);
        }
        // for testing: Log.d("Emotions in Spinner?:", " "+myArraySpinner);

        // Populate the spinner
        // Resource: https://stackoverflow.com/questions/11920754/android-fill-spinner-from-java-code-programmatically
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, myArraySpinner);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner sItems = (Spinner) findViewById(R.id.emotionDropDown);
        sItems.setAdapter(spinnerAdapter);

        // for testing: Log.d("HELLO", " "+ HistoryListController.getHistoryList().getHistory());
        final ArrayList<Emotions> historyArray = HistoryListController.getHistoryList().getHistory();

        // Iterate over the testArray and format it with the timestamp, comment, and emotion.
        for (Emotions emotion : historyArray) {
            String currEmotion = "Date: " + emotion.getTimestamp() +
                    "\nEmotion: " + emotion.getEmotionType() +
                    "\nComment: " + emotion.getComment();
            formattedArray.add(currEmotion);
        }
        historyListView.setAdapter(null);

        // This is the array adapter, it takes the context of the activity as a
        // first parameter, the type of list view as a second parameter and your
        // array as a third parameter.
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                formattedArray
        );
//
        historyListView.setAdapter(arrayAdapter);

        // When the save buttons are pressed
        View.OnClickListener saveButtonPressed = new View.OnClickListener() {
            // When one of the emoji buttons has been clicked
            // Resource: https://stackoverflow.com/questions/22025498/my-switch-view-getid-doesnt-work
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.saveDeleteButton:
                        String emotionIndex = deleteInput.getText().toString();
                        deleteInput.getText().clear();

                        // Check input to ensure it's a number
                        // Resource: https://stackoverflow.com/questions/10120212/how-to-determine-if-an-input-in-edittext-is-an-integer
                        try {
                            Integer num = Integer.parseInt(emotionIndex);

                            // Call delete and pass in index in the HistoryList
                            historyListController.deleteEmotion(num);
                            arrayAdapter.clear();
                            update();
                        } catch (NumberFormatException e) {
                            Log.d("Error Message: ", "Not valid input.");
                        }

                }

            }
        };
        saveEditButton.setOnClickListener(saveButtonPressed);
        saveDeleteButton.setOnClickListener(saveButtonPressed);
    }

    public void update() {
        Intent intent = getIntent();
        overridePendingTransition(0, 0);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        finish();
        overridePendingTransition(0, 0);
        startActivity(intent);
    }
}
