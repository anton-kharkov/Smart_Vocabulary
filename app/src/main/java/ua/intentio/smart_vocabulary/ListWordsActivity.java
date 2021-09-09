package ua.intentio.smart_vocabulary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

import ua.intentio.smart_vocabulary.adapter.CustomListAdapter;
import ua.intentio.smart_vocabulary.dao.WordDao;
import ua.intentio.smart_vocabulary.db.AppDataBase;
import ua.intentio.smart_vocabulary.domain.Word;

public class ListWordsActivity extends AppCompatActivity {

    AppDataBase dataBase;
    WordDao wordDao;

    ListView listView;
    List<Word> dbWordList;
    CustomListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_words);

        dataBase = AppDb.getInstance().getDataBase();
        wordDao = dataBase.wordDao();

        dbWordList = wordDao.getAll();

        listView = findViewById(R.id.wordList);

        adapter = new CustomListAdapter(this, dbWordList);

        listView.setAdapter(adapter);
    }
}