package ua.intentio.smart_vocabulary.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import ua.intentio.smart_vocabulary.R;
import ua.intentio.smart_vocabulary.domain.Word;

public class CustomListAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater;
    private int layout;
    private List<Word> wordList;

    public CustomListAdapter(Context context, int layout, List<Word> wordList) {
        this.context = context;
        this.layout = layout;
        this.wordList = wordList;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return wordList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = inflater.inflate(layout, parent, false);

        TextView idView = view.findViewById(R.id.number);
        TextView wordView = view.findViewById(R.id.word);
        TextView translationView = view.findViewById(R.id.translation);

        Word word = wordList.get(position);

        idView.setText(String.valueOf(word.getId()));
        wordView.setText(word.getForeign_word());
        translationView.setText(word.getTranslate());

        return view;
    }


}
