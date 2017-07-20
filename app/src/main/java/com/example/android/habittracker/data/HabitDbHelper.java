package com.example.android.habittracker.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.android.habittracker.data.HabitContract.HabitEntry;
/**
 * Created by tamas on 2017. 07. 20..
 */

public class HabitDbHelper extends SQLiteOpenHelper {
    public static final String LOG_TAG = HabitDbHelper.class.getSimpleName();
    /** Name of the database file
     */
    private static final String DATABASE_NAME = "my_habits.db";
    /** Database version. If you change the database schema, you must increment the database version.
     */
    private static final int DATABASE_VERSION = 1;
    /** Constructs a new instance of {@link HabitDbHelper}
    * @param context of the app
    */
    public HabitDbHelper(Context context){super(context, DATABASE_NAME, null, DATABASE_VERSION);}

    /**
     * This is called when the database is created for the first time.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        // SQL String that creates the habits table in the database
        final String SQL_CREATE_HABITS_TABLE = "CREATE TABLE " + HabitEntry.TABLE_NAME + " ("
                + HabitEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + HabitEntry.COLUMN_HABIT_NAME + " TEXT NOT NULL, "
                + HabitEntry.COLUMN_HABIT_CATEGORY + " INTEGER NOT NULL DEFAULT 0, "
                + HabitEntry.COLUMN_HABIT_MINUTES+ " INTEGER NOT NULL DEFAULT 1);";

        db.execSQL(SQL_CREATE_HABITS_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // SQL statement that deletes habits database table
        final String DELETE_DATABASE_SQL = " DROP TABLE IF EXIST " + HabitEntry.TABLE_NAME;

        // Execute DELETE SQL statement defined above
        db.execSQL(DELETE_DATABASE_SQL);
        // Upgrade the new db
        onCreate(db);
    }
    public void insertHabit(String name, int category, int minutes){
        SQLiteDatabase database = getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(HabitEntry.COLUMN_HABIT_NAME, name);
        contentValues.put(HabitEntry.COLUMN_HABIT_CATEGORY, category);
        contentValues.put(HabitEntry.COLUMN_HABIT_MINUTES, minutes);

        database.insert(HabitEntry.TABLE_NAME, null, contentValues);

    }

    /**
     * Queries the habits from the corrresponding db table
     */
    public Cursor queryHabits(){
        Cursor cursor;
        SQLiteDatabase database = getReadableDatabase();

        //Defining the columns need to retrieve
        String[] projection = {
               HabitEntry.COLUMN_HABIT_NAME,
                HabitEntry.COLUMN_HABIT_CATEGORY,
                HabitEntry.COLUMN_HABIT_MINUTES
        };
        cursor = database.query(
                HabitEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null);
        return cursor;

    }
}
