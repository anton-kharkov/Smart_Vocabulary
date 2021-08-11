package ua.intentio.smart_vocabulary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AddWordActivity extends AppCompatActivity {

    EditText word;
    EditText translation;
    Button saveWord;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_word);

        word = (EditText) findViewById(R.id.word);
        translation = (EditText) findViewById(R.id.translation);
        saveWord = (Button) findViewById(R.id.saveWord);
    }

    public void saveWordToDb(){
        saveWord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}