package com.example.employeedatabase_project

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_add_employee.*

class AddEmployeeActivity : AppCompatActivity() {
    var employeeList : ArrayList<Employee> = ArrayList<Employee>()
    val adapter = EmployeeAdapter(employeeList)
    val database = EmployeeDatabaseHelper(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_employee)
    }

    fun onClick(view: View) {

        when(view.id){

            R.id.btnAddEmployee ->{
                var newValues = ContentValues().apply{put(COL_FIRST_NAME,etName.text.toString())
                    put(COL_LAST_NAME,etLastName.text.toString())
                    put(COL_STREET_ADDRESS,etStreetAddress.text.toString())
                    put(COL_CITY,etCity.text.toString())
                    put(COL_STATE,etState.text.toString())
                    put(COL_ZIP,etZip.text.toString())
                    put(COL_DEPARTMENT,etDepartment.text.toString())
                    put(COL_POSITION,etPostion.text.toString())
                    put(COL_TAXID,etTaxID.text.toString())
                }
                /*
                val name = etName.text.toString()
                val lastName = etLastName.text.toString()
                val address = etStreetAddress.text.toString()
                val city = etCity.text.toString()
                val state = etState.text.toString()
                val zip = etZip.text.toString()
                val department = etDepartment.text.toString()
                val position = etPostion.text.toString()
                val taxID = etTaxID.text.toString()
                database.insertPersonIntoDatabase(Employee(name,lastName,address,city,state, zip, position, department, taxID))*/
                contentResolver.insert(CONTENT_URI, newValues)
                finish()

            }




        }


    }
}
