package com.example.apptesting.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apptesting.R
import com.example.apptesting.adapter.CustomerAdapter
import com.example.apptesting.model.LoginResp

class DashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val rv = findViewById<RecyclerView>(R.id.rv)

        var bundle = intent.extras
        var item: LoginResp = bundle!!.getParcelable("item")!!

        val adapter = CustomerAdapter(item.customers, item!!.token, supportFragmentManager)
        rv.adapter = adapter
        rv.layoutManager = LinearLayoutManager(this)
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        return super.onCreateOptionsMenu(menu)
        getMenuInflater().inflate(R.menu.menu_dashboard, menu);
        return true;
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.logout -> {
                val dialogBuilder = AlertDialog.Builder(this)
                dialogBuilder.setMessage("Do you want to logout ?")
                        .setCancelable(false)
                        .setPositiveButton("Yes") { _, _ ->
                            finish()
                        }
                        .setNegativeButton("No") { dialog, _ ->
                            dialog.cancel()
                        }
                val alert = dialogBuilder.create()
                alert.setTitle("AlertDialogExample")
                alert.show()
            }
        }
        return super.onOptionsItemSelected(item)
    }

}