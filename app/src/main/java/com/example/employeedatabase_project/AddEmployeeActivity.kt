package com.example.employeedatabase_project

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
                val name = etName.text.toString()
                val lastName = etLastName.text.toString()
                val address = etStreetAddress.text.toString()
                val city = etCity.text.toString()
                val state = etState.text.toString()
                val zip = etZip.text.toString()
                val department = etDepartment.text.toString()
                val position = etPostion.text.toString()
                val taxID = etTaxID.text.toString()
                database.insertPersonIntoDatabase(Employee(name,lastName,address,city,state, zip, position, department, taxID))
                finish()

            }




        }


    }
}
