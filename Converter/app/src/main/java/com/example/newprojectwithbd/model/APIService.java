package com.example.newprojectwithbd.model;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface APIService {

    String example =  "live?source=USD&currencies=RUB%2CBYN%2CUAH";


    @Headers("apikey: your key")
    @GET("live")
    Call<PojoClass> getInfoSNG(@Query("source") String currencies,
                               @Query("currencies") String request);

}
