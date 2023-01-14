package com.example.newprojectwithbd.VM

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.AndroidViewModel
import com.example.newprojectwithbd.DB.FeedReaderDbHelper
import com.example.newprojectwithbd.R
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import java.util.*
import kotlin.collections.ArrayList

class EditClassVmKotlin(application : Application) : AndroidViewModel(application) {

    private val listRecycler = LinkedList <String>()
    val listRecyclerCurrency = LinkedList <String>()

    @SuppressLint("StaticFieldLeak")
    private val context : Context = getApplication()
    private val dbHelper: FeedReaderDbHelper = FeedReaderDbHelper(context)


    suspend fun addToRecycler() = coroutineScope {
        launch {
            listRecycler.add (context.getString(R.string.name1) + " " + context.getString(R.string.code1))
            listRecycler.add (context.getString(R.string.name2) + " " + context.getString(R.string.code2))
            listRecycler.add (context.getString(R.string.name3) + " " + context.getString(R.string.code3))
            listRecycler.add (context.getString(R.string.name4) + " " + context.getString(R.string.code4))
            listRecycler.add (context.getString(R.string.name5) + " " + context.getString(R.string.code5))
            listRecycler.add (context.getString(R.string.name6) + " " + context.getString(R.string.code6))
            listRecycler.add (context.getString(R.string.name7) + " " + context.getString(R.string.code7))
            listRecycler.add (context.getString(R.string.name8) + " " + context.getString(R.string.code8))
            listRecycler.add (context.getString(R.string.name9) + " " + context.getString(R.string.code9))
            listRecycler.add (context.getString(R.string.name10) + " " + context.getString(R.string.code10))
            listRecycler.add (context.getString(R.string.name11) + " " + context.getString(R.string.code11))
            listRecycler.add (context.getString(R.string.name12) + " " + context.getString(R.string.code12))
            listRecycler.add (context.getString(R.string.name13) + " " + context.getString(R.string.code13))
            listRecycler.add (context.getString(R.string.name14) + " " + context.getString(R.string.code14))
            listRecycler.add (context.getString(R.string.name15) + " " + context.getString(R.string.code15))
            listRecycler.add (context.getString(R.string.name16) + " " + context.getString(R.string.code16))
            listRecycler.add (context.getString(R.string.name17) + " " + context.getString(R.string.code17))
            listRecycler.add (context.getString(R.string.name18) + " " + context.getString(R.string.code18))
            listRecycler.add (context.getString(R.string.name19) + " " + context.getString(R.string.code19))
            listRecycler.add (context.getString(R.string.name20) + " " + context.getString(R.string.code20))
            listRecycler.add (context.getString(R.string.name21) + " " + context.getString(R.string.code21))
            listRecycler.add (context.getString(R.string.name22) + " " + context.getString(R.string.code22))
            listRecycler.add (context.getString(R.string.name23) + " " + context.getString(R.string.code23))
            listRecycler.add (context.getString(R.string.name24) + " " + context.getString(R.string.code24))
            listRecycler.add (context.getString(R.string.name25) + " " + context.getString(R.string.code25))
            listRecycler.add (context.getString(R.string.name26) + " " + context.getString(R.string.code26))
            listRecycler.add (context.getString(R.string.name27) + " " + context.getString(R.string.code27))
            listRecycler.add (context.getString(R.string.name28) + " " + context.getString(R.string.code28))
            listRecycler.add (context.getString(R.string.name29) + " " + context.getString(R.string.code29))
            listRecycler.add (context.getString(R.string.name30) + " " + context.getString(R.string.code30))
            listRecycler.add (context.getString(R.string.name31) + " " + context.getString(R.string.code31))
            listRecycler.add (context.getString(R.string.name32) + " " + context.getString(R.string.code32))
            listRecycler.add (context.getString(R.string.name33) + " " + context.getString(R.string.code33))
            listRecycler.add (context.getString(R.string.name34) + " " + context.getString(R.string.code34))
            listRecycler.add (context.getString(R.string.name35) + " " + context.getString(R.string.code35))
            listRecycler.add (context.getString(R.string.name36) + " " + context.getString(R.string.code36))
            listRecycler.add (context.getString(R.string.name37) + " " + context.getString(R.string.code37))
            listRecycler.add (context.getString(R.string.name38) + " " + context.getString(R.string.code38))
            listRecycler.add (context.getString(R.string.name39) + " " + context.getString(R.string.code39))
            listRecycler.add (context.getString(R.string.name40) + " " + context.getString(R.string.code40))
            listRecycler.add (context.getString(R.string.name41) + " " + context.getString(R.string.code41))
            listRecycler.add (context.getString(R.string.name42) + " " + context.getString(R.string.code42))
            listRecycler.add (context.getString(R.string.name43) + " " + context.getString(R.string.code43))
            listRecycler.add (context.getString(R.string.name44) + " " + context.getString(R.string.code44))
            listRecycler.add (context.getString(R.string.name45) + " " + context.getString(R.string.code45))
            listRecycler.add (context.getString(R.string.name46) + " " + context.getString(R.string.code46))
            listRecycler.add (context.getString(R.string.name47) + " " + context.getString(R.string.code47))
            listRecycler.add (context.getString(R.string.name48) + " " + context.getString(R.string.code48))
            listRecycler.add (context.getString(R.string.name49) + " " + context.getString(R.string.code49))
            listRecycler.add (context.getString(R.string.name50) + " " + context.getString(R.string.code50))
            listRecycler.add (context.getString(R.string.name51) + " " + context.getString(R.string.code51))
            listRecycler.add (context.getString(R.string.name52) + " " + context.getString(R.string.code52))
            listRecycler.add (context.getString(R.string.name53) + " " + context.getString(R.string.code53))
            listRecycler.add (context.getString(R.string.name54) + " " + context.getString(R.string.code54))
            listRecycler.add (context.getString(R.string.name55) + " " + context.getString(R.string.code55))
            listRecycler.add (context.getString(R.string.name56) + " " + context.getString(R.string.code56))
            listRecycler.add (context.getString(R.string.name57) + " " + context.getString(R.string.code57))
            listRecycler.add (context.getString(R.string.name58) + " " + context.getString(R.string.code58))
            listRecycler.add (context.getString(R.string.name59) + " " + context.getString(R.string.code59))
            listRecycler.add (context.getString(R.string.name60) + " " + context.getString(R.string.code60))
            listRecycler.add (context.getString(R.string.name61) + " " + context.getString(R.string.code61))
            listRecycler.add (context.getString(R.string.name62) + " " + context.getString(R.string.code62))
            listRecycler.add (context.getString(R.string.name63) + " " + context.getString(R.string.code63))
        }
    }

