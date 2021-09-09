package ua.intentio.smart_vocabulary.domain;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Word {

    @PrimaryKey(autoGenerate = true)
    public Integer id;

    public String foreign_word;

    public String translate;


}
