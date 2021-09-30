package ua.intentio.smart_vocabulary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ua.intentio.smart_vocabulary.dao.WordDao;
import ua.intentio.smart_vocabulary.db.AppDataBase;
import ua.intentio.smart_vocabulary.domain.Word;

public class AddWordActivity extends AppCompatActivity {

    AppDataBase dataBase;
    WordDao wordDao;
    Thread thread;
    Thread checkThread;
    List<Word> wordList;

    EditText word;
    EditText translation;
    TextView saveText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_word);

        dataBase = AppDb.getInstance().getDataBase();
        wordDao = dataBase.wordDao();
        List<Word> wordList = new ArrayList<>();

        word = findViewById(R.id.word);
        translation = findViewById(R.id.translation);
        saveText = findViewById(R.id.saveText);
    }

    @Override
    protected void onStart() {
        super.onStart();

        checkThread = new Thread(()->{
            wordList = wordDao.getAll();

            if (wordList.size() <= 3) {
                int wordCount = wordList.size();
                String showText = "Добавте " + (4 - wordCount);

                runOnUiThread(()->{
                    saveText.setText(showText);
                    saveText.setVisibility(View.VISIBLE);
                });
            }
            checkThread.interrupt();
        });

        checkThread.start();
    }

    public void saveWordToDb(View view){

        String editWord = word.getText().toString();
        String editTranslation = translation.getText().toString();

        if(!editWord.isEmpty() && !editTranslation.isEmpty()
                && !editWord.trim().isEmpty() && !editTranslation.trim().isEmpty()){

            Word addWord = new Word();

            addWord.setForeign_word(editWord);
            addWord.setTranslate(editTranslation);

            saveText.setText("Сохранено");
            saveText.setVisibility(View.VISIBLE);

            thread = new Thread(() -> {
                wordDao.insert(addWord);

                try {
                    Thread.sleep(500);

                    runOnUiThread(() -> {
                        saveText.setVisibility(View.INVISIBLE);
                        word.setText("");
                        translation.setText("");
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                thread.interrupt();
            });

            thread.start();

        }else{
            saveText.setText("Неверно заполненые поля");
            saveText.setVisibility(View.VISIBLE);
        }
    }
}