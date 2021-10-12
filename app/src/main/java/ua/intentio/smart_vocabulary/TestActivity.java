package ua.intentio.smart_vocabulary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import ua.intentio.smart_vocabulary.dao.WordDao;
import ua.intentio.smart_vocabulary.db.AppDataBase;
import ua.intentio.smart_vocabulary.domain.Word;

public class TestActivity extends AppCompatActivity {

    TextView textView;
    Button leftButton1;
    Button leftButton2;
    Button rightButton1;
    Button rightButton2;

    List<Integer> numberList;
    List<String> translateList;

    Word wordMain;

    Thread thread;
    Thread threadAnswer;
    AppDataBase dataBase;
    WordDao wordDao;
    List<Word> wordList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        dataBase = AppDb.instance.getDataBase();
        wordDao = dataBase.wordDao();

        textView = findViewById(R.id.textView);
        leftButton1 = findViewById(R.id.leftButton1);
        leftButton2 = findViewById(R.id.leftButton2);
        rightButton1 = findViewById(R.id.rightButton1);
        rightButton2 = findViewById(R.id.rightButton2);
    }

    @Override
    protected void onStart() {

        super.onStart();

        thread = new Thread(() ->{

            boolean choiceTypeTest;
            boolean flag = true;

            Random random = new Random();

            numberList = new ArrayList<>();
            translateList = new ArrayList<>();

            wordList = wordDao.getAll();

            while (flag){

                Word word_2, word_3, word_4;
                String mainWord, mainTranslate, translate_2, translate_3, translate_4;
                int bound = wordList.size();

                numberList = randomNumberList(random, bound);

                wordMain = wordList.get(numberList.get(0));
                word_2 = wordList.get(numberList.get(1));
                word_3 = wordList.get(numberList.get(2));
                word_4 = wordList.get(numberList.get(3));

                numberList.clear();

                choiceTypeTest = random.nextBoolean();

                if (choiceTypeTest){
                    mainWord = wordMain.getForeign_word();

                    mainTranslate = wordMain.getTranslate();
                    translate_2 = word_2.getTranslate();
                    translate_3 = word_3.getTranslate();
                    translate_4 = word_4.getTranslate();

                }else {
                    mainWord = wordMain.getTranslate();

                    mainTranslate = wordMain.getForeign_word();
                    translate_2 = word_2.getForeign_word();
                    translate_3 = word_3.getForeign_word();
                    translate_4 = word_4.getForeign_word();
                }

                translateList.addAll(Arrays.asList(mainTranslate, translate_2,
                        translate_3, translate_4));

                numberList = randomNumberList(random, 4);


                runOnUiThread(() ->{

                    textView.setText(mainWord);
                    leftButton1.setText(translateList.get(numberList.get(0)));
                    leftButton2.setText(translateList.get(numberList.get(1)));
                    rightButton1.setText(translateList.get(numberList.get(2)));
                    rightButton2.setText(translateList.get(numberList.get(3)));

                    leftButton1.setClickable(true);
                    leftButton2.setClickable(true);
                    rightButton1.setClickable(true);
                    rightButton2.setClickable(true);

                    numberList.clear();
                    translateList.clear();
                });

                flag = false;
            }
            thread.interrupt();
        });

        thread.start();
    }

    public void onButtonClick(View view) {

        String answer;

        Button answerButton = (Button) view;

        answer = answerButton.getText().toString();

        leftButton1.setClickable(false);
        leftButton2.setClickable(false);
        rightButton1.setClickable(false);
        rightButton2.setClickable(false);

        if (answer.equals(wordMain.getForeign_word()) || answer.equals(wordMain.getTranslate())){
            answerButton.setBackgroundTintList(getResources().getColorStateList(R.color.green));

            threadAnswer = new Thread(()->{
                try {
                    Thread.sleep(1000);

                    answerButton.setBackgroundTintList(getResources().getColorStateList(R.color.orange));

                    thread.run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }else {
            answerButton.setBackgroundTintList(getResources().getColorStateList(R.color.red));

            threadAnswer = new Thread(()->{
                try {
                    Thread.sleep(1000);

                    answerButton.setBackgroundTintList(getResources().getColorStateList(R.color.orange));

                    thread.run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        threadAnswer.start();
    }

    private List<Integer> randomNumberList(Random random, int bound) {
        Integer number_1;
        Integer number_2;
        Integer number_3;
        Integer number_4;

        number_1 = random.nextInt(bound);

        do {
            number_2 = random.nextInt(bound);
        }while(number_2.equals(number_1));

        do{
            number_3 = random.nextInt(bound);
        }while (number_1.equals(number_3) || number_2.equals(number_3));

        do{
            number_4 = random.nextInt(bound);
        }while (number_4.equals(number_1) || number_4.equals(number_2)
                || number_4.equals(number_3));

        return new ArrayList<>(Arrays.asList(number_1, number_2, number_3, number_4));
    }
}