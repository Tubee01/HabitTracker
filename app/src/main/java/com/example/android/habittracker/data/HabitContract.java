package com.example.android.habittracker.data;


import android.provider.BaseColumns;

/**
 * Created by tamas on 2017. 07. 20..
 */

public class HabitContract{

    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    private HabitContract(){

    }

    /**
     * Inner class that defines constant values for the habits database table.
     * Each entry in the table represents a single habit.
     */
    public static final class HabitEntry implements BaseColumns{

        /** Name of database table for habits */
        final static String TABLE_NAME = "habits";

        /**
         * Unique ID number for the habit( only for use i the database table).
         *
         * Type : INTEGER
         */
        final static  String _ID = BaseColumns._ID;

        /**
         * Name of the habit.
         *
         * Type : TEXT
         */
        public final static String COLUMN_HABIT_NAME = "name";

        /**
         * Category of the habit
         *
         * Type : INTEGER
         */
        public  final static String COLUMN_HABIT_CATEGORY = "category";
        /**
         * Number of minutes spent with habit.
         *
         * Type : INTEGER
         */
        public final static String COLUMN_HABIT_MINUTES = "minutes";
        /**
         * Pssible categories of a habit entry.
         */
        public static final int CATEGORY_WORK = 1;
        public static final int CATEGORY_HOUSE_KEEPING = 2;
        public static final int CATEGORY_FREE_TIME = 3;

    }
}
