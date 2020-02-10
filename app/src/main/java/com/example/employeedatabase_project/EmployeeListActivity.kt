package com.example.employeedatabase_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_add_employee.*
import kotlinx.android.synthetic.main.activity_employee_list.*

class EmployeeListActivity : AppCompatActivity() {

    lateinit var adapter: EmployeeAdapter
    var employeeList : ArrayList<Employee> = ArrayList<Employee>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employee_list)
        val database = EmployeeDatabaseHelper(this)
        var departmentName = intent.getStringExtra(KEY_EMPLOYEE)
        employeeList = database.getAllPeopleFromDepartment(departmentName)
        adapter = EmployeeAdapter(employeeList)
        initRecylcerView()
    }

    private fun initRecylcerView(){
        val layoutManager = LinearLayoutManager(this)
        val itemDecoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        val gridLayoutManager = GridLayoutManager(this, 3)
        rvNameView.layoutManager = layoutManager
        rvNameView.addItemDecoration(itemDecoration)
        rvNameView.adapter = adapter

    }

    fun onClick(view: View) {


        val intent = Intent(applicationContext, AddEmployeeActivity::class.java)
        startActivity(intent)


    }
}
