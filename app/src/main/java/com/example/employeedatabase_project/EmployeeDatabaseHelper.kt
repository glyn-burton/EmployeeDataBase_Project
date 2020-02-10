package com.example.employeedatabase_project

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class EmployeeDatabaseHelper(context:Context) :
    SQLiteOpenHelper(context, DATABASE_NAME,null, DATABASE_VERSION) {
    override fun onCreate(sqLiteDatabase: SQLiteDatabase?) {
        sqLiteDatabase?.execSQL(CREATE_EMPLOYEE_TABLE)
        sqLiteDatabase?.execSQL(CREATE_DEPARTMENT_TABLE)


    }

    override fun onUpgrade(sqLiteDatabase: SQLiteDatabase?, previousVersion: Int, newVersion: Int) {
        onCreate(sqLiteDatabase)

    }

    fun insertPersonIntoDatabase(employee:Employee){
        val database = writableDatabase

        val contentValues = ContentValues()

        contentValues.put(COL_FIRST_NAME,employee.firstName)
        contentValues.put(COL_LAST_NAME, employee.lastName)
        contentValues.put(COL_STREET_ADDRESS, employee.streetAddress)
        contentValues.put(COL_CITY, employee.city)
        contentValues.put(COL_STATE, employee.state)
        contentValues.put(COL_ZIP, employee.zip)
        contentValues.put(COL_POSITION, employee.position)
        contentValues.put(COL_DEPARTMENT, employee.department)
        contentValues.put(COL_TAXID, employee.taxID)


        database.insert(TABLE_NAME, null, contentValues)
        database.close()


    }

    fun getOnePersonFromDatabase(taxId:String):Employee?{
        val database = readableDatabase
        var employee:Employee? = null
        val cursor = database
            .rawQuery("SELECT * FROM $TABLE_NAME WHERE $COL_TAXID = $taxId",
                null)
        if (cursor.moveToFirst()){

            val firstName = cursor.getString(cursor.getColumnIndex(COL_FIRST_NAME))
            val lastName = cursor.getString(cursor.getColumnIndex(COL_LAST_NAME))
            val address = cursor.getString(cursor.getColumnIndex(COL_STREET_ADDRESS))
            val city = cursor.getString(cursor.getColumnIndex(COL_CITY))
            val state = cursor.getString(cursor.getColumnIndex(COL_STATE))
            val zip = cursor.getString(cursor.getColumnIndex(COL_ZIP))
            val department = cursor.getString(cursor.getColumnIndex(COL_DEPARTMENT))
            val position = cursor.getString(cursor.getColumnIndex(COL_POSITION))
            val taxid = cursor.getString(cursor.getColumnIndex(COL_TAXID))
            employee = Employee(firstName,lastName,address,city,state,zip,position,department,taxid)


        }
        cursor.close()
        database.close()
        return employee


    }

    fun getAllPeopleFromDatabase():ArrayList<Employee>
    {
        val database = readableDatabase
        var employeeList:ArrayList<Employee> = ArrayList<Employee>()
        var employee:Employee? = null
        val cursor = database
            .rawQuery("SELECT * FROM $TABLE_NAME",
                null)
        if (cursor.moveToFirst()){
            do {
                val firstName = cursor.getString(cursor.getColumnIndex(COL_FIRST_NAME))
                val lastName = cursor.getString(cursor.getColumnIndex(COL_LAST_NAME))
                val address = cursor.getString(cursor.getColumnIndex(COL_STREET_ADDRESS))
                val city = cursor.getString(cursor.getColumnIndex(COL_CITY))
                val state = cursor.getString(cursor.getColumnIndex(COL_STATE))
                val zip = cursor.getString(cursor.getColumnIndex(COL_ZIP))
                val position = cursor.getString(cursor.getColumnIndex(COL_POSITION))
                val department = cursor.getString(cursor.getColumnIndex(COL_DEPARTMENT))
                val taxid = cursor.getString(cursor.getColumnIndex(COL_TAXID))
                employee = Employee(firstName,lastName,address,city,state,zip,position,department,taxid)
                employeeList.add(employee)
            } while (cursor.moveToNext())

        }
        cursor.close()
        database.close()
        return employeeList


    }

    fun getAllPeopleFromDepartment(departmentName:String):ArrayList<Employee>
    {
        val database = readableDatabase
        var employeeList:ArrayList<Employee> = ArrayList<Employee>()
        var employee:Employee? = null
        val cursor = database
            .rawQuery("SELECT * FROM $TABLE_NAME WHERE $COL_DEPARTMENT = '$departmentName'",
                null)
        if (cursor.moveToFirst()){
            do {
                val firstName = cursor.getString(cursor.getColumnIndex(COL_FIRST_NAME))
                val lastName = cursor.getString(cursor.getColumnIndex(COL_LAST_NAME))
                val address = cursor.getString(cursor.getColumnIndex(COL_STREET_ADDRESS))
                val city = cursor.getString(cursor.getColumnIndex(COL_CITY))
                val state = cursor.getString(cursor.getColumnIndex(COL_STATE))
                val zip = cursor.getString(cursor.getColumnIndex(COL_ZIP))
                val position = cursor.getString(cursor.getColumnIndex(COL_POSITION))
                val department = cursor.getString(cursor.getColumnIndex(COL_DEPARTMENT))
                val taxid = cursor.getString(cursor.getColumnIndex(COL_TAXID))
                employee = Employee(firstName,lastName,address,city,state,zip,position,department,taxid)
                employeeList.add(employee)
            } while (cursor.moveToNext())

        }
        cursor.close()
        database.close()
        return employeeList


    }
    fun  updatePersonInDatabase(employee:Employee){
        val database = writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COL_FIRST_NAME,employee.firstName)
        contentValues.put(COL_LAST_NAME, employee.lastName)
        contentValues.put(COL_STREET_ADDRESS, employee.streetAddress)
        contentValues.put(COL_CITY, employee.city)
        contentValues.put(COL_STATE, employee.state)
        contentValues.put(COL_ZIP, employee.zip)
        contentValues.put(COL_DEPARTMENT, employee.department)
        contentValues.put(COL_POSITION, employee.position)
        contentValues.put(COL_TAXID, employee.taxID)

        database.update(TABLE_NAME,contentValues, "$COL_TAXID = '?'", arrayOf(employee.taxID))
        database.close()

    }

    fun removePersonFromDatabase(taxId:String){
        val database = writableDatabase
        database.delete(TABLE_NAME,"$COL_TAXID = '?'", arrayOf(taxId))
        database.close()




    }
     fun insertDepartmentToBase(string: String)
     {
         val db = writableDatabase
         val contentValues = ContentValues()
         contentValues.put(COL_DEPARTMENT,string)

         db.insert(TABLE_NAME_D,null,contentValues)
         db.close()
     }

    fun getAllDepertmentFromDatabase(): ArrayList<String>{
        val database = readableDatabase
        var departmentList : ArrayList<String> = ArrayList<String>()
        val cursor = database.rawQuery("SELECT * FROM $TABLE_NAME_D",null)

        if(cursor.moveToFirst()) {
            do {
                val department = cursor.getString(cursor.getColumnIndex(COL_DEPARTMENT))
                departmentList.add((department))
            } while (cursor.moveToNext())

        }
         cursor.close()
        database.close()
        return departmentList


        }

    fun UpdateDatabase(passedList : ArrayList<Employee>){
        var employeeList:ArrayList<Employee> = ArrayList<Employee>()
        employeeList = passedList

    }

    }

