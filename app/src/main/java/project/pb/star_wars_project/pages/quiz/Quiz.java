package project.pb.star_wars_project.pages.quiz;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;
import project.pb.star_wars_project.R;
import project.pb.star_wars_project.base.BaseFragment;
import project.pb.star_wars_project.models.interfaces.models.quizz.Question;
import project.pb.star_wars_project.pages.searching.SearchingFragment;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Quiz extends BaseFragment {

    Button startButton;
    //ArrayList<Integer> answers = new ArrayList<Integer>();
    ArrayList<String> answers = new ArrayList<String>();
    TextView resultTextView;
    TextView questionTextView;
    TextView touchToKeepPlaying;
    ProgressBar progressBarAnimation;
    ObjectAnimator progressAnimator;
    Button button0;
    Button button1;
    Button button2;
    Button button3;
    Button playAgainButton;
    ImageButton imageButton0;
    ImageButton imageButton1;
    ImageButton imageButton2;
    ImageButton imageButton3;
    ImageButton imageButton4;
    ImageButton imageButton5;
    ConstraintLayout gameLayout;
    ConstraintLayout endGameLayout;
    View view2;
    int locationOfCorrectAnswer;
    int score = 0;
    int howManyGames =6; //tak serio to 6
    int iterator =0; //zlicza rozgrywki, wykorzystywany do imageButtonów
    int numberOfQuestions =0;
    int ktorepytanie=0;

    List<Questions> allQuestions;
    List<Integer> indexList;
    ArrayList<String> numberlist = new ArrayList<>();

    private static Quiz sInstance;

    public static Quiz getsInstance(){
        if(sInstance==null){
            sInstance=new Quiz();
        }
        return sInstance;
    }

    public void loadJSONFromAsset() {
        String json = null;
        allQuestions = new ArrayList<Questions>();

        try {
            InputStream is = getActivity().getAssets().open("quiz.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");

            JSONArray jsonArray = new JSONArray(json);

            for(int i=0; i<jsonArray.length();i++)
            {
                JSONObject question = jsonArray.getJSONObject(i);

                String category = question.getString("category");
                String phrase = question.getString("question");
                JSONArray answers = (JSONArray) question.get("answers");
                int correctIndex = question.getInt("correctIndex");

                ArrayList<String> answ = new ArrayList<>(4);

                for(int j=0; j<answers.length();j++)
                {
                    answ.add(answers.get(j).toString());
                }

                Questions questions = new Questions();
                questions.setCategory(category);
                questions.setQuestion(phrase);
                questions.setAnswers(answ);
                questions.setCorrectIndex(correctIndex);

                allQuestions.add(questions);
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }


    public void playAgain(){
        score =0;
        numberOfQuestions=0;
        iterator=0;
        gameLayout.setVisibility(View.VISIBLE );
        playAgainButton.setVisibility(View.INVISIBLE);
        endGameLayout.setVisibility(View.INVISIBLE);
        imageButtonScoreChange(2);
        setClickableButton(true);
        generateQuestion();
    }


    public void onFinish() {
        imageButtonScoreChange(2);
        startButton.setVisibility(View.VISIBLE);
        gameLayout.setVisibility(View.INVISIBLE);
        endGameLayout.setVisibility(View.VISIBLE);
        resultTextView.setText("Twój wynik: " + Integer.toString(score) + "/" + Integer.toString(howManyGames));
    }

    public void generateQuestion() {

        if (iterator >= howManyGames)
        {
            onFinish();
        }

        Questions q;

        Random rand = new Random();

        int randNumb = rand.nextInt(allQuestions.size());

        q=allQuestions.get(randNumb);

        questionTextView.setText(q.getQuestion());
        locationOfCorrectAnswer = q.getCorrectIndex();

        ktorepytanie++; //TODO zrob tu lepiej, losowosc pytań

        answers.clear();

        for(int i=0; i<4; i++)
        {
            answers.add(q.getAnswers().get(i));
        }



//        Random rand = new Random();
//        int a = rand.nextInt(21);
//        int b = rand.nextInt(21);
//
//        questionTextView.setText(Integer.toString(a) +" + "+ Integer.toString(b));
//
//        locationOfCorrectAnswer = rand.nextInt(4);


//
//        int incorrectAnswer;
//
//        for (int i=0; i<4; i++){
//
//            if(i == locationOfCorrectAnswer){
//                answers.add(a + b);
//            }
//            else {
//                incorrectAnswer = rand.nextInt(41);
//
//                while (incorrectAnswer == a + b)
//                {
//                    incorrectAnswer = rand.nextInt(41);
//                }
//
//                answers.add(incorrectAnswer);
//            }
//        }


        progressBarAnimation.setVisibility(View.VISIBLE);
        progressAnimator.setDuration(7000);
        progressAnimator.start();
        progressAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                progressBarAnimation.setVisibility(View.INVISIBLE);
                chooseAnswer();
            }
        });
        button0.setBackgroundResource(R.drawable.edit_round);
        button1.setBackgroundResource(R.drawable.edit_round);
        button2.setBackgroundResource(R.drawable.edit_round);
        button3.setBackgroundResource(R.drawable.edit_round);

//        button0.setText(Integer.toString(answers.get(0)));
//        button1.setText(Integer.toString(answers.get(1)));
//        button2.setText(Integer.toString(answers.get(2)));
//        button3.setText(Integer.toString(answers.get(3)));

        button0.setText(answers.get(0));
        button1.setText(answers.get(1));
        button2.setText(answers.get(2));
        button3.setText(answers.get(3));

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { chooseAnswer(button0);
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { chooseAnswer(button1);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { chooseAnswer(button2);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { chooseAnswer(button3);
            }
        });
    }


    public void chooseAnswer(){
        progressAnimator.cancel();
        progressBarAnimation.setVisibility(View.INVISIBLE);
        setClickableButton(false);
            if(button0.getTag().toString().equals(Integer.toString(locationOfCorrectAnswer)))
                button0.setBackgroundResource(R.drawable.show_correct_answer);
            else button0.setBackgroundResource(R.drawable.other_answer);

            if(button1.getTag().toString().equals(Integer.toString(locationOfCorrectAnswer)))
                button1.setBackgroundResource(R.drawable.show_correct_answer);
            else button1.setBackgroundResource(R.drawable.other_answer);

            if(button2.getTag().toString().equals(Integer.toString(locationOfCorrectAnswer)))
                button2.setBackgroundResource(R.drawable.show_correct_answer);
            else button2.setBackgroundResource(R.drawable.other_answer);

            if(button3.getTag().toString().equals(Integer.toString(locationOfCorrectAnswer)))
                button3.setBackgroundResource(R.drawable.show_correct_answer);
            else button3.setBackgroundResource(R.drawable.other_answer);

        touchToKeepPlaying.setVisibility(View.VISIBLE);
        touchToKeepPlaying.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iterator++;
                setClickableButton(true);
                generateQuestion();
                touchToKeepPlaying.setVisibility(View.INVISIBLE);
            }
        });
    }

    public void chooseAnswer(Button button){

        progressAnimator.cancel();
        progressBarAnimation.setVisibility(View.INVISIBLE);

        if(button.getTag().toString().equals(Integer.toString(locationOfCorrectAnswer))){
            imageButtonScoreChange(0);
            button.setBackgroundResource(R.drawable.correct_answer);
            if(!(button0.getTag().toString().equals(Integer.toString(locationOfCorrectAnswer))))
                button0.setBackgroundResource(R.drawable.other_answer);
            if(!(button1.getTag().toString().equals(Integer.toString(locationOfCorrectAnswer))))
                button1.setBackgroundResource(R.drawable.other_answer);
            if(!(button2.getTag().toString().equals(Integer.toString(locationOfCorrectAnswer))))
                button2.setBackgroundResource(R.drawable.other_answer);
            if(!(button3.getTag().toString().equals(Integer.toString(locationOfCorrectAnswer))))
                button3.setBackgroundResource(R.drawable.other_answer);
            score ++ ;

        } else {
            imageButtonScoreChange(1);
            button.setBackgroundResource(R.drawable.incorrect_answer);
            if(button!=button0)
            {
                if(button0.getTag().toString().equals(Integer.toString(locationOfCorrectAnswer)))
                    button0.setBackgroundResource(R.drawable.show_correct_answer);
                else button0.setBackgroundResource(R.drawable.other_answer);
            }

            if(button!=button1)
            {
                if(button1.getTag().toString().equals(Integer.toString(locationOfCorrectAnswer)))
                    button1.setBackgroundResource(R.drawable.show_correct_answer);
                else button1.setBackgroundResource(R.drawable.other_answer);
            }

            if(button!=button2)
            {
                if(button2.getTag().toString().equals(Integer.toString(locationOfCorrectAnswer)))
                    button2.setBackgroundResource(R.drawable.show_correct_answer);
                else button2.setBackgroundResource(R.drawable.other_answer);
            }

            if(button!=button3)
            {
                if(button3.getTag().toString().equals(Integer.toString(locationOfCorrectAnswer)))
                    button3.setBackgroundResource(R.drawable.show_correct_answer);
                else button3.setBackgroundResource(R.drawable.other_answer);
            }

        }
        setClickableButton(false);
        touchToKeepPlaying.setVisibility(View.VISIBLE);
        touchToKeepPlaying.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iterator++;
                generateQuestion();
                setClickableButton(true);
                touchToKeepPlaying.setVisibility(View.INVISIBLE);
            }
        });

        numberOfQuestions ++;
    }

    public void imageButtonScoreChange(int pointer){

        if(pointer==0)
        {
            if(iterator == 0)imageButton0.setBackgroundResource(R.drawable.white_green_r2);
            if(iterator == 1)imageButton1.setBackgroundResource(R.drawable.white_green_r2);
            if(iterator == 2)imageButton2.setBackgroundResource(R.drawable.white_green_r2);
            if(iterator == 3)imageButton3.setBackgroundResource(R.drawable.white_green_r2);
            if(iterator == 4)imageButton4.setBackgroundResource(R.drawable.white_green_r2);
            if(iterator == 5)imageButton5.setBackgroundResource(R.drawable.white_green_r2);
        }
        if(pointer==1)
        {
            if(iterator == 0)imageButton0.setBackgroundResource(R.drawable.white_red_r2);
            if(iterator == 1)imageButton1.setBackgroundResource(R.drawable.white_red_r2);
            if(iterator == 2)imageButton2.setBackgroundResource(R.drawable.white_red_r2);
            if(iterator == 3)imageButton3.setBackgroundResource(R.drawable.white_red_r2);
            if(iterator == 4)imageButton4.setBackgroundResource(R.drawable.white_red_r2);
            if(iterator == 5)imageButton5.setBackgroundResource(R.drawable.white_red_r2);
        }
        if(pointer==2)
        {
            imageButton0.setBackgroundResource(R.drawable.white_transparent_r2);
            imageButton1.setBackgroundResource(R.drawable.white_transparent_r2);
            imageButton2.setBackgroundResource(R.drawable.white_transparent_r2);
            imageButton3.setBackgroundResource(R.drawable.white_transparent_r2);
            imageButton4.setBackgroundResource(R.drawable.white_transparent_r2);
            imageButton5.setBackgroundResource(R.drawable.white_transparent_r2);
        }

    }

    public void setClickableButton(boolean temp){
        if(temp) {
            button0.setClickable(true);
            button1.setClickable(true);
            button2.setClickable(true);
            button3.setClickable(true);
        } else {
            button0.setClickable(false);
            button1.setClickable(false);
            button2.setClickable(false);
            button3.setClickable(false);

        }

    }
    @Nullable
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.quiz_layout, container, false);
    }
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view2 = view;
        startButton = getView().findViewById(R.id.startButton);
        questionTextView = getView().findViewById(R.id.questionTextView);

        button0 = getView().findViewById(R.id.button0);
        button1 = getView().findViewById(R.id.button1);
        button2 = getView().findViewById(R.id.button2);
        button3 = getView().findViewById(R.id.button3);

        imageButton0 = getView().findViewById(R.id.r2_d2_button0);
        imageButton1 = getView().findViewById(R.id.r2_d2_button1);
        imageButton2 = getView().findViewById(R.id.r2_d2_button2);
        imageButton3 = getView().findViewById(R.id.r2_d2_button3);
        imageButton4 = getView().findViewById(R.id.r2_d2_button4);
        imageButton5 = getView().findViewById(R.id.r2_d2_button5);

        resultTextView= getView().findViewById(R.id.resultTextView);
        gameLayout =getView().findViewById(R.id.gameLayout);
        endGameLayout=getView().findViewById(R.id.endGameLayout);
        playAgainButton = getView().findViewById(R.id.playAgainButton);
        touchToKeepPlaying = getView().findViewById(R.id.keepPlayingTextView);
        progressBarAnimation = getView().findViewById(R.id.progressBar);
        progressAnimator = ObjectAnimator.ofInt(progressBarAnimation,"progress", 100, 0);

        loadJSONFromAsset();

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startButton.setVisibility(View.INVISIBLE);
                gameLayout.setVisibility(ConstraintLayout.VISIBLE);
                playAgain();
            }
        });


    }
}
