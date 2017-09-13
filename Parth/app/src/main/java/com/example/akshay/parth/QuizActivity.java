package com.example.akshay.parth;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.akshay.parth.data.NotifyContract;
import com.example.akshay.parth.data.NotifyDbHelper;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

import static com.example.akshay.parth.R.id.Option1;
import static com.example.akshay.parth.R.id.sign_out_menu;

public class QuizActivity extends AppCompatActivity {



    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mMessageDatabasereference;

    private ChildEventListener mChildEventListener;
    TextView TimerTextView;
    TextView ScoreTextView;
    TextView QuestionTextView;
    String CurrentCorrectAnswer;
    public Button Option1,Option2,Option4;
    public Button Option3;
    int i,yourScore,totalScore;
    ArrayList<questionInfo> quesList;
    boolean x=true;
    questionInfo xyz;


    int counter=0;

    String[] QuestionArray;
    String[] AnswersArray;
    String[] OptiononeArray;
    String[] Optiontworray;
    String[] OptionthreeArray;
    String[] OptionfourArray;

    List<Button> buttons;
    private static final int[] Button_ids={
            R.id.radioButton1,
            R.id.radioButton2,
            R.id.radioButton3,
            R.id.radioButton4,
            R.id.radioButton5
    };




    private NotifyDbHelper mDbHelper;

    public void updateTimer(int secondsleft){
        int minutes = secondsleft/60;
        int seconds = secondsleft-minutes*60;
        String secondSecond=String.valueOf(seconds);
        String minutesstring=String.valueOf(minutes);
        if(seconds<=9)
            secondSecond="0"+String.valueOf(seconds);
        if(minutes==0){
            minutesstring="00";

        }

        TimerTextView.setText(minutesstring+":"+secondSecond);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        i = 0;
        TimerTextView=(TextView)findViewById(R.id.TimerTextView);
        ScoreTextView=(TextView)findViewById(R.id.ScoreTextView);
        QuestionTextView=(TextView)findViewById(R.id.QuestionTextView);
        Option1=(Button)findViewById(R.id.Option1);
        Option2=(Button)findViewById(R.id.Option2);
        Option3=(Button) findViewById(R.id.Option3);
        Option4=(Button)findViewById(R.id.Option4);

        quesList = new ArrayList<>();
        xyz=new questionInfo();

        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mMessageDatabasereference = mFirebaseDatabase.getReference().child("Akshay Kumar");

        /*mChildEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {


                questionInfo friendlyMessage = dataSnapshot.getValue(questionInfo.class);
                add(friendlyMessage);



            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };
        mMessageDatabasereference.addChildEventListener(mChildEventListener);
*/

        QuestionArray = getResources().getStringArray(R.array.Questions_array);

        AnswersArray = getResources().getStringArray(R.array.Answers_array);

        OptiononeArray = getResources().getStringArray(R.array.Optionsone_array);

        Optiontworray = getResources().getStringArray(R.array.optionstwo_array);

        OptionthreeArray = getResources().getStringArray(R.array.optionthree_array);

        OptionfourArray = getResources().getStringArray(R.array.optionfour_array);
        //get firebase auth instance
        TimerTextView.setText("00:30");
        ScoreTextView.setText("0/0");



    }

    public void OptionSelected(View view) {
        Button buttonClicked=(Button)findViewById(view.getId());
        String userAns=(String)buttonClicked.getText();
        Toast.makeText(getApplicationContext(),userAns,Toast.LENGTH_SHORT).show();
        RadioButton button=(RadioButton) findViewById(Button_ids[counter]);
        if(userAns.equals(CurrentCorrectAnswer)){
            ++yourScore;
            button.setChecked(true);


        }
        else{
            button.setChecked(false);
        }
        ++counter;
        ++totalScore;

        ScoreTextView.setText(String.valueOf(yourScore)+"/"+String.valueOf(totalScore));
        nextQuestion();


    }
    public void nextQuestion(){

        if(i< 5) {
           /* xyz = new questionInfo(quesList.get(i).getQuestionuser(), quesList.get(i).getChoice1user(), quesList.get(i).getChoice2user(), quesList.get(i).getChoice3user(), quesList.get(i).getChoice4user(), quesList.get(i).getAnsweruser());

            Log.i("message", "sagar chutiya hai 1" + quesList.get(i).getAnsweruser());

            Option1.setText(quesList.get(1).getChoice1user());
            Option3.setText(xyz.getChoice3user());
            Option2.setText(xyz.getChoice2user());
            Option4.setText(xyz.getChoice4user());
            QuestionTextView.setText(xyz.getQuestionuser());
*/
            Option1.setText(OptiononeArray[i]);
            Option2.setText(Optiontworray[i]);
            Option3.setText(OptionthreeArray[i]);
            Option4.setText(OptionfourArray[i]);
            QuestionTextView.setText(QuestionArray[i]);
            CurrentCorrectAnswer=AnswersArray[i];


            i++;

        }

    }

    public void StartTest(View view) {
        view.setVisibility(View.INVISIBLE);
        nextQuestion();

        new CountDownTimer(30 * 1000, 1000) {
            @Override
            public void onTick(long l) {
                updateTimer((int)l/1000);

            }

            @Override
            public void onFinish() {
                MediaPlayer mPlayer = MediaPlayer.create(getApplicationContext(), R.raw.airhorn);
                mPlayer.start();
                TimerTextView.setText("00:00");
                Option1.setVisibility(View.INVISIBLE);

                Option2.setVisibility(View.INVISIBLE);
                Option3.setVisibility(View.INVISIBLE);
                Option4.setVisibility(View.INVISIBLE);
                QuestionTextView.setText("Thank you for giving the test your score is "+String.valueOf(yourScore)+"/"+String.valueOf(totalScore));
                String s = String.valueOf(yourScore)+"/"+String.valueOf(totalScore);
                mMessageDatabasereference.push().setValue(s);

            }
        }.start();


    }


}
