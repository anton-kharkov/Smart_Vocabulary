package ua.intentio.smart_vocabulary;

import android.app.Application;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.room.Room;

import ua.intentio.smart_vocabulary.db.AppDataBase;

public class AppDb extends Application {

    public static AppDb instance;

    public AppDataBase dataBase;


    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;

        dataBase = Room.databaseBuilder(this, AppDataBase.class, "database")
                .build();
    }

    public static AppDb getInstance(){
        return instance;
    }

    public AppDataBase getDataBase(){
        return dataBase;
    }
}
