package com.example.employeedatabase_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log


class SplashActivity : AppCompatActivity() {
        val databaseHelper by lazy { EmployeeDatabaseHelper(this) }
        private var mDelayHandler: Handler? = null
        private val SPLASH_DELAY: Long = 3000

        internal val mRunnable: Runnable = Runnable {
            if (!isFinishing) {

                val intent = Intent(applicationContext, EmployeeFilterActivity::class.java)
                startActivity(intent)
                finish()
            }
        }

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_splash)

            if (databaseHelper.getAllPeopleFromDatabase().isEmpty())
            {

                databaseHelper.insertDepartmentToBase("Design")
                        databaseHelper.insertDepartmentToBase("Development")
                        databaseHelper.insertDepartmentToBase("Finance")
                        databaseHelper.insertDepartmentToBase("HR")
                        databaseHelper.insertDepartmentToBase("Legal")


                        databaseHelper.insertPersonIntoDatabase(
                        Employee("Casey","Heim",
                            "7546 Meadow Lane","Hydeville","NY","11378",
                            "Graphic Designer","Design","108459155"))

                        databaseHelper.insertPersonIntoDatabase(
                        Employee("Misha","Leon",
                            "7358 Redwood Court","Hamburg","NY","11472",
                            "Lawyer","Legal","981776096"))

                        databaseHelper.insertPersonIntoDatabase(
                        Employee("Daniell","Swenson",
                            "457 Pendergast Street","Brunswick","NJ","07563",
                            "UI Designer","Design","412300892"))

                        databaseHelper.insertPersonIntoDatabase(
                        Employee("Marilee","Wakefield",
                            "28 E. Andover Ave","Newark","NJ","07274",
                            "Hiring Manager","HR","666694629"))

                        databaseHelper.insertPersonIntoDatabase(
                        Employee("Alice","Crosely",
                            "66 Shirley Street","South Windsor","CT","06074",
                            "Recruitment Manager","HR","490214730"))

                        databaseHelper.insertPersonIntoDatabase(
                        Employee("Eric","Haslow",
                            "288 East Acacia Drive","Hamburg","NY","13126",
                            "Accountant","Finance","483116811"))

                        databaseHelper.insertPersonIntoDatabase(
                        Employee("Lisa","Walker",
                            "7052 Rockville St","Plainfield","NJ","08012",
                            "Budget Analyst","Finance","825897478"))

                        databaseHelper.insertPersonIntoDatabase(
                        Employee("Rico","Hernandez",
                            "9221 Shadow Brook St","Pittsford","NY","12601",
                            "Android Developer","Development","619158047"))

                        databaseHelper.insertPersonIntoDatabase(
                        Employee("Mei","Tanaka",
                            "350 Hilldale Dr","Meriden","CT","06450",
                            "Sr. Android Developer","Development","563311132"))

            }


            Log.v("TAG",databaseHelper.getAllPeopleFromDatabase().toString())
            Log.v("TAG",databaseHelper.getAllPeopleFromDepartment("Design").toString())


            //Initialize the Handler
            mDelayHandler = Handler()

            //Navigate with delay
            mDelayHandler!!.postDelayed(mRunnable, SPLASH_DELAY)




        }

        public override fun onDestroy() {

            if (mDelayHandler != null) {
                mDelayHandler!!.removeCallbacks(mRunnable)
            }

            super.onDestroy()
        }
    }




