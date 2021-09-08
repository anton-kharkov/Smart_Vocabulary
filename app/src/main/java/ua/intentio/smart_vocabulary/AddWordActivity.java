package ua.intentio.smart_vocabulary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import ua.intentio.smart_vocabulary.dao.WordDao;
import ua.intentio.smart_vocabulary.db.AppDataBase;
import ua.intentio.smart_vocabulary.domain.Word;

public class AddWordActivity extends AppCompatActivity {

    AppDataBase dataBase;
    WordDao wordDao;
    Thread thread;

    EditText word;
    EditText translation;
    TextView saveText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_word);

        dataBase = AppDb.getInstance().getDataBase();
        wordDao = dataBase.wordDao();

        word = (EditText) findViewById(R.id.word);
        translation = (EditText) findViewById(R.id.translation);
        saveText = (TextView) findViewById(R.id.saveText);
    }

    public void saveWordToDb(View view){

        String editWord = word.getText().toString();
        String editTranslation = translation.getText().toString();

        if(!editWord.isEmpty() && !editTranslation.isEmpty()
                && !editWord.trim().isEmpty() && !editTranslation.trim().isEmpty()){

            Word addWord = new Word();

            addWord.foreign_word = editWord;
            addWord.translate = editTranslation;

            saveText.setText("Сохранено");
            saveText.setVisibility(View.VISIBLE);

            thread = new Thread(new Runnable() {
                @Override
                public void run() {

                    wordDao.insert(addWord);

                    try {
                        Thread.sleep(1000);

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                saveText.setVisibility(View.INVISIBLE);
                            }
                        });
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });

        }else{
            saveText.setText("Неверно заполненые поля");
            saveText.setVisibility(View.VISIBLE);
        }
    }
}