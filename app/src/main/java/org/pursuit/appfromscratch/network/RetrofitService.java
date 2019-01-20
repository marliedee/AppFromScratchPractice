package org.pursuit.appfromscratch.network;

import org.pursuit.appfromscratch.model.AndroidList;
import org.pursuit.appfromscratch.model.MyAndroid;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitService {

    @GET("android/jsonandroid")
    Call<AndroidList> getAndroidVersion();

}
