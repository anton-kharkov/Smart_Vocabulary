package ua.intentio.smart_vocabulary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

import ua.intentio.smart_vocabulary.adapter.CustomListAdapter;
import ua.intentio.smart_vocabulary.dao.WordDao;
import ua.intentio.smart_vocabulary.db.AppDataBase;
import ua.intentio.smart_vocabulary.domain.Word;

public class WordsListActivity extends AppCompatActivity {

    ListView listView;

    CustomListAdapter adapter;
    Thread thread;
    AppDataBase dataBase;
    WordDao wordDao;
    List<Word> wordList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_words_list);

        dataBase = AppDb.instance.getDataBase();
        wordDao = dataBase.wordDao();

        listView = findViewById(R.id.listView);

        thread = new Thread(() -> {
            wordList = wordDao.getAll();

            adapter = new CustomListAdapter(this, R.layout.list_word_layout, wordDao);

            runOnUiThread(() ->{
                listView.setAdapter(adapter);
            });

            thread.interrupt();
        });

        thread.start();
    }
}