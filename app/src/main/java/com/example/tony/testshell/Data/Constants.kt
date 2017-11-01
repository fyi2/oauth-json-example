package com.example.tony.testshell.Data

/**
 * Created by Tony on 11/1/2017.
 */
// Database (SQLite)

val DATABASE_VERSION : Int = 4
val DATABASE_NAME: String = "nexttrain.db"
val TABLE_NAME: String = "station"

// STATION table columns names
val KEY_ID: String = "id"
val KEY_STATION: String = "station_name"
val KEY_RECENT: String = "station_recent"
val KEY_FAVORITE: String = "station_favorite"


// SQL Commands
val CREATE_STATION_TABLE = "CREATE TABLE "+ TABLE_NAME + " ( "+ KEY_ID + " INTEGER PRIMARY KEY, "+
        KEY_STATION+" TEXT, "+
        KEY_FAVORITE+" INTEGER, "+
        KEY_RECENT+" LONG );"

val DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME
val SELECT_ALL = "SELECT * FROM " + TABLE_NAME


// Intent Codes
val CODE_STATION = 1
val CODE_TABBED = 2
val CODE_TEST = 3

