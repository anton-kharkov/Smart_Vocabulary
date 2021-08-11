package ua.intentio.smart_vocabulary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.time.Instant;

public class MainActivity extends AppCompatActivity {

    Button testBtn;
    Button addWordBtn;
    Button listWordsBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        testBtn = (Button) findViewById(R.id.testButton);
        addWordBtn = (Button) findViewById(R.id.addWordBtn);
        listWordsBtn = (Button) findViewById(R.id.listWordsBtn);
    }

    public void goToTestActivity(){
        testBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TestActivity.class);
                startActivity(intent);
            }
        });
    }

    public void goToAddWordActivity(){
        addWordBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddWordActivity.class);
                startActivity(intent);
            }
        });
    }

    public void goToListWordsActivity(){
        listWordsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ListWordsActivity.class);
                startActivity(intent);
            }
        });
    }
}