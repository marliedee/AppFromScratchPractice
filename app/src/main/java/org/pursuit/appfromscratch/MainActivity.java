package org.pursuit.appfromscratch;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import org.pursuit.appfromscratch.controller.RetrofitAdapter;
import org.pursuit.appfromscratch.model.AndroidList;
import org.pursuit.appfromscratch.network.RetrofitService;
import org.pursuit.appfromscratch.network.RetrofitSingleton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    public final String TAG = "ALL_VERSIONS";
    RetrofitAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final RecyclerView androidViews = findViewById(R.id.android_recycler_view);

        Retrofit retrofit = RetrofitSingleton.getInstance();

        retrofit.create(RetrofitService.class)
                .getAndroidVersion()
                .enqueue(new Callback<AndroidList>() {
                    @Override
                    public void onResponse(Call<AndroidList> call, Response<AndroidList> response) {
//                        Log.d(TAG, "OnResponse: " + response.body()
//                                .getAndroidList()
//                                .get(0)
//                                .getName());

                        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
                        adapter = new RetrofitAdapter(response.body().getAndroidList());
                        androidViews.setLayoutManager(linearLayoutManager);
                        androidViews.setAdapter(adapter);
                    }

                    @Override
                    public void onFailure(Call<AndroidList> call, Throwable t) {

                        Log.d(TAG, "OnFailure: " + t.getMessage());

                    }
                });

    }
}



