package com.example.newprojectwithbd.view;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;


import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.newprojectwithbd.DB.FeedReaderContract;
import com.example.newprojectwithbd.DB.FeedReaderDbHelper;
import com.example.newprojectwithbd.DB.FeedReaderDbHelper_2;
import com.example.newprojectwithbd.R;
import com.example.newprojectwithbd.VM.EditClassVM;
import com.example.newprojectwithbd.VM.LauncherVM;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class EditClass extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView = null;
    private EditClassVM editClassVM;
    private SharedPreferences sharedPreferencesCounter;
    private SharedPreferences.Editor sharedPreferences_editor_counter;
    private SharedPreferences sharedPreferencesCurrency;
    private SharedPreferences.Editor sharedPreferences_editor_currency;
    private CheckBox checkBox1, checkBox2, checkBox3, checkBox4, checkBox5, checkBox6, checkBox7, checkBox8, checkBox9, checkBox10;
    private CheckBox checkBox11, checkBox12, checkBox13, checkBox14, checkBox15, checkBox16, checkBox17, checkBox18, checkBox19, checkBox20;
    private CheckBox checkBox21, checkBox22, checkBox23, checkBox24, checkBox25, checkBox26, checkBox27, checkBox28, checkBox29, checkBox30;
    private CheckBox checkBox31, checkBox32, checkBox33, checkBox34, checkBox35, checkBox36, checkBox37, checkBox38, checkBox39, checkBox40;
    private CheckBox checkBox41, checkBox42, checkBox43, checkBox44, checkBox45, checkBox46, checkBox47, checkBox48, checkBox49, checkBox50;
    private CheckBox checkBox51, checkBox52, checkBox53, checkBox54, checkBox55, checkBox56, checkBox57, checkBox58, checkBox59, checkBox60, checkBox61, checkBox62, checkBox63;
    private TextView source1, source2, source3, source4, source5, source6, source7, source8, source9, source10, source11, source12, source13, source14, source15;
    private TextView source16, source17, source18, source19, source20, source21, source22, source23, source24, source25, source26, source27, source28, source29, source30;
    private TextView source31, source32, source33, source34, source35, source36, source37, source38, source39, source40, source41, source42, source43, source44, source45;
    private TextView source46, source47, source48, source49, source50, source51, source52;
    private FeedReaderDbHelper dbHelper;
    private FeedReaderDbHelper_2 dbHelper_2;
    private ImageView info;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        overridePendingTransition(0, 0);
        ////////////////////////Доступ к базе данных
        dbHelper = new FeedReaderDbHelper(this);
        dbHelper_2 = new FeedReaderDbHelper_2(this);
        //////////////////////Навигационная панель
        bottomNavigationView = findViewById(R.id.bottom_nav);
        /////////////////Счетчик работающих боксов
        sharedPreferencesCounter = getSharedPreferences("Counter", Context.MODE_PRIVATE);
        sharedPreferencesCurrency = getSharedPreferences("Currency", Context.MODE_PRIVATE);
        sharedPreferences_editor_counter = sharedPreferencesCounter.edit();
        sharedPreferences_editor_currency = sharedPreferencesCurrency.edit();
        ///////////////////Всплывающее окно с информацией об активити
        info = findViewById(R.id.info);
        ////////////VM
        editClassVM = new ViewModelProvider(this).get(EditClassVM.class);

        checkBox1 = findViewById(R.id.checkBox1);source1 = findViewById(R.id.source1);
        checkBox2 = findViewById(R.id.checkBox2);source2 = findViewById(R.id.source2);
        checkBox3 = findViewById(R.id.checkBox3);source3 = findViewById(R.id.source3);
        checkBox4 = findViewById(R.id.checkBox4);source4 = findViewById(R.id.source4);
        checkBox5 = findViewById(R.id.checkBox5);source5 = findViewById(R.id.source5);
        checkBox6 = findViewById(R.id.checkBox6);source6 = findViewById(R.id.source6);
        checkBox7 = findViewById(R.id.checkBox7);source7 = findViewById(R.id.source7);
        checkBox8 = findViewById(R.id.checkBox8);source8 = findViewById(R.id.source8);
        checkBox9 = findViewById(R.id.checkBox9);source9 = findViewById(R.id.source9);
        checkBox10 = findViewById(R.id.checkBox10);source10 = findViewById(R.id.source10);
        checkBox11 = findViewById(R.id.checkBox11);source11 = findViewById(R.id.source11);
        checkBox12 = findViewById(R.id.checkBox12);source12 = findViewById(R.id.source12);
        checkBox13 = findViewById(R.id.checkBox13);source13 = findViewById(R.id.source13);
        checkBox14 = findViewById(R.id.checkBox14);source14 = findViewById(R.id.source14);
        checkBox15 = findViewById(R.id.checkBox15);source15 = findViewById(R.id.source15);
        checkBox16 = findViewById(R.id.checkBox16);source16 = findViewById(R.id.source16);
        checkBox17 = findViewById(R.id.checkBox17);source17 = findViewById(R.id.source17);
        checkBox18 = findViewById(R.id.checkBox18);source18 = findViewById(R.id.source18);
        checkBox19 = findViewById(R.id.checkBox19);source19 = findViewById(R.id.source19);
        checkBox20 = findViewById(R.id.checkBox20);source20 = findViewById(R.id.source20);
        checkBox21 = findViewById(R.id.checkBox21);source21 = findViewById(R.id.source21);
        checkBox22 = findViewById(R.id.checkBox22);source22 = findViewById(R.id.source22);
        checkBox23 = findViewById(R.id.checkBox23);source23 = findViewById(R.id.source23);
        checkBox24 = findViewById(R.id.checkBox24);source24 = findViewById(R.id.source24);
        checkBox25 = findViewById(R.id.checkBox25);source25 = findViewById(R.id.source25);
        checkBox26 = findViewById(R.id.checkBox26);source26 = findViewById(R.id.source26);
        checkBox27 = findViewById(R.id.checkBox27);source27 = findViewById(R.id.source27);
        checkBox28 = findViewById(R.id.checkBox28);source28 = findViewById(R.id.source28);
        checkBox29 = findViewById(R.id.checkBox29);source29 = findViewById(R.id.source29);
        checkBox30 = findViewById(R.id.checkBox30);source30 = findViewById(R.id.source30);
        checkBox31 = findViewById(R.id.checkBox31);source31 = findViewById(R.id.source31);
        checkBox32 = findViewById(R.id.checkBox32);source32 = findViewById(R.id.source32);
        checkBox33 = findViewById(R.id.checkBox33);source33 = findViewById(R.id.source33);
        checkBox34 = findViewById(R.id.checkBox34);source34 = findViewById(R.id.source34);
        checkBox35 = findViewById(R.id.checkBox35);source35 = findViewById(R.id.source35);
        checkBox36 = findViewById(R.id.checkBox36);source36 = findViewById(R.id.source36);
        checkBox37 = findViewById(R.id.checkBox37);source37 = findViewById(R.id.source37);
        checkBox38 = findViewById(R.id.checkBox38);source38 = findViewById(R.id.source38);
        checkBox39 = findViewById(R.id.checkBox39);source39 = findViewById(R.id.source39);
        checkBox40 = findViewById(R.id.checkBox40);source40 = findViewById(R.id.source40);
        checkBox41 = findViewById(R.id.checkBox41);source41 = findViewById(R.id.source41);
        checkBox42 = findViewById(R.id.checkBox42);source42 = findViewById(R.id.source42);
        checkBox43 = findViewById(R.id.checkBox43);source43 = findViewById(R.id.source43);
        checkBox44 = findViewById(R.id.checkBox44);source44 = findViewById(R.id.source44);
        checkBox45 = findViewById(R.id.checkBox45);source45 = findViewById(R.id.source45);
        checkBox46 = findViewById(R.id.checkBox46);source46 = findViewById(R.id.source46);
        checkBox47 = findViewById(R.id.checkBox47);source47 = findViewById(R.id.source47);
        checkBox48 = findViewById(R.id.checkBox48);source48 = findViewById(R.id.source48);
        checkBox49 = findViewById(R.id.checkBox49);source49 = findViewById(R.id.source49);
        checkBox50 = findViewById(R.id.checkBox50);source50 = findViewById(R.id.source50);
        checkBox51 = findViewById(R.id.checkBox51);source51 = findViewById(R.id.source51);
        checkBox52 = findViewById(R.id.checkBox52);source52 = findViewById(R.id.source52);
        checkBox53 = findViewById(R.id.checkBox53);checkBox61 = findViewById(R.id.checkBox61);
        checkBox54 = findViewById(R.id.checkBox54);checkBox62 = findViewById(R.id.checkBox62);
        checkBox55 = findViewById(R.id.checkBox55);checkBox63 = findViewById(R.id.checkBox63);
        checkBox56 = findViewById(R.id.checkBox56);
        checkBox57 = findViewById(R.id.checkBox57);
        checkBox58 = findViewById(R.id.checkBox58);
        checkBox59 = findViewById(R.id.checkBox59);
        checkBox60 = findViewById(R.id.checkBox60);


        bottomNavigationView.setOnNavigationItemSelectedListener(menuItem -> {
            switch (menuItem.getItemId()) {
                case R.id.Home: {
                    Intent intent = new Intent(EditClass.this, LauncherActivity.class);
                    startActivity(intent);
                    break;
                }
            }
            return true;
        });
        info.setOnClickListener(v -> {
            Toast toast = Toast.makeText(this, "Выберите 4 страны,\nза которыми вам было бы интересно наблюдать,\nа также " +
                    "выберите источник,\nпо отношению к которому строится курс", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();

        });

        checkBox1.setOnClickListener(v -> {checkForCheckBox(checkBox1, getString(R.string.name1));});
        checkBox2.setOnClickListener(v -> {checkForCheckBox(checkBox2, getString(R.string.name2));});
        checkBox3.setOnClickListener(v -> {checkForCheckBox(checkBox3, getString(R.string.name3));});
        checkBox4.setOnClickListener(v -> {checkForCheckBox(checkBox4, getString(R.string.name4));});
        checkBox5.setOnClickListener(v -> {checkForCheckBox(checkBox5, getString(R.string.name5));});
        checkBox6.setOnClickListener(v -> {checkForCheckBox(checkBox6, getString(R.string.name6));});
        checkBox7.setOnClickListener(v -> {checkForCheckBox(checkBox7, getString(R.string.name7));});
        checkBox8.setOnClickListener(v -> {checkForCheckBox(checkBox8, getString(R.string.name8));});
        checkBox9.setOnClickListener(v -> {checkForCheckBox(checkBox9, getString(R.string.name9));});
        checkBox10.setOnClickListener(v -> {checkForCheckBox(checkBox10, getString(R.string.name10));});
        checkBox11.setOnClickListener(v -> {checkForCheckBox(checkBox11, getString(R.string.name11));});
        checkBox12.setOnClickListener(v -> {checkForCheckBox(checkBox12, getString(R.string.name12));});
        checkBox13.setOnClickListener(v -> {checkForCheckBox(checkBox13, getString(R.string.name13));});
        checkBox14.setOnClickListener(v -> {checkForCheckBox(checkBox14, getString(R.string.name14));});
        checkBox15.setOnClickListener(v -> {checkForCheckBox(checkBox15, getString(R.string.name15));});
        checkBox16.setOnClickListener(v -> {checkForCheckBox(checkBox16, getString(R.string.name16));});
        checkBox17.setOnClickListener(v -> {checkForCheckBox(checkBox17, getString(R.string.name17));});
        checkBox18.setOnClickListener(v -> {checkForCheckBox(checkBox18, getString(R.string.name18));});
        checkBox19.setOnClickListener(v -> {checkForCheckBox(checkBox19, getString(R.string.name19));});
        checkBox20.setOnClickListener(v -> {checkForCheckBox(checkBox20, getString(R.string.name20));});
        checkBox21.setOnClickListener(v -> {checkForCheckBox(checkBox21, getString(R.string.name21));});
        checkBox22.setOnClickListener(v -> {checkForCheckBox(checkBox22, getString(R.string.name22));});
        checkBox23.setOnClickListener(v -> {checkForCheckBox(checkBox23, getString(R.string.name23));});
        checkBox24.setOnClickListener(v -> {checkForCheckBox(checkBox24, getString(R.string.name24));});
        checkBox25.setOnClickListener(v -> {checkForCheckBox(checkBox25, getString(R.string.name25));});
        checkBox26.setOnClickListener(v -> {checkForCheckBox(checkBox26, getString(R.string.name26));});
        checkBox27.setOnClickListener(v -> {checkForCheckBox(checkBox27, getString(R.string.name27));});
        checkBox28.setOnClickListener(v -> {checkForCheckBox(checkBox28, getString(R.string.name28));});
        checkBox29.setOnClickListener(v -> {checkForCheckBox(checkBox29, getString(R.string.name29));});
        checkBox30.setOnClickListener(v -> {checkForCheckBox(checkBox30, getString(R.string.name30));});
        checkBox31.setOnClickListener(v -> {checkForCheckBox(checkBox31, getString(R.string.name31));});
        checkBox32.setOnClickListener(v -> {checkForCheckBox(checkBox32, getString(R.string.name32));});
        checkBox33.setOnClickListener(v -> {checkForCheckBox(checkBox33, getString(R.string.name33));});
        checkBox34.setOnClickListener(v -> {checkForCheckBox(checkBox34, getString(R.string.name34));});
        checkBox35.setOnClickListener(v -> {checkForCheckBox(checkBox35, getString(R.string.name35));});
        checkBox36.setOnClickListener(v -> {checkForCheckBox(checkBox36, getString(R.string.name36));});
        checkBox37.setOnClickListener(v -> {checkForCheckBox(checkBox37, getString(R.string.name37));});
        checkBox38.setOnClickListener(v -> {checkForCheckBox(checkBox38, getString(R.string.name38));});
        checkBox39.setOnClickListener(v -> {checkForCheckBox(checkBox39, getString(R.string.name39));});
        checkBox40.setOnClickListener(v -> {checkForCheckBox(checkBox40, getString(R.string.name40));});
        checkBox41.setOnClickListener(v -> {checkForCheckBox(checkBox41, getString(R.string.name41));});
        checkBox42.setOnClickListener(v -> {checkForCheckBox(checkBox42, getString(R.string.name42));});
        checkBox43.setOnClickListener(v -> {checkForCheckBox(checkBox43, getString(R.string.name43));});
        checkBox44.setOnClickListener(v -> {checkForCheckBox(checkBox44, getString(R.string.name44));});
        checkBox45.setOnClickListener(v -> {checkForCheckBox(checkBox45, getString(R.string.name45));});
        checkBox46.setOnClickListener(v -> {checkForCheckBox(checkBox46, getString(R.string.name46));});
        checkBox47.setOnClickListener(v -> {checkForCheckBox(checkBox47, getString(R.string.name47));});
        checkBox48.setOnClickListener(v -> {checkForCheckBox(checkBox48, getString(R.string.name48));});
        checkBox49.setOnClickListener(v -> {checkForCheckBox(checkBox49, getString(R.string.name49));});
        checkBox50.setOnClickListener(v -> {checkForCheckBox(checkBox50, getString(R.string.name50));});
        checkBox51.setOnClickListener(v -> {checkForCheckBox(checkBox51, getString(R.string.name51));});
        checkBox52.setOnClickListener(v -> {checkForCheckBox(checkBox52, getString(R.string.name52));});
        checkBox53.setOnClickListener(v -> {checkForCheckBox(checkBox53, getString(R.string.name53));});
        checkBox54.setOnClickListener(v -> {checkForCheckBox(checkBox54, getString(R.string.name54));});
        checkBox55.setOnClickListener(v -> {checkForCheckBox(checkBox55, getString(R.string.name55));});
        checkBox56.setOnClickListener(v -> {checkForCheckBox(checkBox56, getString(R.string.name56));});
        checkBox57.setOnClickListener(v -> {checkForCheckBox(checkBox57, getString(R.string.name57));});
        checkBox58.setOnClickListener(v -> {checkForCheckBox(checkBox58, getString(R.string.name58));});
        checkBox59.setOnClickListener(v -> {checkForCheckBox(checkBox59, getString(R.string.name59));});
        checkBox60.setOnClickListener(v -> {checkForCheckBox(checkBox60, getString(R.string.name60));});
        checkBox61.setOnClickListener(v -> {checkForCheckBox(checkBox61, getString(R.string.name61));});
        checkBox62.setOnClickListener(v -> {checkForCheckBox(checkBox62, getString(R.string.name62));});
        checkBox63.setOnClickListener(v -> {checkForCheckBox(checkBox63, getString(R.string.name63));});


        source1.setOnClickListener(v -> {sharedPreferences_editor_currency.putString("Currency", source1.getText().toString()).apply();});
        source2.setOnClickListener(v -> {sharedPreferences_editor_currency.putString("Currency", source2.getText().toString()).apply();});
        source3.setOnClickListener(v -> {sharedPreferences_editor_currency.putString("Currency", source3.getText().toString()).apply();});
        source4.setOnClickListener(v -> {sharedPreferences_editor_currency.putString("Currency", source4.getText().toString()).apply();});
        source5.setOnClickListener(v -> {sharedPreferences_editor_currency.putString("Currency", source5.getText().toString()).apply();});
        source6.setOnClickListener(v -> {sharedPreferences_editor_currency.putString("Currency", source6.getText().toString()).apply();});
        source7.setOnClickListener(v -> {sharedPreferences_editor_currency.putString("Currency", source7.getText().toString()).apply();});
        source8.setOnClickListener(v -> {sharedPreferences_editor_currency.putString("Currency", source8.getText().toString()).apply();});
        source9.setOnClickListener(v -> {sharedPreferences_editor_currency.putString("Currency", source9.getText().toString()).apply();});
        source10.setOnClickListener(v -> {sharedPreferences_editor_currency.putString("Currency", source10.getText().toString()).apply();});
        source11.setOnClickListener(v -> {sharedPreferences_editor_currency.putString("Currency", source11.getText().toString()).apply();});
        source12.setOnClickListener(v -> {sharedPreferences_editor_currency.putString("Currency", source12.getText().toString()).apply();});
        source13.setOnClickListener(v -> {sharedPreferences_editor_currency.putString("Currency", source13.getText().toString()).apply();});
        source14.setOnClickListener(v -> {sharedPreferences_editor_currency.putString("Currency", source14.getText().toString()).apply();});
        source15.setOnClickListener(v -> {sharedPreferences_editor_currency.putString("Currency", source15.getText().toString()).apply();});
        source16.setOnClickListener(v -> {sharedPreferences_editor_currency.putString("Currency", source16.getText().toString()).apply();});
        source17.setOnClickListener(v -> {sharedPreferences_editor_currency.putString("Currency", source17.getText().toString()).apply();});
        source18.setOnClickListener(v -> {sharedPreferences_editor_currency.putString("Currency", source18.getText().toString()).apply();});
        source19.setOnClickListener(v -> {sharedPreferences_editor_currency.putString("Currency", source19.getText().toString()).apply();});
        source20.setOnClickListener(v -> {sharedPreferences_editor_currency.putString("Currency", source20.getText().toString()).apply();});
        source21.setOnClickListener(v -> {sharedPreferences_editor_currency.putString("Currency", source21.getText().toString()).apply();});
        source22.setOnClickListener(v -> {sharedPreferences_editor_currency.putString("Currency", source22.getText().toString()).apply();});
        source23.setOnClickListener(v -> {sharedPreferences_editor_currency.putString("Currency", source23.getText().toString()).apply();});
        source24.setOnClickListener(v -> {sharedPreferences_editor_currency.putString("Currency", source24.getText().toString()).apply();});
        source25.setOnClickListener(v -> {sharedPreferences_editor_currency.putString("Currency", source25.getText().toString()).apply();});
        source26.setOnClickListener(v -> {sharedPreferences_editor_currency.putString("Currency", source26.getText().toString()).apply();});
        source27.setOnClickListener(v -> {sharedPreferences_editor_currency.putString("Currency", source27.getText().toString()).apply();});
        source28.setOnClickListener(v -> {sharedPreferences_editor_currency.putString("Currency", source28.getText().toString()).apply();});
        source29.setOnClickListener(v -> {sharedPreferences_editor_currency.putString("Currency", source29.getText().toString()).apply();});
        source30.setOnClickListener(v -> {sharedPreferences_editor_currency.putString("Currency", source30.getText().toString()).apply();});
        source31.setOnClickListener(v -> {sharedPreferences_editor_currency.putString("Currency", source31.getText().toString()).apply();});
        source32.setOnClickListener(v -> {sharedPreferences_editor_currency.putString("Currency", source32.getText().toString()).apply();});
        source33.setOnClickListener(v -> {sharedPreferences_editor_currency.putString("Currency", source33.getText().toString()).apply();});
        source34.setOnClickListener(v -> {sharedPreferences_editor_currency.putString("Currency", source34.getText().toString()).apply();});
        source35.setOnClickListener(v -> {sharedPreferences_editor_currency.putString("Currency", source35.getText().toString()).apply();});
        source36.setOnClickListener(v -> {sharedPreferences_editor_currency.putString("Currency", source36.getText().toString()).apply();});
        source37.setOnClickListener(v -> {sharedPreferences_editor_currency.putString("Currency", source37.getText().toString()).apply();});
        source38.setOnClickListener(v -> {sharedPreferences_editor_currency.putString("Currency", source38.getText().toString()).apply();});
        source39.setOnClickListener(v -> {sharedPreferences_editor_currency.putString("Currency", source39.getText().toString()).apply();});
        source40.setOnClickListener(v -> {sharedPreferences_editor_currency.putString("Currency", source40.getText().toString()).apply();});
        source41.setOnClickListener(v -> {sharedPreferences_editor_currency.putString("Currency", source41.getText().toString()).apply();});
        source42.setOnClickListener(v -> {sharedPreferences_editor_currency.putString("Currency", source42.getText().toString()).apply();});
        source43.setOnClickListener(v -> {sharedPreferences_editor_currency.putString("Currency", source43.getText().toString()).apply();});
        source44.setOnClickListener(v -> {sharedPreferences_editor_currency.putString("Currency", source44.getText().toString()).apply();});
        source45.setOnClickListener(v -> {sharedPreferences_editor_currency.putString("Currency", source45.getText().toString()).apply();});
        source46.setOnClickListener(v -> {sharedPreferences_editor_currency.putString("Currency", source46.getText().toString()).apply();});
        source47.setOnClickListener(v -> {sharedPreferences_editor_currency.putString("Currency", source47.getText().toString()).apply();});
        source48.setOnClickListener(v -> {sharedPreferences_editor_currency.putString("Currency", source48.getText().toString()).apply();});
        source49.setOnClickListener(v -> {sharedPreferences_editor_currency.putString("Currency", source49.getText().toString()).apply();});
        source50.setOnClickListener(v -> {sharedPreferences_editor_currency.putString("Currency", source50.getText().toString()).apply();});
        source51.setOnClickListener(v -> {sharedPreferences_editor_currency.putString("Currency", source51.getText().toString()).apply();});
        source52.setOnClickListener(v -> {sharedPreferences_editor_currency.putString("Currency", source52.getText().toString()).apply();});


        editClassVM.list.observe(this, it -> {
            String [] array = it.split(" ");
            String name = array[0];
            int id = Integer.parseInt(array[1]);
            writeToDb(name, id);
        });
    }
    private void writeToDb (String name, int id) {
        dbHelper.writeToDb(name, id, dbHelper);
    }

    private void checkForCheckBox (CheckBox checkBox, String name) {
        int count = sharedPreferencesCounter.getInt("Count", 0);
        if (checkBox.isChecked()) {
            if (count < 4) {
            editClassVM.addToList(name + " "  + checkBox.getId());
            count++;
            sharedPreferences_editor_counter.putInt("Count", count).apply();
            }else {
                Toast.makeText(this, "Слишком много стран", Toast.LENGTH_SHORT).show();
                checkBox.setChecked(false);
            }
        }else if (!checkBox.isChecked()) {
            dbHelper.deleteToDb(name, checkBox.getId(), dbHelper);
            dbHelper_2.deleteToDb(checkBox.getId(), dbHelper_2);
            count--;
            sharedPreferences_editor_counter.putInt("Count", count).apply();
            if (count == 0) {
                sharedPreferences_editor_currency.putString("Currency", "$$$").apply();
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadingBox();
        bottomNavigationView.setSelectedItemId(R.id.Edit);
        //////////////////////////////////////////////////Восстановление состояния боксов
        View decorView = getWindow().getDecorView();
        int uiOptions = (View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        decorView.setSystemUiVisibility(uiOptions);
    }
    public void loadingBox () {
        ArrayList <String> list = dbHelper.readIntoDbBoxID(dbHelper);
        switch (list.size()) {
            case 1 : {
                int id_1 = Integer.parseInt(list.get(0));
                CheckBox checkBox = findViewById(id_1);
                checkBox.setChecked(true);
                break;
            }
            case 2 : {
                int id_1 = Integer.parseInt(list.get(0));
                int id_2 = Integer.parseInt(list.get(1));
                CheckBox checkBox1 = findViewById(id_1);
                CheckBox checkBox2 = findViewById(id_2);
                checkBox1.setChecked(true);
                checkBox2.setChecked(true);
                break;
            }
            case 3 : {
                int id_1 = Integer.parseInt(list.get(0));
                int id_2 = Integer.parseInt(list.get(1));
                int id_3 = Integer.parseInt(list.get(2));
                CheckBox checkBox1 = findViewById(id_1);
                CheckBox checkBox2 = findViewById(id_2);
                CheckBox checkBox3 = findViewById(id_3);
                checkBox1.setChecked(true);
                checkBox2.setChecked(true);
                checkBox3.setChecked(true);
                break;
            }
            case 4 : {
                int id_1 = Integer.parseInt(list.get(0));
                int id_2 = Integer.parseInt(list.get(1));
                int id_3 = Integer.parseInt(list.get(2));
                int id_4 = Integer.parseInt(list.get(3));
                CheckBox checkBox1 = findViewById(id_1);
                CheckBox checkBox2 = findViewById(id_2);
                CheckBox checkBox3 = findViewById(id_3);
                CheckBox checkBox4 = findViewById(id_4);
                checkBox1.setChecked(true);
                checkBox2.setChecked(true);
                checkBox3.setChecked(true);
                checkBox4.setChecked(true);
                break;
            }
        }
    }
    @Override
    protected void onDestroy() {
        dbHelper.close();
        dbHelper_2.close();
        super.onDestroy();
    }

}