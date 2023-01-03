package com.example.lista2

import android.provider.BaseColumns

object TableInfo : BaseColumns {
    const val TABLE_NAME = "Jobs"
    const val TITLE = "title"
    const val DETAILS = "details"
}

object BasicCommand {
    const val SQL_CREATE_TABLE =
        "CREATE TABLE IF NOT EXISTS ${TableInfo.TABLE_NAME} (" +
                "id INTEGER PRIMARY KEY, " +
                "${TableInfo.TITLE} TEXT NOT NULL, " +
                "${TableInfo.DETAILS} TEXT NOT NULL)"
}

