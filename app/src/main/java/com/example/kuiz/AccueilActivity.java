package com.example.kuiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class AccueilActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_accueil);
    }

    public void onButtonQuizClicked(View view){
        Intent i = new Intent(this, ParamQuizActivity.class);
        startActivity(i);
    }
}
