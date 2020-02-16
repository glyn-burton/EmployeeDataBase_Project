package com.example.employeedatabase_project

import android.content.ContentUris
import android.net.Uri
import android.provider.BaseColumns

const val CONTENT_AUTHORITY = "com.example.employeedatabase"
val BASE_CONTENT_ID = Uri.parse("content://${CONTENT_AUTHORITY}")
const val PATH_EMPLOYEE = "employee"
val CONTENT_URI = BASE_CONTENT_ID.buildUpon().appendPath(PATH_EMPLOYEE).build()

class CelebrityEntry : BaseColumns
{
    //Static objects in Kotlin
    companion object
    {
        val CONTENT_TYPE = "vnd.android.cursor.dir/${CONTENT_URI}/${PATH_EMPLOYEE}"
        val CONTENT_ITEM_TYPE = "vnd.android.cursor.item/${CONTENT_URI}/${PATH_EMPLOYEE}"
        fun buildCelebrityUri(id : Long) = ContentUris.withAppendedId(CONTENT_URI, id)
    }

}