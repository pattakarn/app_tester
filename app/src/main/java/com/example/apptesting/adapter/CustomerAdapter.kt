package com.example.apptesting.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apptesting.activity.ItemActivity
import com.example.apptesting.R
import com.example.apptesting.model.Customers
import java.util.ArrayList

class CustomerAdapter() :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var items = ArrayList<Customers>()
    var token: String? = null
    lateinit var inflater: LayoutInflater
    lateinit var fm: FragmentManager

    constructor(items: ArrayList<Customers>, token: String, fm: FragmentManager) : this() {
        this.items = items
        this.token = token
        this.fm = fm
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        inflater = LayoutInflater.from(parent.getContext())
//        arrList = items
        var itemView = inflater.inflate(R.layout.card_item, parent, false)
        return ViewHolderShow(itemView)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val vh = holder as ViewHolderShow
        configureViewHolder(vh, position)
    }

    private fun configureViewHolder(vh1: ViewHolderShow, position: Int) {
//        val temp = items!!.get(position) as Customers
        vh1.tv.text = items!!.get(position).name
        vh1.cv.setOnClickListener {
//            var id = items!!.get(position).id
//            fm.beginTransaction().replace(R.id.container, ItemFragment.newInstance(id, token!!))
//                .commitNow()
            val intent = Intent(inflater.context, ItemActivity::class.java).apply {
                putExtra("token", token)
                putExtra("id", items!!.get(position).id)
            }
            inflater.context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return items!!.size
    }
}

class ViewHolderShow(view: View) : RecyclerView.ViewHolder(view) {
    //
    var cv = view.findViewById<CardView>(R.id.cv)
    var tv = view.findViewById<TextView>(R.id.tv)

}