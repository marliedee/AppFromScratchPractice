package org.pursuit.appfromscratch.controller;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.pursuit.appfromscratch.R;
import org.pursuit.appfromscratch.model.MyAndroid;
import org.pursuit.appfromscratch.view.RetrofitView;

import java.util.List;

import static org.pursuit.appfromscratch.view.RetrofitView.*;

public class RetrofitAdapter extends RecyclerView.Adapter<RetrofitView> {

    public RetrofitAdapter(List<MyAndroid> androidList) {
        this.androidsList = androidList;
    }
    private  List<MyAndroid> androidsList;


    @NonNull
    @Override
    public RetrofitView onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View childView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.android_item_view, viewGroup, false);
        return new RetrofitView(childView);    }

    @Override
    public void onBindViewHolder(@NonNull RetrofitView retrofitView, int i) {
        retrofitView.onBind(androidsList.get(i));
    }

    @Override
    public int getItemCount() {
        return androidsList.size();
    }
}
