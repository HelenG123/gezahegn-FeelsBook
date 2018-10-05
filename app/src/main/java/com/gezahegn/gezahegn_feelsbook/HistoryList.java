package com.gezahegn.gezahegn_feelsbook;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class HistoryList implements Serializable {
    protected ArrayList<Emotions> historyList = null;

//    Constructor
    public HistoryList() {
        historyList = new ArrayList<Emotions>();
    }

    public ArrayList<Emotions> getHistory() {
        return historyList;
    }

    public void addEmotion(Emotions emotion) {
        historyList.add(emotion);
    }

    public void deleteEmotion(Emotions emotion) {
        historyList.remove(emotion);
    }

    public Emotions editEmotion(Emotions emotion) {

        return emotion;
    }



}
