package com.example.employeedatabase_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_employee_filter.*

class EmployeeFilterActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employee_filter)
        val database = EmployeeDatabaseHelper(this)
        val departmentArr = database.getAllDepertmentFromDatabase()
        val spinner: Spinner = findViewById(R.id.spDepartmentDropdown)
        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, departmentArr)

        spinner.adapter = arrayAdapter
        spinner.onItemSelectedListener = this



    }


    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        Log.d("TAG",spDepartmentDropdown.selectedItem.toString())
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {


    }

    fun onClick(view: View) {

        when(view.id) {

            R.id.btnSearchDeparment ->{
                val intent = Intent(this,EmployeeListActivity::class.java)
                intent.putExtra(KEY_EMPLOYEE,spDepartmentDropdown.selectedItem.toString())
                startActivity(intent)

            }


        }


    }


}
