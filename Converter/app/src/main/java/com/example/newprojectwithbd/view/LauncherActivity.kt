package com.example.newprojectwithbd.view

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newprojectwithbd.DB.FeedReaderDbHelper
import com.example.newprojectwithbd.R
import com.example.newprojectwithbd.databinding.ActivityLauncherBinding
import com.example.newprojectwithbd.model.LauncherModel
import com.example.newprojectwithbd.model.recyclers.recycler_launcher.RecyclerAdapterLauncher

class LauncherActivity : AppCompatActivity () {

    private lateinit var binding: ActivityLauncherBinding
    private lateinit var dbHelper: FeedReaderDbHelper
    private lateinit var sharedPreferences : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        overridePendingTransition(0, 0)
        binding = ActivityLauncherBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPreferences = getSharedPreferences("Currency", MODE_PRIVATE)
        ////////////////////////Доступ к базе данных
        dbHelper = FeedReaderDbHelper(this)
        ////////recyclerView
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = RecyclerAdapterLauncher (dbHelper, dbHelper.readIntoDbDataStateTrue(dbHelper), this)

        binding.bottomNav.setOnNavigationItemSelectedListener { menuItem: MenuItem ->
            when (menuItem.itemId) {
                R.id.Edit -> {
                    val intent = Intent(
                        this@LauncherActivity,
                        EditClassKotlin::class.java
                    )
                    startActivity(intent)
                    finish()
                }
            }
            true
        }
        binding.update.setOnClickListener {
            val listWithCountry = dbHelper.readIntoDbDataStateTrue(dbHelper)
            for (i in 0 until listWithCountry.size) {
                if (listWithCountry[i][2] == sharedPreferences.getString("Currency", "")) {
                    Toast.makeText(this, "Валюта и источник не должны быть равны", Toast.LENGTH_LONG).show()
                   break;
                }
                if (i == listWithCountry.size-1) {
                    sendRequest()
                }
            }
        }

    }
    @SuppressLint("NotifyDataSetChanged")
    private fun sendRequest () {
        dbHelper.readableDatabase
        val launcherModel = LauncherModel()
        val listWithCountry = dbHelper.readIntoDbDataStateTrue(dbHelper)
        var request = ""

        for (i in 0 until listWithCountry.size) {
            request += if (i != listWithCountry.size-1) {
                listWithCountry[i][2] + "%2C%20"
            }else {
                listWithCountry[i][2]
            }
        }
        launcherModel.source = sharedPreferences.getString("Currency", "")
        launcherModel.currencies = request
        launcherModel.start()

        while (launcherModel.list.size == 0) {
            try {
                Thread.sleep(1000)
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
        }
        val listWithCost = launcherModel.list
        for (i in 0 until listWithCountry.size) {
            if (i == 0) {
                dbHelper.updateCost(listWithCost[i].substring(18, listWithCost[0].length-1), listWithCountry[i][0], dbHelper)
            }else {
                dbHelper.updateCost(listWithCost[i].substring(9, listWithCost[i].length-1), listWithCountry[i][0], dbHelper)
            }
        }
        if (launcherModel.isAlive) {
            launcherModel.interrupt()
        }
        binding.recyclerView.adapter = RecyclerAdapterLauncher (dbHelper, dbHelper.readIntoDbDataStateTrue(dbHelper), this)
    }

    override fun onResume() {
        super.onResume()
        binding.bottomNav.selectedItemId = R.id.Home
        val decorView = window.decorView
        val uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        decorView.systemUiVisibility = uiOptions
    }

    override fun onDestroy() {
        super.onDestroy()
        dbHelper.close()
    }
}