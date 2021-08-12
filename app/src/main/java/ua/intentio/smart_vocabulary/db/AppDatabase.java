package ua.intentio.smart_vocabulary.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import ua.intentio.smart_vocabulary.dao.WordDao;
import ua.intentio.smart_vocabulary.domain.Word;

@Database(entities = {Word.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract WordDao wordDao();
}
