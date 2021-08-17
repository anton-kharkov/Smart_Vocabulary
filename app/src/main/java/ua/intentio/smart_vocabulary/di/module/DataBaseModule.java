package ua.intentio.smart_vocabulary.di.module;

import android.content.Context;

import androidx.room.Room;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ua.intentio.smart_vocabulary.db.AppDataBase;
import ua.intentio.smart_vocabulary.domain.Word;


@Module
public class DataBaseModule{

    Context context;

    public DataBaseModule(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    public AppDataBase getDb(){
        return Room.databaseBuilder(context, AppDataBase.class, "database").build();
    }
}
