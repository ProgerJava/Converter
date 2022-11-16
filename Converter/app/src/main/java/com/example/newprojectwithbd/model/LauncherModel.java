package com.example.newprojectwithbd.model;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LauncherModel {

    List<String> changesList = new ArrayList<>();



    public void onStart (String currencies, String request) {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.apilayer.com/currency_data/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        APIService userService = retrofit.create(APIService.class);

        Call<PojoClass> call = userService.getInfoSNG(currencies, request);
        call.enqueue(new Callback<PojoClass>() {
            @Override
            public void onResponse(Call<PojoClass> call, Response<PojoClass> response) {
                if (response.isSuccessful()) {
                    String [] array = response.body().getQuotes().toString().substring(1, response.body().getQuotes().toString().length()-1).split("=|\\s");
                    changesList.addAll(Arrays.asList(array));
                    changesList.add(response.body().getSource());
                    System.out.println(response.body().getQuotes().toString());
                } else {
                    System.out.println(response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<PojoClass> call, Throwable t) {
                System.out.println("---------" + t.getLocalizedMessage() +" ----------");
                call.cancel();
            }
        });

    }

    public List <String> getChangesList() {
        return changesList;
    }
}
