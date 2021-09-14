package ua.intentio.smart_vocabulary.domain;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Word {

    @PrimaryKey(autoGenerate = true)
    private Integer id;

    private String foreign_word;

    private String translate;

    public Integer getId() {
        return id;
    }

    public String getForeign_word() {
        return foreign_word;
    }

    public String getTranslate() {
        return translate;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setForeign_word(String foreign_word) {
        this.foreign_word = foreign_word;
    }

    public void setTranslate(String translate) {
        this.translate = translate;
    }
}
