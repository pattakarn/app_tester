package com.example.apptesting.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.apptesting.R
import com.example.apptesting.api.MainVM

class ItemActivity : AppCompatActivity() {

    private lateinit var mainVM: MainVM
    private lateinit var tv: TextView
    private lateinit var btn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item)

        tv = findViewById(R.id.tv)
        btn = findViewById(R.id.btn)

        var bundle = intent.extras
        var token: String = bundle!!.getString("token")!!
        var id: String = bundle!!.getString("id")!!

        mainVM = ViewModelProvider(this).get(MainVM::class.java)
        mainVM.getCustomerDetail(token, id).observe(this, Observer {
            Log.d("item", it.data.sex)
            var str = "customerGrade : " + it.data.customerGrade + "\n" +
                    "id : " + it.data.id + "\n" +
                    "isCustomerPremium : " + it.data.isCustomerPremium + "\n" +
                    "name : " + it.data.name + "\n" +
                    "sex : " + it.data.sex
            tv.text = str
        })

        btn.setOnClickListener {
            finish()
        }
    }
}