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


//oAUth values
val OAUTH_KEY = "rz93dfdxmtemmqn388zzdbdk"
val OAUTH_SECRET = "UUDPn4f3JBDJPun"
val OAUTH_URL = "https://api.athenahealth.com/oauthpreview/token"
val OAUTH_GRANT = "client_credentials"
val CONST_PRACTICE_ID = 195900
val URL_BASE = "https://api.athenahealth.com/preview1/"
val URL_PRACTICE_INFO = "/practiceinfo"
val URL_PATIENTS = "/patients"
val URL_POST_INVENTORY ="/inventory/items"


//General
val DEBUG = "DEBUG ===>>"


