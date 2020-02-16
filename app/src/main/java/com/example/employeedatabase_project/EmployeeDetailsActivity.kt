package com.example.employeedatabase_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_employee_details.*

class EmployeeDetailsActivity : AppCompatActivity() {


    val database = EmployeeDatabaseHelper(this)
    val employee by lazy {intent?.getParcelableExtra<Employee>(KEY_EMPLOYEE)}


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employee_details)

        tvFirstName.text = employee?.firstName
        tvLastName.text = employee?.lastName
        tvAddress.text = employee?.streetAddress
        tvCity.text = employee?.city
        tvState.text = employee?.state
        tvZip.text = employee?.zip
        tvDepartment.text = employee?.department
        tvPosition.text = employee?.position
        tvTaxID.text = employee?.taxID

    }

    fun employeeFunctions(view: View) {

        when(view.id){

            R.id.btnDeleteEmployee ->{

                val taxID = tvTaxID.text.toString()
                database.removePersonFromDatabase(taxID)
                contentResolver.delete(CONTENT_URI,taxID, null)
                finish()
            }
            R.id.btnUpdateEmployee -> {

                val intent = Intent(this,UpdateEmployeeActivity::class.java)

                intent.putExtra(KEY_EMPLOYEE,employee)
                this.startActivity(intent)
                finish()


            }


        }

    }

}
