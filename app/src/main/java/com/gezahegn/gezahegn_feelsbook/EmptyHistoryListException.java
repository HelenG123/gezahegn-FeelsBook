package com.gezahegn.gezahegn_feelsbook;

public class EmptyHistoryListException extends Exception {

    EmptyHistoryListException() {
        super("There are no emotions recorded. Please go back and record some!");
    }

}
