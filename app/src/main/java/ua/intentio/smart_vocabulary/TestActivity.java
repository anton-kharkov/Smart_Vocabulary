package ua.intentio.smart_vocabulary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

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

    Thread thread;
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

        int mainRandomNumber = 0;

        super.onStart();

        thread = new Thread(() ->{
            wordList = wordDao.getAll();

             Random random = new Random();

             //mainRandomNumber = random.nextInt(wordList.size());

            Word mainWord = wordList.get(mainRandomNumber);


            thread.interrupt();
        });

        thread.start();
    }
}