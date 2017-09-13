package com.example.akshay.parth.data;

import android.provider.BaseColumns;


public final class NotifyContract {

    public NotifyContract() {
    }

    public static abstract class NotifyEntry implements BaseColumns {

        public static final String TABLE_NAME="questions";


        public static final String COLUMN_ID= BaseColumns._ID;
        public static final String COLUMN_NOTIFY_QUESTION="question";
        public static final String COLUMN_NOTIFY_ANSWER="answer";
        public static final String COLUMN_NOTIFY_OPTIONONE="optionone";
        public static final String COLUMN_NOTIFY_OPTIONTWO="optiontwo";
        public static final String COLUMN_NOTIFY_OPTIONTHREE="optionthree";
        public static final String COLUMN_NOTIFY_OPTIONFOUR="optionfour";










    }
}
