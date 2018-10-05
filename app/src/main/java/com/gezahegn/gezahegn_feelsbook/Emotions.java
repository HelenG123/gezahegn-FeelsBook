package com.gezahegn.gezahegn_feelsbook;

public class Emotions {
    protected String comment;
    protected String timestamp;
    protected String emotionType;

    public Emotions(String emotionType, String comment, String timestamp) {
        this.emotionType = emotionType;
        this.comment = comment;
        this.timestamp = timestamp;
    }

    public String getEmotionType() {
//        When generated, initially had return emotionType without the 'this'
        return this.emotionType;
    }
}
