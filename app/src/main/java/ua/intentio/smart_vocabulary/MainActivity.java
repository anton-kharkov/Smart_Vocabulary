package ua.intentio.smart_vocabulary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.time.Instant;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToTestActivity(View view){
        Intent intent = new Intent(MainActivity.this, TestActivity.class);
        startActivity(intent);
    }

    public void goToAddWordActivity(View view){
        Intent intent = new Intent(MainActivity.this, AddWordActivity.class);
        startActivity(intent);

    }

    public void goToListWordsActivity(View view){
        Intent intent = new Intent(MainActivity.this, ListWordsActivity.class);
        startActivity(intent);
    }
}