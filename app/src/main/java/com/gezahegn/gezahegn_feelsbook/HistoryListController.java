package com.gezahegn.gezahegn_feelsbook;

import android.util.Log;

import java.io.IOException;

public class HistoryListController {
    private static HistoryList historyList2 = null;

    // Lazy Singleton
    public static HistoryList getHistoryList() {
        if (historyList2 == null) {
            historyList2 = new HistoryList();
        }
        return historyList2;
    }

    public void addEmotion(Emotions emotion) {
        getHistoryList().addEmotion(emotion);
        // for testing: Log.d("PRINT THE LIST OUT:", " " + getHistoryList().getHistory());
    }

    public void deleteEmotion(Integer index) {
        Integer currSize = getSize();
        if (index > currSize) {
            Log.d("Error Message:", "Out of range");
        }
        else {
            getHistoryList().deleteEmotion(index);
        }
    }

    public Integer getSize() {
        return getHistoryList().getSize();
    }

}
