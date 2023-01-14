package com.example.newprojectwithbd.model;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class LauncherModel extends Thread {


    private ArrayList <String> list = new ArrayList<>();
    private String source = "";
    private String currencies = "";

    public ArrayList<String> getList () {
        return list;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getCurrencies() {
        return currencies;
    }

    public void setCurrencies(String currencies) {
        this.currencies = currencies;
    }

    @Override
    public synchronized void run() {
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        Request request = new Request.Builder()
                .url("https://api.apilayer.com/currency_data/live?source=" + getSource() + "&currencies=" + getCurrencies())
                .addHeader("apikey", "Q9edSuo4ONKD1Iv1PlQT5lW9hm8RUOqe")
                .method("GET", null)
                .build();

        client.newCall(request).enqueue(new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println(e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    String str = response.body().string();
                    StringBuilder stringBuilder = new StringBuilder();
                    for (int i = 0; i < str.length(); i++) {
                        Character c = str.charAt(i);
                        if (c.equals(' ') || c.equals('\n') || c.equals('{') || c.equals('}')) {
                        }else {
                            stringBuilder.append(c);
                        }
                    }
                    boolean flag = false;
                    String [] array = stringBuilder.toString().split(",");
                    for (int i = 0; i < array.length; i++) {
                        String c = array [i];
                        if (c.contains("quotes")) {
                            for (int j = i; j < array.length; j++) {
                                list.add(array[j]);
                            }
                            flag = true;
                        }
                        if (flag) {
                            break;
                        }
                    }
                }
            }
        });
    }
}
