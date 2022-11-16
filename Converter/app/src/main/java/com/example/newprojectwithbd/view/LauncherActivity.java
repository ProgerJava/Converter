package com.example.newprojectwithbd.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.newprojectwithbd.DB.FeedReaderDbHelper;
import com.example.newprojectwithbd.DB.FeedReaderDbHelper_2;
import com.example.newprojectwithbd.R;
import com.example.newprojectwithbd.VM.LauncherVM;
import com.example.newprojectwithbd.model.ConverterRequest;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class LauncherActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView = null;
    private ImageView update = null;
    ////////////////Поля первой плашки
    private TextView country1 = null;
    private TextView name1 = null;
    private TextView cost1 = null;
    private TextView source1 = null;
    private ImageView imageView1 = null;
    ////////////////Поля второй плашки
    private TextView country2 = null;
    private TextView name2 = null;
    private TextView cost2 = null;
    private TextView source2 = null;
    private ImageView imageView2 = null;
    ////////////////Поля третьей плашки
    private TextView country3 = null;
    private TextView name3 = null;
    private TextView cost3 = null;
    private TextView source3 = null;
    private ImageView imageView3 = null;
    ////////////////Поля четвертой плашки
    private TextView country4 = null;
    private TextView name4 = null;
    private TextView cost4 = null;
    private TextView source4 = null;
    private ImageView imageView4 = null;
    //////////////// Сохранение состояния:
    private LauncherVM launcherVM;
    private String nameDefault;
    /////////////////LinearLayout
    private LinearLayout linearLayout1;
    private LinearLayout linearLayout2;
    private LinearLayout linearLayout3;
    private LinearLayout linearLayout4;
    /////////////////BD
    private FeedReaderDbHelper dbHelper;
    private FeedReaderDbHelper_2 dbHelper_2;
    ////////////loading
    private SharedPreferences sharedPreferencesCurrency;
    private SharedPreferences.Editor sharedPreferences_editor_currency;
    private String str;
    private ConverterRequest converterRequest = new ConverterRequest();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
        overridePendingTransition(0, 0);

        sharedPreferencesCurrency = getSharedPreferences("Currency", Context.MODE_PRIVATE);
        sharedPreferences_editor_currency = sharedPreferencesCurrency.edit();
        str = sharedPreferencesCurrency.getString("Currency", "$$$");

        nameDefault = getString(R.string.field);
        dbHelper = new FeedReaderDbHelper(this);
        dbHelper_2 = new FeedReaderDbHelper_2(this);

        bottomNavigationView = findViewById(R.id.bottom_nav);
        update = findViewById(R.id.update);
        launcherVM = new ViewModelProvider(this).get(LauncherVM.class);

        country1 = findViewById(R.id.country1);
        name1 = findViewById(R.id.name1);
        cost1 = findViewById(R.id.cost1);
        source1 = findViewById(R.id.source1);
        imageView1 = findViewById(R.id.imageView1);
        country2 = findViewById(R.id.country2);
        name2 = findViewById(R.id.name2);
        cost2 = findViewById(R.id.cost2);
        source2 = findViewById(R.id.source2);
        imageView2 = findViewById(R.id.imageView2);
        country3 = findViewById(R.id.country3);
        name3 = findViewById(R.id.name3);
        cost3 = findViewById(R.id.cost3);
        source3 = findViewById(R.id.source3);
        imageView3 = findViewById(R.id.imageView3);
        country4 = findViewById(R.id.country4);
        name4 = findViewById(R.id.name4);
        cost4 = findViewById(R.id.cost4);
        source4 = findViewById(R.id.source4);
        imageView4 = findViewById(R.id.imageView4);
        linearLayout1 = findViewById(R.id.linearLayout2);
        linearLayout2 = findViewById(R.id.linearLayout3);
        linearLayout3 = findViewById(R.id.linearLayout4);
        linearLayout4 = findViewById(R.id.linearLayout5);

        bottomNavigationView.setOnNavigationItemSelectedListener(menuItem -> {
            switch (menuItem.getItemId()) {
                case R.id.Edit: {
                    Intent intent = new Intent(LauncherActivity.this, EditClass.class);
                    startActivity(intent);
                    break;
                }
            }
            return true;
        });

        update.setOnClickListener(v -> {
            createRequest();
        });

        launcherVM.list.observe(this, it -> {
            switch (it.size()) {
                case 3 : {
                    setFirstForm ((ArrayList<String>) it);
                    break;
                }
                case 5 : {
                    setSecondForm ((ArrayList<String>) it);
                    break;
                }
                case 7 : {
                    setThirdForm ((ArrayList<String>) it);
                    break;
                }
                case 9 : {
                    setFourthForm ((ArrayList<String>) it);
                    break;
                }
            }
        });
    }
    private void setFirstForm (ArrayList <String> it) {
        ArrayList <String> listWithId = dbHelper.readIntoDbBoxID(dbHelper);
        ////////////////////////////////////Первая плашка с информацией
        name1.setText(it.get(0).toString().substring(3, it.get(0).length()));
        cost1.setText(it.get(1).substring(0, 6));

        dbHelper_2.deleteToDb(Integer.parseInt(listWithId.get(0)), dbHelper_2);
        dbHelper_2.writeToDb(Integer.parseInt(listWithId.get(0)), Float.parseFloat(String.valueOf(cost1.getText())), country1.getText().toString(),dbHelper_2);
    }
    private void setSecondForm (ArrayList <String> it) {
        ArrayList <String> listWithId = dbHelper.readIntoDbBoxID(dbHelper);
        ////////////////////////////////////Первая плашка с информацией
        name1.setText(it.get(0).toString().substring(3, it.get(0).length()));
        cost1.setText(it.get(1).substring(0, 6));
        ////////////////////////////////////Вторая плашка с информацией
        name2.setText(it.get(2).toString().substring(3, it.get(0).length()));
        cost2.setText(it.get(3).substring(0, 6));

        dbHelper_2.deleteToDb(Integer.parseInt(listWithId.get(0)), dbHelper_2);
        dbHelper_2.deleteToDb(Integer.parseInt(listWithId.get(1)), dbHelper_2);
        dbHelper_2.writeToDb(Integer.parseInt(listWithId.get(0)), Float.parseFloat(String.valueOf(cost1.getText())),country1.getText().toString(), dbHelper_2);
        dbHelper_2.writeToDb(Integer.parseInt(listWithId.get(1)), Float.parseFloat(String.valueOf(cost2.getText())),country2.getText().toString(),dbHelper_2);
    }
    private void setThirdForm (ArrayList <String> it) {
        ArrayList <String> listWithId = dbHelper.readIntoDbBoxID(dbHelper);
        ////////////////////////////////////Первая плашка с информацией
        name1.setText(it.get(0).toString().substring(3, it.get(0).length()));
        cost1.setText(it.get(1).substring(0, 6));
        ////////////////////////////////////Вторая плашка с информацией
        name2.setText(it.get(2).toString().substring(3, it.get(0).length()));
        cost2.setText(it.get(3).substring(0, 6));
        ////////////////////////////////////Третья плашка с информацией
        name3.setText(it.get(4).toString().substring(3, it.get(0).length()));
        cost3.setText(it.get(5).substring(0, 6));
        dbHelper_2.deleteToDb(Integer.parseInt(listWithId.get(0)), dbHelper_2);
        dbHelper_2.deleteToDb(Integer.parseInt(listWithId.get(1)), dbHelper_2);
        dbHelper_2.deleteToDb(Integer.parseInt(listWithId.get(2)), dbHelper_2);
        dbHelper_2.writeToDb(Integer.parseInt(listWithId.get(0)), Float.parseFloat(String.valueOf(cost1.getText())), country1.getText().toString(),dbHelper_2);
        dbHelper_2.writeToDb(Integer.parseInt(listWithId.get(1)), Float.parseFloat(String.valueOf(cost2.getText())), country2.getText().toString(),dbHelper_2);
        dbHelper_2.writeToDb(Integer.parseInt(listWithId.get(2)), Float.parseFloat(String.valueOf(cost3.getText())),country3.getText().toString(), dbHelper_2);
    }
    private void setFourthForm (ArrayList <String> it) {
        ArrayList <String> listWithId = dbHelper.readIntoDbBoxID(dbHelper);
        System.out.println(it.toString());
        ////////////////////////////////////Первая плашка с информацией
        name1.setText(it.get(0).toString().substring(3, it.get(0).length()));
        cost1.setText(it.get(1).substring(0, 6));
        ////////////////////////////////////Вторая плашка с информацией
        name2.setText(it.get(2).toString().substring(3, it.get(0).length()));
        cost2.setText(it.get(3).substring(0, 6));
        ////////////////////////////////////Третья плашка с информацией
        name3.setText(it.get(4).toString().substring(3, it.get(0).length()));
        cost3.setText(it.get(5).substring(0, 6));
        ////////////////////////////////////Четвертая плашка с информацией
        name4.setText(it.get(6).toString().substring(3, it.get(0).length()));
        cost4.setText(it.get(7).substring(0, 6));

        dbHelper_2.deleteToDb(Integer.parseInt(listWithId.get(0)), dbHelper_2);
        dbHelper_2.deleteToDb(Integer.parseInt(listWithId.get(1)), dbHelper_2);
        dbHelper_2.deleteToDb(Integer.parseInt(listWithId.get(2)), dbHelper_2);
        dbHelper_2.deleteToDb(Integer.parseInt(listWithId.get(3)), dbHelper_2);

        dbHelper_2.writeToDb(Integer.parseInt(listWithId.get(0)),Float.parseFloat(String.valueOf(cost1.getText())), country1.getText().toString(), dbHelper_2);
        dbHelper_2.writeToDb(Integer.parseInt(listWithId.get(1)),Float.parseFloat(String.valueOf(cost2.getText())), country2.getText().toString(),dbHelper_2);
        dbHelper_2.writeToDb(Integer.parseInt(listWithId.get(2)),Float.parseFloat(String.valueOf(cost3.getText())), country3.getText().toString(),dbHelper_2);
        dbHelper_2.writeToDb(Integer.parseInt(listWithId.get(3)),Float.parseFloat(String.valueOf(cost4.getText())), country4.getText().toString(),dbHelper_2);
    }
    @SuppressLint("UseCompatLoadingForDrawables")
    private void createRequest () {
        String request = "";
        if (country1.getText().toString().equals(nameDefault) || str.equals("$$$")) {
            imageView1.setBackground(getDrawable(R.drawable.def));
            Toast.makeText(this, "Проверьте корректность данных", Toast.LENGTH_SHORT).show();
        }
        else if (linearLayout2.getVisibility() == View.INVISIBLE) {
            request = converterRequest.setRequest(country1.getText().toString());
            if (name1.getText().toString().equals(str)) {
                Toast.makeText(this, "Удалите из списка " + country1.getText() + ",\n либо поменяйте источник. \nПричина: графы \"валюта\" и \"источник\" не могут быть равны", Toast.LENGTH_LONG).show();
                return;
            }
            launcherVM.setCurrency(str);
            launcherVM.setRequest(request);
            launcherVM.onStart();
        }
        else if (linearLayout3.getVisibility() == View.INVISIBLE) {
            request = converterRequest.setRequest(country1.getText().toString())
                    +  "%2C" +
                    converterRequest.setRequest(country2.getText().toString());
            if (name1.getText().toString().equals(str) || name2.getText().toString().equals(str)) {
                Toast.makeText(this, "Удалите лишние элемениы из списка,\n либо поменяйте источник. \nПричина: графы \"валюта\" и \"источник\" не могут быть равны", Toast.LENGTH_LONG).show();
                return;
            }
            launcherVM.setCurrency(str);
            launcherVM.setRequest(request);
            launcherVM.onStart();
        }
        else if (linearLayout4.getVisibility() == View.INVISIBLE) {
            request = converterRequest.setRequest(country1.getText().toString())
                    +  "%2C" +
                    converterRequest.setRequest(country2.getText().toString())
                    +  "%2C" +
                    converterRequest.setRequest(country3.getText().toString());
            if (name1.getText().toString().equals(str) || name2.getText().toString().equals(str) || name3.getText().toString().equals(str)) {
                Toast.makeText(this, "Удалите лишние элемениы из списка,\n либо поменяйте источник. \nПричина: графы \"валюта\" и \"источник\" не могут быть равны", Toast.LENGTH_LONG).show();
                return;
            }
            launcherVM.setCurrency(str);
            launcherVM.setRequest(request);
            launcherVM.onStart();
        }
        else  {
            request = converterRequest.setRequest(country1.getText().toString())
                    +  "%2C" +
                    converterRequest.setRequest(country2.getText().toString())
                    +  "%2C" +
                    converterRequest.setRequest(country3.getText().toString())
                    +  "%2C" +
                    converterRequest.setRequest(country4.getText().toString());
            if (name1.getText().toString().equals(str) || name2.getText().toString().equals(str) || name3.getText().toString().equals(str) || name4.getText().toString().equals(str)) {
                Toast.makeText(this, "Удалите лишние элемениы из списка,\n либо поменяйте источник. \nПричина: графы \"валюта\" и \"источник\" не могут быть равны", Toast.LENGTH_LONG).show();
                return;
            }
            launcherVM.setCurrency(str);
            launcherVM.setRequest(request);
            launcherVM.onStart();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadingData();
        bottomNavigationView.setSelectedItemId(R.id.Home);
        View decorView = getWindow().getDecorView();
        int uiOptions = (View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        decorView.setSystemUiVisibility(uiOptions);
    }
    @SuppressLint("UseCompatLoadingForDrawables")
    public void loadingData () {
        //////////////////Воспроизведение сохранненых данных после повторного запуска активити
        ArrayList <String> list = dbHelper.readIntoDbCountry(dbHelper);
        ArrayList<String> list1 = dbHelper_2.readIntoDbCost(dbHelper_2);
        switch (list.size()) {
            case 1 : {
                country1.setText(list.get(0));
                imageView1.setBackground(getDrawable(converterRequest.setCountryFlag(country1.getText().toString())));
                name1.setText(converterRequest.setRequest(country1.getText().toString()));
                source1.setText(sharedPreferencesCurrency.getString("Currency", "&&&"));
                linearLayout2.setVisibility(View.INVISIBLE);
                linearLayout3.setVisibility(View.INVISIBLE);
                linearLayout4.setVisibility(View.INVISIBLE);
                break;
            }
            case 2 : {
                country1.setText(list.get(0));
                country2.setText(list.get(1));
                imageView1.setBackground(getDrawable(converterRequest.setCountryFlag(country1.getText().toString())));
                imageView2.setBackground(getDrawable(converterRequest.setCountryFlag(country2.getText().toString())));
                source1.setText(sharedPreferencesCurrency.getString("Currency", "&&&"));
                source2.setText(sharedPreferencesCurrency.getString("Currency", "&&&"));
                name1.setText(converterRequest.setRequest(country1.getText().toString()));
                name2.setText(converterRequest.setRequest(country2.getText().toString()));
                linearLayout3.setVisibility(View.INVISIBLE);
                linearLayout4.setVisibility(View.INVISIBLE);
                break;
            }
            case 3 : {
                country1.setText(list.get(0));
                country2.setText(list.get(1));
                country3.setText(list.get(2));
                imageView1.setBackground(getDrawable(converterRequest.setCountryFlag(country1.getText().toString())));
                imageView2.setBackground(getDrawable(converterRequest.setCountryFlag(country2.getText().toString())));
                imageView3.setBackground(getDrawable(converterRequest.setCountryFlag(country3.getText().toString())));
                source1.setText(sharedPreferencesCurrency.getString("Currency", "&&&"));
                source2.setText(sharedPreferencesCurrency.getString("Currency", "&&&"));
                source3.setText(sharedPreferencesCurrency.getString("Currency", "&&&"));
                name1.setText(converterRequest.setRequest(country1.getText().toString()));
                name2.setText(converterRequest.setRequest(country2.getText().toString()));
                name3.setText(converterRequest.setRequest(country3.getText().toString()));
                linearLayout4.setVisibility(View.INVISIBLE);
                break;
            }
            case 4 : {
                country1.setText(list.get(0));
                country2.setText(list.get(1));
                country3.setText(list.get(2));
                country4.setText(list.get(3));
                imageView1.setBackground(getDrawable(converterRequest.setCountryFlag(country1.getText().toString())));
                imageView2.setBackground(getDrawable(converterRequest.setCountryFlag(country2.getText().toString())));
                imageView3.setBackground(getDrawable(converterRequest.setCountryFlag(country3.getText().toString())));
                imageView4.setBackground(getDrawable(converterRequest.setCountryFlag(country4.getText().toString())));
                source1.setText(sharedPreferencesCurrency.getString("Currency", "&&&"));
                source2.setText(sharedPreferencesCurrency.getString("Currency", "&&&"));
                source3.setText(sharedPreferencesCurrency.getString("Currency", "&&&"));
                source4.setText(sharedPreferencesCurrency.getString("Currency", "&&&"));
                name1.setText(converterRequest.setRequest(country1.getText().toString()));
                name2.setText(converterRequest.setRequest(country2.getText().toString()));
                name3.setText(converterRequest.setRequest(country3.getText().toString()));
                name4.setText(converterRequest.setRequest(country4.getText().toString()));
                break;
            }
            case 0 : {
                imageView1.setBackground(getDrawable(R.drawable.def));
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(80, 80);
                layoutParams.gravity = Gravity.CENTER;
                layoutParams.setMarginStart(90);
                imageView1.setLayoutParams(layoutParams);
                linearLayout2.setVisibility(View.INVISIBLE);
                linearLayout3.setVisibility(View.INVISIBLE);
                linearLayout4.setVisibility(View.INVISIBLE);
            }
        }
        if (country1.getText().equals(nameDefault)) return;
        String [] array;
        switch (list1.size()) {
            case 0 : {
                cost1.setText("0");
                cost2.setText("0");
                cost3.setText("0");
                cost4.setText("0");
                break;
            }
            case 1: {
                array = list1.get(0).split(" ");
                cost1.setText(array[1].substring(0, 6));
                break;
            }case 2: {
                array = list1.get(0).split(" ");
                if (array[0].equals(country1.getText())) {
                    cost1.setText(array[1].substring(0, 6));
                    array = list1.get(1).split(" ");
                    cost2.setText(array[1].substring(0, 6));
                }else {
                    cost2.setText(array[1].substring(0, 6));
                    array = list1.get(1).split(" ");
                    cost1.setText(array[1].substring(0, 6));
                }
                break;
            } case 3 : {
                getCost3(list1);
                break;
            } case 4 : {
                getCost4(list1);
                break;
            }

        }
    }
    public void getCost3 (ArrayList <String> list1) {
        String [] array;
        for (int i = 0; i < 3; i++) {
            array = list1.get(i).split(" ");
            if (array[0].contentEquals(country1.getText())) {
                cost1.setText(array[1].substring(0, 6));
            }else if (array[0].contentEquals(country2.getText())) {
                cost2.setText(array[1].substring(0, 6));
            }else {
                cost3.setText(array[1].substring(0, 6));
            }
        }
    }
    public void getCost4 (ArrayList <String> list1) {
        String [] array;
        for (int i = 0; i < 4; i++) {
            array = list1.get(i).split(" ");
            if (array[0].contentEquals(country1.getText())) {
                cost1.setText(array[1].substring(0, 6));
            }else if (array[0].contentEquals(country2.getText())) {
                cost2.setText(array[1].substring(0, 6));
            }else if (array[0].contentEquals(country3.getText())) {
                cost3.setText(array[1].substring(0, 6));
            } else {
                cost4.setText(array[1].substring(0, 6));
            }
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        dbHelper.close();
        dbHelper_2.close();
    }
}