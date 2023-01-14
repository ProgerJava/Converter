package com.example.newprojectwithbd.model.recyclers.recycler_launcher

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.newprojectwithbd.DB.FeedReaderDbHelper
import com.example.newprojectwithbd.R
import com.example.newprojectwithbd.model.ConverterRequest
import com.example.newprojectwithbd.view.LauncherActivity
import java.util.ArrayList

class RecyclerAdapterLauncher(

    private val dbHelper: FeedReaderDbHelper,
    private val readIntoDbDataStateTrue: ArrayList<ArrayList<String>>,
    private val launcherActivity: LauncherActivity,

    ) : RecyclerView.Adapter<RecyclerAdapterLauncher.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val country : TextView = itemView.findViewById(R.id.country)
        val currency : TextView = itemView.findViewById(R.id.currency)
        val cost : TextView = itemView.findViewById(R.id.cost)
        val source : TextView = itemView.findViewById(R.id.source)
        val flag : ImageView = itemView.findViewById(R.id.flag)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.recycler_view_launcher_item, parent, false)
        return MyViewHolder(itemView)
    }

    @SuppressLint("ShowToast", "NotifyDataSetChanged", "UseCompatLoadingForDrawables")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        dbHelper.readableDatabase
        val converterRequest = ConverterRequest ()
        var sharedPreferences = launcherActivity.applicationContext.getSharedPreferences("Currency", AppCompatActivity.MODE_PRIVATE)

        val list = readIntoDbDataStateTrue[position]
        holder.country.text = list[0]
        holder.cost.text = list[1]
        holder.currency.text = list[2]
        holder.source.text = sharedPreferences.getString("Currency", "")
        holder.flag.setImageDrawable(
            launcherActivity
                .getDrawable(converterRequest.setCountryFlag(holder.country.text.toString()))
        )
        dbHelper.close()
    }

    override fun getItemCount() = dbHelper.readIntoDbDataStateTrue(dbHelper).size

}