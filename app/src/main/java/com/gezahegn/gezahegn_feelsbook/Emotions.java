package com.gezahegn.gezahegn_feelsbook;

public class Emotions {
    protected String emotionType;

    public Emotions(String emotionType) {
        this.emotionType = emotionType;
    }

    public String getEmotionType() {
//        When generated, initially had return emotionType without the 'this'
        return this.emotionType;
    }
}
