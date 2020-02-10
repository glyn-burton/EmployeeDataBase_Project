package com.example.employeedatabase_project

const val DATABASE_NAME = "data_employee_database"
const val TABLE_NAME = "employee_table"
const val TABLE_NAME_D = "department_table"
const val DATABASE_VERSION = 1
const val COL_FIRST_NAME = "first_name"
const val COL_LAST_NAME = "last_name"
const val COL_STREET_ADDRESS = "street_address"
const val COL_CITY = "city"
const val COL_STATE = "state"
const val COL_ZIP = "zip"
const val COL_POSITION = "position"
const val COL_DEPARTMENT = "department"
const val COL_TAXID = "taxid"



const val CREATE_EMPLOYEE_TABLE =
    "CREATE TABLE $TABLE_NAME (" +
            "$COL_FIRST_NAME String,"+
            "$COL_LAST_NAME String,"+
            "$COL_STREET_ADDRESS String,"+
            "$COL_CITY String,"+
            "$COL_STATE String,"+
            "$COL_ZIP String,"+
            "$COL_POSITION String,"+
            "$COL_DEPARTMENT String,"+
            "$COL_TAXID String PRIMARY_KEY)"

const val CREATE_DEPARTMENT_TABLE =
    "CREATE TABLE $TABLE_NAME_D("+
            "$COL_DEPARTMENT String PRIMARY_KEY)"