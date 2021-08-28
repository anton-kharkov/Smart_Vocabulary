package ua.intentio.smart_vocabulary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import ua.intentio.smart_vocabulary.dao.WordDao;
import ua.intentio.smart_vocabulary.db.AppDataBase;

public class ListWordsActivity extends AppCompatActivity {

    AppDataBase dataBase;
    WordDao wordDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_words);

        dataBase = AppDb.getInstance().getDataBase();
        wordDao = dataBase.wordDao();


    }
}