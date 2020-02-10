package com.example.employeedatabase_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_employee_details.*

class EmployeeDetailsActivity : AppCompatActivity() {


    val database = EmployeeDatabaseHelper(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employee_details)
        val passedEmployee = intent?.getParcelableExtra<Employee>(KEY_EMPLOYEE)
        tvFirstName.text = passedEmployee?.firstName
        tvLastName.text = passedEmployee?.lastName
        tvAddress.text = passedEmployee?.streetAddress
        tvCity.text = passedEmployee?.city
        tvState.text = passedEmployee?.state
        tvZip.text = passedEmployee?.zip
        tvDepartment.text = passedEmployee?.department
        tvPosition.text = passedEmployee?.position
        tvTaxID.text = passedEmployee?.taxID

    }

    fun employeeFunctions(view: View) {

        when(view.id){

            R.id.btnDeleteEmployee ->{

                val taxID = tvTaxID.toString()
                database.removePersonFromDatabase(taxID)
                finish()
            }
            R.id.btnUpdateEmployee -> {

                val intent = Intent(this,UpdateEmployeeActivity::class.java)
                val employee = intent?.getParcelableExtra<Employee>(KEY_EMPLOYEE)
                intent.putExtra(KEY_EMPLOYEE,employee)
                this.startActivity(intent)


            }


        }

    }

}
