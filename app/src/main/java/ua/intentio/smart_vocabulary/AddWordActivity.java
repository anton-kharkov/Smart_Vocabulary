package ua.intentio.smart_vocabulary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Database;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import ua.intentio.smart_vocabulary.domain.Word;

public class AddWordActivity extends AppCompatActivity {

    EditText word;
    EditText translation;
    TextView saveText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_word);
        ((AppDb)getApplication()).getDataBaseComponent().inject(this);

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
        }else{
            saveText.setText("Неверно заполненые поля");
            saveText.setVisibility(View.VISIBLE);
        }
    }
}