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

    public String getComment() {
        return this.comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

}
