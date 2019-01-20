package org.pursuit.appfromscratch.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitSingleton {

    private static Retrofit MyInstance;

    public static Retrofit getInstance() {
        if (MyInstance != null) {
            return MyInstance;
        }
        MyInstance = new Retrofit.Builder()
                .baseUrl("https://api.learn2crack.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return MyInstance;
    }

    private RetrofitSingleton() {
    }
}


