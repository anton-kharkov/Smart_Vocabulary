package ua.intentio.smart_vocabulary.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ua.intentio.smart_vocabulary.R;
import ua.intentio.smart_vocabulary.domain.Word;

public class CustomListAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater layoutInflater;
    private List<Word> wordList;

    public CustomListAdapter(Context context, List<Word> wordList) {
        this.context = context;
        this.wordList = wordList;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return wordList.size();
    }

    @Override
    public Object getItem(int position) {
        return wordList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
