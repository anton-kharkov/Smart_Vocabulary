package ua.intentio.smart_vocabulary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.List;

import ua.intentio.smart_vocabulary.dao.WordDao;
import ua.intentio.smart_vocabulary.db.AppDataBase;
import ua.intentio.smart_vocabulary.domain.Word;

public class MainActivity extends AppCompatActivity {

    AppDataBase dataBase;
    WordDao wordDao;
    List<Word> wordList;
    Thread thread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dataBase = AppDb.instance.getDataBase();
        wordDao = dataBase.wordDao();

        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();

        thread = new Thread(()->{
            wordList = wordDao.getAll();
            thread.interrupt();
        });

        thread.start();
    }

    public void goToTestActivity(View view){
        if (wordList.size() <= 3){
            Intent intent = new Intent(MainActivity.this, AddWordActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slidein, R.anim.slideout);
        }else {
            Intent intent = new Intent(MainActivity.this, TestActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slidein, R.anim.slideout);
        }
    }

    public void goToAddWordActivity(View view){
        Intent intent = new Intent(MainActivity.this, AddWordActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slidein, R.anim.slideout);
    }

    public void goToWordsListActivity(View view){
        Intent intent = new Intent(MainActivity.this, WordsListActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slidein, R.anim.slideout);
    }
}