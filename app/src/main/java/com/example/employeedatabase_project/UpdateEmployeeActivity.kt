package com.example.employeedatabase_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_add_employee.*
import kotlinx.android.synthetic.main.activity_add_employee.etCity
import kotlinx.android.synthetic.main.activity_add_employee.etDepartment
import kotlinx.android.synthetic.main.activity_add_employee.etLastName
import kotlinx.android.synthetic.main.activity_add_employee.etName
import kotlinx.android.synthetic.main.activity_add_employee.etPostion
import kotlinx.android.synthetic.main.activity_add_employee.etState
import kotlinx.android.synthetic.main.activity_add_employee.etStreetAddress
import kotlinx.android.synthetic.main.activity_add_employee.etTaxID
import kotlinx.android.synthetic.main.activity_add_employee.etZip
import kotlinx.android.synthetic.main.activity_update_employee.*

class UpdateEmployeeActivity : AppCompatActivity() {

    val database = EmployeeDatabaseHelper(this)
    val passedEmployee by lazy {intent?.getParcelableExtra<Employee>(KEY_EMPLOYEE)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_employee)
        Log.d("TAG",passedEmployee?.firstName.toString())

        etName.setText(passedEmployee?.firstName)
        etLastName.setText(passedEmployee?.lastName)
        etStreetAddress.setText(passedEmployee?.streetAddress)
        etCity.setText(passedEmployee?.city)
        etState.setText(passedEmployee?.state)
        etZip.setText(passedEmployee?.zip)
        etDepartment.setText(passedEmployee?.department)
        etPostion.setText(passedEmployee?.position)
        etTaxID.setText(passedEmployee?.taxID)
    }

    fun onClick(view: View) {

        when (view.id) {

            R.id.btnUpdateEmployee -> {
                val name = etName.text.toString()
                val lastName = etLastName.text.toString()
                val address = etStreetAddress.text.toString()
                val city = etCity.text.toString()
                val state = etState.text.toString()
                val zip = etZip.text.toString()
                val department = etDepartment.text.toString()
                val position = etPostion.text.toString()
                val taxID = etTaxID.text.toString()
                database.updatePersonInDatabase(Employee(name, lastName, address, city, state, zip, position, department, taxID))
                finish()

            }
        }
    }
}
