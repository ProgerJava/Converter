package com.example.newprojectwithbd.model.recyclers.recycler_edit

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.newprojectwithbd.DB.FeedReaderDbHelper
import com.example.newprojectwithbd.R

class RecyclerAdapterEditListWithCountryName(

    private val dbHelper: FeedReaderDbHelper,
    private val readIntoDbData: java.util.ArrayList<java.util.ArrayList<String>>,

    ) : RecyclerView.Adapter<RecyclerAdapterEditListWithCountryName.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val code : TextView = itemView.findViewById(R.id.code)
        val name : TextView = itemView.findViewById(R.id.name)
        val checkBox : CheckBox = itemView.findViewById(R.id.checkBox)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.recycler_view_edit_item, parent, false)
        return MyViewHolder(itemView)
    }

    @SuppressLint("ShowToast")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        dbHelper.readableDatabase
        println(readIntoDbData)
        val list = readIntoDbData[position]
        holder.checkBox.isChecked = list[0].toBoolean()
        holder.name.text = list[1]
        holder.code.text = list[3]

        holder.checkBox.setOnClickListener {
            dbHelper.updateState((holder.checkBox.isChecked).toString(),
            holder.name.text.toString(),
            dbHelper)
        }
        dbHelper.close()
    }

    override fun getItemCount() = dbHelper.readIntoDbData(dbHelper).size

}