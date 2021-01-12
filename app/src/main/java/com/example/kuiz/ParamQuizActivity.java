package com.example.kuiz;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.RadioButton;

import java.util.Arrays;
import java.util.Random;

public class ParamQuizActivity extends Activity {

    private int nb_question = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_param_quiz);
    }

    public void onRadioButtonClicked(View view) {
        //est-ce que le bouton
        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.radio_5:
                if (checked)
                    this.nb_question = 5;
                    break;
            case R.id.radio_10:
                if (checked)
                    this.nb_question = 10;
                    break;
            case R.id.radio_15:
                if (checked)
                    this.nb_question = 15;
                    break;
        }
    }

    public void onButtonStartClicked(View view) {
        AccesBDInterne acces = new AccesBDInterne(this);
        SQLiteDatabase baseDeDonnees = acces.getReadableDatabase();
        Random ran = new Random();
        int[] id_questions = new int[this.nb_question];

        Cursor questions = baseDeDonnees.query(true, AccesBDInterne.NOM_TABLE_QUESTION, null , null, null , null, null, null,null);

        if(questions != null){
            if(questions.getCount()>0){
                Log.d("count question ",""+questions.getCount());

                for(int i = 0 ; i < this.nb_question ; i++){
                    //génère un int aléatoire
                    int id_question_random = ran.nextInt();
                    //rends le int aléatoire positif
                    id_question_random = Math.abs(id_question_random);
                    //fais en sorte que le int aléatoire soit entre 0 et questions.getCount()
                    id_question_random = id_question_random%questions.getCount();

                    id_questions[i] = id_question_random;
                    Log.d("id question random "+i,""+id_questions[i]);

                    boolean doublon = false;
                    for(int j = 0 ; j < i ; j++){
                        if(id_questions[j] == id_question_random){
                            doublon = true;
                            break;
                        }
                    }

                    if(doublon){
                        Log.d("y'a un doublon ",""+id_question_random);
                        i--;
                    }
                }
            }
        }
        questions.close();

        Intent i = new Intent(this, QuizActivity.class);
        i.putExtra("id_questions",id_questions);
        startActivity(i);
    }

}
