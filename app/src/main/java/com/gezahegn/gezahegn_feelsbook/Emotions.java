package com.gezahegn.gezahegn_feelsbook;

public class Emotions {
    protected String comment;
    protected String emotionType;

    public Emotions(String emotionType, String comment) {
        this.emotionType = emotionType;
        this.comment = comment;
    }

    public String getEmotionType() {
//        When generated, initially had return emotionType without the 'this'
        return this.emotionType;
    }
}
