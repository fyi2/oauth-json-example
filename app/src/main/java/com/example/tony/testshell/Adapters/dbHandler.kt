package com.example.tony.testshell.Adapters

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.tony.testshell.Data.CREATE_STATION_TABLE
import com.example.tony.testshell.Data.DATABASE_NAME
import com.example.tony.testshell.Data.DATABASE_VERSION
import com.example.tony.testshell.Data.TABLE_NAME


/**
 * Created by Tony on 11/1/2017.
 */
class dBHandler(context: Context): SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase?) {
        //SQL - Structured Query Language
        db?.execSQL(CREATE_STATION_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db?.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME)
        //create table again
        onCreate(db)
    }
}