    suspend fun setCheckList() = coroutineScope {
        launch {
            if (dbHelper.readIntoDbData(dbHelper).size == 0) {
                dbHelper.writableDatabase
                var i = 0
                while (true) {
                    val array = listRecycler[i].split(" ")
                    dbHelper.writeToDb("false", array[0], array[1], "0", dbHelper)
                    i++
                    if (dbHelper.readIntoDbData(dbHelper).size == listRecycler.size) {
                        break
                    }
                }
                dbHelper.close()
            }
        }
    }

    suspend fun addToRecyclerCurrency() = coroutineScope {
        launch {
            listRecyclerCurrency.add(context.getString(R.string.code1))
            listRecyclerCurrency.add(context.getString(R.string.code2))
            listRecyclerCurrency.add(context.getString(R.string.code3))
            listRecyclerCurrency.add(context.getString(R.string.code4))
            listRecyclerCurrency.add(context.getString(R.string.code5))
            listRecyclerCurrency.add(context.getString(R.string.code6))
            listRecyclerCurrency.add(context.getString(R.string.code7))
            listRecyclerCurrency.add(context.getString(R.string.code8))
            listRecyclerCurrency.add(context.getString(R.string.code9))
            listRecyclerCurrency.add(context.getString(R.string.code10))
            listRecyclerCurrency.add(context.getString(R.string.code11))
            listRecyclerCurrency.add(context.getString(R.string.code12))
            listRecyclerCurrency.add(context.getString(R.string.code13))
            listRecyclerCurrency.add(context.getString(R.string.code14))
            listRecyclerCurrency.add(context.getString(R.string.code15))
            listRecyclerCurrency.add(context.getString(R.string.code16))
            listRecyclerCurrency.add(context.getString(R.string.code17))
            listRecyclerCurrency.add(context.getString(R.string.code18))
            listRecyclerCurrency.add(context.getString(R.string.code19))
            listRecyclerCurrency.add(context.getString(R.string.code20))
            listRecyclerCurrency.add(context.getString(R.string.code21))
            listRecyclerCurrency.add(context.getString(R.string.code22))
            listRecyclerCurrency.add(context.getString(R.string.code23))
            listRecyclerCurrency.add(context.getString(R.string.code24))
            listRecyclerCurrency.add(context.getString(R.string.code25))
            listRecyclerCurrency.add(context.getString(R.string.code26))
            listRecyclerCurrency.add(context.getString(R.string.code27))
            listRecyclerCurrency.add(context.getString(R.string.code28))
            listRecyclerCurrency.add(context.getString(R.string.code29))
            listRecyclerCurrency.add(context.getString(R.string.code30))
            listRecyclerCurrency.add(context.getString(R.string.code31))
            listRecyclerCurrency.add(context.getString(R.string.code32))
            listRecyclerCurrency.add(context.getString(R.string.code33))
            listRecyclerCurrency.add(context.getString(R.string.code34))
            listRecyclerCurrency.add(context.getString(R.string.code35))
            listRecyclerCurrency.add(context.getString(R.string.code36))
            listRecyclerCurrency.add(context.getString(R.string.code37))
            listRecyclerCurrency.add(context.getString(R.string.code38))
            listRecyclerCurrency.add(context.getString(R.string.code39))
            listRecyclerCurrency.add(context.getString(R.string.code40))
            listRecyclerCurrency.add(context.getString(R.string.code41))
            listRecyclerCurrency.add(context.getString(R.string.code42))
            listRecyclerCurrency.add(context.getString(R.string.code43))
            listRecyclerCurrency.add(context.getString(R.string.code44))
            listRecyclerCurrency.add(context.getString(R.string.code45))
            listRecyclerCurrency.add(context.getString(R.string.code46))
            listRecyclerCurrency.add(context.getString(R.string.code47))
            listRecyclerCurrency.add(context.getString(R.string.code48))
            listRecyclerCurrency.add(context.getString(R.string.code49))
            listRecyclerCurrency.add(context.getString(R.string.code50))
            listRecyclerCurrency.add(context.getString(R.string.code51))
            listRecyclerCurrency.add(context.getString(R.string.code52))
            listRecyclerCurrency.add(context.getString(R.string.code53))
            listRecyclerCurrency.add(context.getString(R.string.code54))
            listRecyclerCurrency.add(context.getString(R.string.code55))
            listRecyclerCurrency.add(context.getString(R.string.code56))
            listRecyclerCurrency.add(context.getString(R.string.code57))
            listRecyclerCurrency.add(context.getString(R.string.code58))
            listRecyclerCurrency.add(context.getString(R.string.code59))
            listRecyclerCurrency.add(context.getString(R.string.code60))
            listRecyclerCurrency.add(context.getString(R.string.code61))
            listRecyclerCurrency.add(context.getString(R.string.code62))
            listRecyclerCurrency.add(context.getString(R.string.code63))
        }
    }
}
