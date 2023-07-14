package com.vyp.quotes.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "quotes.db";
    private static final int DATABASE_VERSION = 1;

    // Table name and column names
    private static final String TABLE_FAVOURITES = "favourites";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_CATEGORY = "category";
    private static final String COLUMN_FAVOURITE_ID = "favouriteId";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // Create the "favourites" table
        String createTableQuery = "CREATE TABLE " + TABLE_FAVOURITES + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_CATEGORY + " TEXT, " +
                COLUMN_FAVOURITE_ID + " INTEGER)";
        sqLiteDatabase.execSQL(createTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        // Handle database upgrades, if necessary
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_FAVOURITES);
        onCreate(sqLiteDatabase);
    }

    // Method to add a favourite
    public void addFavourite(String category, int favouriteId) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_CATEGORY, category);
        values.put(COLUMN_FAVOURITE_ID, favouriteId);
        db.insert(TABLE_FAVOURITES, null, values);
        db.close();
    }

    // Method to remove a favourite
    public void removeFavourite(int favouriteId) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_FAVOURITES, COLUMN_FAVOURITE_ID + " = ?", new String[]{String.valueOf(favouriteId)});
        db.close();
    }

    // Method to check if a favouriteId is present
    public boolean isFavouriteIdPresent(int favouriteId) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_FAVOURITES + " WHERE " + COLUMN_FAVOURITE_ID + " = ?";
        Cursor cursor = db.rawQuery(query, new String[]{String.valueOf(favouriteId)});
        boolean isPresent = (cursor.getCount() > 0);
        cursor.close();
        db.close();
        return isPresent;
    }
}
