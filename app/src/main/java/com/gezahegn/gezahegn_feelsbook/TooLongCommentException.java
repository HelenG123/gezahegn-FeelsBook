package com.gezahegn.gezahegn_feelsbook;

public class TooLongCommentException extends Exception{

    TooLongCommentException() {
        super("Comment can only be 100 characters");
    }
}
