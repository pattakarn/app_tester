package com.example.apptesting.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.apptesting.R
import com.example.apptesting.api.MainVM
import com.example.apptesting.model.*

class MainActivity : AppCompatActivity() {

    private lateinit var mainVM: MainVM

    private lateinit var username: EditText
    private lateinit var password: EditText
    private lateinit var login: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainVM = ViewModelProvider(this).get(MainVM::class.java)
        initInstances()

        login.setOnClickListener{ view ->
            mainVM.login(username.text.toString(), password.text.toString()).observe(this, Observer {
//                Log.d("response", "====== " + it.customers.get(0).name)
                val intent = Intent(this@MainActivity, DashboardActivity::class.java).apply {
                    putExtra("item", it)
                }
                startActivity(intent)

            })
        }
    }


    override fun onResume() {
        super.onResume()
        username.setText("")
        password.setText("")
    }

    fun initInstances() {
        username = findViewById(R.id.username)
        password = findViewById(R.id.password)
        login = findViewById(R.id.login)
    }
}