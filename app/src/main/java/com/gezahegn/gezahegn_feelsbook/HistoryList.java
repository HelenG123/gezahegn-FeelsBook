package com.gezahegn.gezahegn_feelsbook;

import java.util.ArrayList;
import java.util.Collection;

public class HistoryList {
    protected ArrayList<Emotions> historyList;

//    Constructor
    public HistoryList() {
        historyList = new ArrayList<Emotions>();
    }

    public Collection<Emotions> getHistory() {
        return historyList;
    }

    public void addEmotion(Emotions emotion) {
        historyList.add(emotion);
    }

    public void deleteEmotion(Emotions emotion) {
        historyList.remove(emotion);
    }

}
