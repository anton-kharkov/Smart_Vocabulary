package ua.intentio.smart_vocabulary.domain;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Word {

    @PrimaryKey
    private int id;

    private String foreign_word;

    private String translate;

}
