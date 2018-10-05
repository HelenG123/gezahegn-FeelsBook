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

//    public Emotions add2HistoryList() throws EmptyHistoryListException {
//        return getHistoryList().chooseEmotion();
//    }
    public void addEmotion(Emotions emotion) {
        getHistoryList().addEmotion(emotion);
        // for testing: Log.d("PRINT THE LIST OUT:", " " + getHistoryList().getHistory());
    }

    public void deleteEmotion(Integer index) {
        getHistoryList().deleteEmotion(index);
//        getHistoryList().deleteEmotion(emotion);

    }

}
