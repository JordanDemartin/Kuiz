package com.example.kuiz;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.Spinner;

import java.util.Arrays;
import java.util.Random;

public class ParamQuizActivity extends Activity {

    private int nb_question = 5;
    private String difficulte = "normal";

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_param_quiz);

        Spinner spinner = (Spinner) findViewById(R.id.choix_theme);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.choix_theme, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    public void onRadioButtonDifficulteClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.radio_facile:
                if (checked)
                    this.difficulte = "facile";
                break;
            case R.id.radio_normal:
                if (checked)
                    this.difficulte = "normal";
                break;
            case R.id.radio_difficile:
                if (checked)
                    this.difficulte = "difficile";
                break;
        }
    }

    public void onRadioButtonNbQuestionClicked(View view) {
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
        int theme = theme_to_id_theme( ((Spinner)findViewById(R.id.choix_theme)).getSelectedItem().toString() );
        int[] id_questions = new int[this.nb_question];

        Cursor questions;
        if(theme == -1){
            questions = baseDeDonnees.query(true, AccesBDInterne.NOM_TABLE_CONTENIR_THEME_QUESTION, new String[]{AccesBDInterne.CONTENIR_THEME_QUESTION_ID_QUESTION} , null, null , null, null, null,null);
        }else{
            //Log.d("theme",""+theme);
            questions = baseDeDonnees.query(true, AccesBDInterne.NOM_TABLE_CONTENIR_THEME_QUESTION, new String[]{AccesBDInterne.CONTENIR_THEME_QUESTION_ID_QUESTION} , AccesBDInterne.CONTENIR_THEME_QUESTION_ID_THEME +" = ?", new String[]{""+theme} , null, null, null,null);
        }

        if(questions != null){
            if(questions.getCount()>0){
                //Log.d("count question ",""+questions.getCount());

                for(int i = 0 ; i < this.nb_question ; i++){
                    //génère un int aléatoire
                    int id_question_random = ran.nextInt();
                    //rends le int aléatoire positif
                    id_question_random = Math.abs(id_question_random);
                    //fais en sorte que le int aléatoire soit entre 0 et questions.getCount()
                    id_question_random = id_question_random%questions.getCount();

                    questions.moveToPosition(id_question_random);
                    id_questions[i] = questions.getInt(0);
                    //Log.d("id question random "+i,""+id_questions[i]);

                    boolean doublon = false;
                    for(int j = 0 ; j < i ; j++){
                        if(id_questions[j] == questions.getInt(0)){
                            doublon = true;
                            break;
                        }
                    }

                    if(doublon){
                        //Log.d("y'a un doublon ",""+questions.getInt(0));
                        i--;
                    }
                }
            }
        }
        questions.close();

        Intent i = new Intent(this, QuizActivity.class);
        i.putExtra("id_questions",id_questions);
        i.putExtra("difficulte",difficulte);
        startActivity(i);
    }

    public int theme_to_id_theme(String theme){
        int id_theme = -1;

        if(theme.equals("Culture générale")){
            id_theme = 0;
        }else if(theme.equals("Films")){
            id_theme = 1;
        }else if(theme.equals("Sport")){
            id_theme = 2;
        }else if(theme.equals("Science")){
            id_theme = 3;
        }else if(theme.equals("Musique")){
            id_theme = 4;
        }else if(theme.equals("Art")){
            id_theme = 5;
        }else if(theme.equals("Géographie")){
            id_theme = 6;
        }else if(theme.equals("Histoire")){
            id_theme = 7;
        }
        return id_theme;
    }

}
