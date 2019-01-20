package org.pursuit.appfromscratch.view;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.pursuit.appfromscratch.Display_Activity;
import org.pursuit.appfromscratch.R;
import org.pursuit.appfromscratch.model.AndroidList;
import org.pursuit.appfromscratch.model.MyAndroid;
import org.pursuit.appfromscratch.network.RetrofitService;
import org.pursuit.appfromscratch.network.RetrofitSingleton;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import static org.pursuit.appfromscratch.model.AndroidList.androidone;

public class RetrofitView extends RecyclerView.ViewHolder {
    private TextView verText;
    private TextView nameText;
    private TextView apiText;

    public static final String VER = "ver";
    public static final String NAME = "name";
    public static final String API = "api";

    public RetrofitView(@NonNull View itemView) {
        super(itemView);
        verText = itemView.findViewById(R.id.androidlist_textview_ver);
        nameText = itemView.findViewById(R.id.androidlist_textview_name);
        apiText = itemView.findViewById(R.id.androidlist_textview_api);


    }

    public void onBind(final MyAndroid myAndroid){
        ((TextView) itemView.findViewById(R.id.androidlist_textview_ver)).setText(myAndroid.getVer());
        nameText.setText(myAndroid.getName());
        apiText.setText(myAndroid.getApi());

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(itemView.getContext(), Display_Activity.class);
                intent.putExtra(VER, myAndroid.getVer());
                intent.putExtra(NAME, myAndroid.getName());
                intent.putExtra(API, myAndroid.getApi());
                itemView.getContext().startActivity(intent);
            }
        });
    }

}




