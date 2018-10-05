package com.gezahegn.gezahegn_feelsbook;

import android.util.Log;

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

    public void deleteEmotion(Integer index) {
        Emotions currEmotion = historyList.get(index-1);
        Log.d("Current Element: ", " "+currEmotion.getEmotionType());
        historyList.remove(currEmotion);
    }

    public Emotions editEmotion(Emotions emotion) {

        return emotion;
    }

    public Integer getSize() {
      return historyList.size();
    };



}
