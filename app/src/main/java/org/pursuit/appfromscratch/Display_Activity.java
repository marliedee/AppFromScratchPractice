package org.pursuit.appfromscratch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Display_Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
         TextView verTextView;
         TextView nameTextView;
         TextView apiTextView;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_);
        verTextView = findViewById(R.id.androidlist_textview_ver);
        nameTextView = findViewById(R.id.androidlist_textview_name);
        apiTextView = findViewById(R.id.androidlist_textview_api);


    }
}
