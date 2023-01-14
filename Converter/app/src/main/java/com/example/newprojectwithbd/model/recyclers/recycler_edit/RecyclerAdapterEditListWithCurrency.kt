package com.example.newprojectwithbd.model.recyclers.recycler_edit

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.view.ContentInfo
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.newprojectwithbd.DB.FeedReaderDbHelper
import com.example.newprojectwithbd.R
import java.util.*

class RecyclerAdapterEditListWithCurrency(

    private val context: Context,
    private val list: LinkedList<String>,

    ) : RecyclerView.Adapter<RecyclerAdapterEditListWithCurrency.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val source : TextView = itemView.findViewById(R.id.source)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.recycler_view_cyrrency_item, parent, false)
        return MyViewHolder(itemView)
    }

    @SuppressLint("ShowToast")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var sharedPreferences = context.getSharedPreferences("Currency", AppCompatActivity.MODE_PRIVATE)
        var sharedPreferencesEditor = sharedPreferences.edit()

        holder.source.text = list[position]

        holder.source.setOnClickListener {
            sharedPreferencesEditor.putString("Currency", holder.source.text.toString()).apply()
        }
    }

    override fun getItemCount() = list.size

}