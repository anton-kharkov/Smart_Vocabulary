package ua.intentio.smart_vocabulary.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import ua.intentio.smart_vocabulary.domain.Word;

@Dao
public interface WordDao {

    @Query("SELECT * FROM word")
    List<Word> getAll();

    @Insert
    void insert(Word word);

    @Update
    void update(Word word);

    @Delete
    void delete(Word word);
}
