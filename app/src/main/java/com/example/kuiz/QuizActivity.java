package com.example.kuiz;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class QuizActivity extends Activity {

    private int[] id_questions;
    private String bonne_reponse;
    private String reponse_joueur;
    private int position_quiz;
    private int compte_bonne_reponse;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_quiz);

        Intent intent = getIntent();
        this.id_questions = intent.getIntArrayExtra("id_questions");

        this.position_quiz = 0;
        this.compte_bonne_reponse = 0;

        affiche_question();
    }

    protected void affiche_question(){
        this.bonne_reponse = "e";
        this.reponse_joueur = "e";
        findViewById(R.id.quiz_bouton_valider_reponse).setVisibility(View.VISIBLE);
        findViewById(R.id.quiz_bouton_question_suivante).setVisibility(View.GONE);
        ((Button)findViewById(R.id.quiz_bouton_reponse_a)).setClickable(true);
        ((Button)findViewById(R.id.quiz_bouton_reponse_b)).setClickable(true);
        ((Button)findViewById(R.id.quiz_bouton_reponse_c)).setClickable(true);
        ((Button)findViewById(R.id.quiz_bouton_reponse_d)).setClickable(true);
        AccesBDInterne acces = new AccesBDInterne(this);
        SQLiteDatabase baseDeDonnees = acces.getReadableDatabase();

        Cursor question = baseDeDonnees.query(AccesBDInterne.NOM_TABLE_QUESTION, new String[]{AccesBDInterne.QUESTION_INTITULE_QUESTION} , AccesBDInterne.QUESTION_ID_QUESTION +" = ?", new String[]{""+this.id_questions[this.position_quiz]}, null, null, null);

        question.moveToFirst();
        ((TextView)findViewById(R.id.quiz_question)).setText(question.getString(0));
        question.close();

        Cursor reponses = baseDeDonnees.query(AccesBDInterne.NOM_TABLE_REPONSE, new String[]{AccesBDInterne.REPONSE_INTITULE_REPONSE,AccesBDInterne.REPONSE_VERACITE_REPONSE} , AccesBDInterne.REPONSE_ID_QUESTION +" = ?", new String[]{""+this.id_questions[this.position_quiz]}, null, null, null);
        reponses.moveToFirst();

        Random random = new Random();
        int start_count = Math.abs(random.nextInt())%4;
        for(int i = 0 ; i < 4 ; i++){

            Button reponse_visuel = ((Button)findViewById(R.id.quiz_bouton_reponse_a));
            if(((start_count+i)%4) == 0){
                reponse_visuel = ((Button)findViewById(R.id.quiz_bouton_reponse_a));
            }else if(((start_count+i)%4) == 1){
                reponse_visuel = ((Button)findViewById(R.id.quiz_bouton_reponse_b));
            }else if(((start_count+i)%4) == 2){
                reponse_visuel = ((Button)findViewById(R.id.quiz_bouton_reponse_c));
            }else if(((start_count+i)%4) == 3){
                reponse_visuel = ((Button)findViewById(R.id.quiz_bouton_reponse_d));
            }

            reponse_visuel.setText(reponses.getString(0));

            if(reponses.getInt(1) > 0){

                if(((start_count+i)%4) == 0){
                    bonne_reponse = "a";
                }else if(((start_count+i)%4) == 1){
                    bonne_reponse = "b";
                }else if(((start_count+i)%4) == 2){
                    bonne_reponse = "c";
                }else if(((start_count+i)%4) == 3){
                    bonne_reponse = "d";
                }
            }

            if(i != 3){
                reponses.moveToNext();
            }
        }
        reponses.close();

    }

    public void onButtonAnswerClicked(View view){
        if(reponse_joueur.equals("a")){
            ((Button)findViewById(R.id.quiz_bouton_reponse_a)).setBackgroundColor(Color.parseColor("lightgray"));
            ((Button)findViewById(R.id.quiz_bouton_reponse_a)).setTextColor(Color.parseColor("black"));
        }else if(reponse_joueur.equals("b")){
            ((Button)findViewById(R.id.quiz_bouton_reponse_b)).setBackgroundColor(Color.parseColor("lightgray"));
            ((Button)findViewById(R.id.quiz_bouton_reponse_b)).setTextColor(Color.parseColor("black"));
        }else if(reponse_joueur.equals("c")){
            ((Button)findViewById(R.id.quiz_bouton_reponse_c)).setBackgroundColor(Color.parseColor("lightgray"));
            ((Button)findViewById(R.id.quiz_bouton_reponse_c)).setTextColor(Color.parseColor("black"));
        }else if(reponse_joueur.equals("d")){
            ((Button)findViewById(R.id.quiz_bouton_reponse_d)).setBackgroundColor(Color.parseColor("lightgray"));
            ((Button)findViewById(R.id.quiz_bouton_reponse_d)).setTextColor(Color.parseColor("black"));
        }
        Button reponse_clicked = (Button)view;

        reponse_clicked.setBackgroundColor(Color.parseColor("black"));
        reponse_clicked.setTextColor(Color.parseColor("white"));

        if(reponse_clicked.getId() == R.id.quiz_bouton_reponse_a){
            reponse_joueur = "a";
        }else if(reponse_clicked.getId() == R.id.quiz_bouton_reponse_b){
            reponse_joueur = "b";
        }else if(reponse_clicked.getId() == R.id.quiz_bouton_reponse_c){
            reponse_joueur = "c";
        }else if(reponse_clicked.getId() == R.id.quiz_bouton_reponse_d){
            reponse_joueur = "d";
        }

    }

    public void onButtonFinalAnswerClicked(View view){
        if(!reponse_joueur.equals("e")){
            ((Button)findViewById(R.id.quiz_bouton_reponse_a)).setClickable(false);
            ((Button)findViewById(R.id.quiz_bouton_reponse_b)).setClickable(false);
            ((Button)findViewById(R.id.quiz_bouton_reponse_c)).setClickable(false);
            ((Button)findViewById(R.id.quiz_bouton_reponse_d)).setClickable(false);

            if(bonne_reponse.equals(reponse_joueur)){
                if(reponse_joueur.equals("a")){
                    ((Button)findViewById(R.id.quiz_bouton_reponse_a)).setBackgroundColor(Color.parseColor("green"));
                }else if(reponse_joueur.equals("b")){
                    ((Button)findViewById(R.id.quiz_bouton_reponse_b)).setBackgroundColor(Color.parseColor("green"));
                }else if(reponse_joueur.equals("c")){
                    ((Button)findViewById(R.id.quiz_bouton_reponse_c)).setBackgroundColor(Color.parseColor("green"));
                }else if(reponse_joueur.equals("d")){
                    ((Button)findViewById(R.id.quiz_bouton_reponse_d)).setBackgroundColor(Color.parseColor("green"));
                }

                this.compte_bonne_reponse++;
                //update barre de progression
            }else{
                if(reponse_joueur.equals("a")){
                    ((Button)findViewById(R.id.quiz_bouton_reponse_a)).setBackgroundColor(Color.parseColor("red"));
                }else if(reponse_joueur.equals("b")){
                    ((Button)findViewById(R.id.quiz_bouton_reponse_b)).setBackgroundColor(Color.parseColor("red"));
                }else if(reponse_joueur.equals("c")){
                    ((Button)findViewById(R.id.quiz_bouton_reponse_c)).setBackgroundColor(Color.parseColor("red"));
                }else if(reponse_joueur.equals("d")){
                    ((Button)findViewById(R.id.quiz_bouton_reponse_d)).setBackgroundColor(Color.parseColor("red"));
                }

                if(bonne_reponse.equals("a")){
                    ((Button)findViewById(R.id.quiz_bouton_reponse_a)).setBackgroundColor(Color.parseColor("green"));
                }else if(bonne_reponse.equals("b")){
                    ((Button)findViewById(R.id.quiz_bouton_reponse_b)).setBackgroundColor(Color.parseColor("green"));
                }else if(bonne_reponse.equals("c")){
                    ((Button)findViewById(R.id.quiz_bouton_reponse_c)).setBackgroundColor(Color.parseColor("green"));
                }else if(bonne_reponse.equals("d")){
                    ((Button)findViewById(R.id.quiz_bouton_reponse_d)).setBackgroundColor(Color.parseColor("green"));
                }
            }

            findViewById(R.id.quiz_bouton_valider_reponse).setVisibility(View.GONE);
            findViewById(R.id.quiz_bouton_question_suivante).setVisibility(View.VISIBLE);
        }
    }

    public void onButtonNextQuestionClicked(View view){
        this.position_quiz++;

        ((Button)findViewById(R.id.quiz_bouton_reponse_a)).setBackgroundColor(Color.parseColor("lightgray"));
        ((Button)findViewById(R.id.quiz_bouton_reponse_a)).setTextColor(Color.parseColor("black"));
        ((Button)findViewById(R.id.quiz_bouton_reponse_b)).setBackgroundColor(Color.parseColor("lightgray"));
        ((Button)findViewById(R.id.quiz_bouton_reponse_b)).setTextColor(Color.parseColor("black"));
        ((Button)findViewById(R.id.quiz_bouton_reponse_c)).setBackgroundColor(Color.parseColor("lightgray"));
        ((Button)findViewById(R.id.quiz_bouton_reponse_c)).setTextColor(Color.parseColor("black"));
        ((Button)findViewById(R.id.quiz_bouton_reponse_d)).setBackgroundColor(Color.parseColor("lightgray"));
        ((Button)findViewById(R.id.quiz_bouton_reponse_d)).setTextColor(Color.parseColor("black"));

        Log.d("idquestions:"+this.id_questions.length,"position:"+this.position_quiz);
        if(this.id_questions.length == this.position_quiz){
            Log.d("pour " + this.id_questions.length + " questions",this.compte_bonne_reponse + " bonnes réponses");
            finish();
        }else{
            affiche_question();
        }
    }

}
