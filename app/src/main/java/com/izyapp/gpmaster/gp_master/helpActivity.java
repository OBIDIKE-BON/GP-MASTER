package com.izyapp.gpmaster.gp_master;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;


public class helpActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.help);
    }
    public void exit(View v){
        finish();
    }
}
