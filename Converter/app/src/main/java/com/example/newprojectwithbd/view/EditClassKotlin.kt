package com.example.newprojectwithbd.view

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import android.view.View
import android.view.View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newprojectwithbd.DB.FeedReaderDbHelper
import com.example.newprojectwithbd.R
import com.example.newprojectwithbd.VM.EditClassVmKotlin
import com.example.newprojectwithbd.databinding.ActivityEditBinding
import com.example.newprojectwithbd.model.recyclers.recycler_edit.RecyclerAdapterEditListWithCountryName
import com.example.newprojectwithbd.model.recyclers.recycler_edit.RecyclerAdapterEditListWithCurrency
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class EditClassKotlin : AppCompatActivity() {

    private lateinit var binding: ActivityEditBinding
    private lateinit var editClassVmKotlin: EditClassVmKotlin
    private lateinit var dbHelper: FeedReaderDbHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)
        overridePendingTransition(0, 0)
        ////////////VM
        editClassVmKotlin = ViewModelProvider(this).get(EditClassVmKotlin::class.java)
        ////////recyclerView
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewCurrency.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        ////////////////////////Доступ к базе данных
        dbHelper = FeedReaderDbHelper(this)

        GlobalScope.launch(Dispatchers.Main) {
            editClassVmKotlin.addToRecycler()
            editClassVmKotlin.setCheckList()
            binding.recyclerView.adapter =
                RecyclerAdapterEditListWithCountryName(
                    dbHelper,
                    dbHelper.readIntoDbData(dbHelper)
                )

        }
        GlobalScope.launch(Dispatchers.Main) {
            editClassVmKotlin.addToRecyclerCurrency()
            binding.recyclerViewCurrency.adapter = RecyclerAdapterEditListWithCurrency(
                this@EditClassKotlin,
                editClassVmKotlin.listRecyclerCurrency
            )
        }
        binding.bottomNav.setOnNavigationItemSelectedListener { menuItem: MenuItem ->
            when (menuItem.itemId) {
                R.id.Home -> {
                    val intent = Intent(
                        this@EditClassKotlin,
                        LauncherActivity::class.java
                    )
                    startActivity(intent)
                    finish()
                }
            }
            true
        }
        binding.info.setOnClickListener {
            val toast = Toast.makeText(
                this,
                """
                    Выберите 4 страны,
                    за которыми вам было бы интересно наблюдать,
                    а также выберите источник,
                    по отношению к которому строится курс
                    """.trimIndent(),
                Toast.LENGTH_LONG
            )
            toast.setGravity(Gravity.CENTER, 0, 0)
            toast.show()
        }
    }
    override fun onResume() {
        super.onResume()
        binding.bottomNav.selectedItemId = R.id.Edit
        val decorView = window.decorView
        val uiOptions = SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        decorView.systemUiVisibility = uiOptions
    }

    override fun onDestroy() {
        super.onDestroy()
        dbHelper.close()
    }
}
