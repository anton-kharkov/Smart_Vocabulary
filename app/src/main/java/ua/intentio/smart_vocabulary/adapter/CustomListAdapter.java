package ua.intentio.smart_vocabulary.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import ua.intentio.smart_vocabulary.R;
import ua.intentio.smart_vocabulary.dao.WordDao;
import ua.intentio.smart_vocabulary.domain.Word;

public class CustomListAdapter extends BaseAdapter {

    private final LayoutInflater inflater;
    private final WordDao wordDao;
    private final int layout;
    private int number = 0;
    private final List<Word> wordList;

    public CustomListAdapter(Context context, int layout, WordDao wordDao) {
        this.layout = layout;
        this.wordDao = wordDao;
        inflater = LayoutInflater.from(context);

        wordList = wordDao.getAll();
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

        @SuppressLint("ViewHolder") View view = inflater.inflate(layout, parent, false);

        TextView idView = view.findViewById(R.id.textView_numbering);
        TextView wordView = view.findViewById(R.id.textView_word);
        TextView translationView = view.findViewById(R.id.textView_translate);
        Button buttonDelete = view.findViewById(R.id.buttonDelete);

        Word word = wordList.get(position);

        number ++;

        idView.setText(String.valueOf(number));
        wordView.setText(word.getForeign_word());
        translationView.setText(word.getTranslate());

        buttonDelete.setOnClickListener(view1 -> {

            Thread thread = new Thread(()->{
                wordList.remove(position);
                wordDao.delete(word);
            });

            thread.start();
            number = 0;
            notifyDataSetChanged();
            thread.interrupt();
        });

        return view;
    }


}
