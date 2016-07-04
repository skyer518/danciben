package me.seewhy.indexableRecyclerView;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import cn.com.u2be.danciben.R;
import cn.com.u2be.danciben.entity.Word;

public class IndexableRecyclerViewAdapter extends RecyclerView.Adapter implements SectionedRecyclerAdapter.SectionedRecyclerDelegate {
    public static final String TAG = "IndexableRecyclerViewAdapter";
    public static final int TYPE_BANNER = 0;
    private final LayoutInflater mLayoutInflater;

    public void setmWords(List<Word> mWords) {
        this.mWords = mWords;
    }

    private List<Word> mWords;
    private int mLineNumber = 0;
    LinkedHashMap<String, List<Word>> mSectionedHashMap;


    public IndexableRecyclerViewAdapter(Context context, List<Word> models) {
        mWords = models;
        mLayoutInflater = LayoutInflater.from(context);
        init();
    }

    private void init() {

        Log.i("eeee", "init");
        mSectionedHashMap = new LinkedHashMap<>();
        Collections.sort(mWords);
        mSections.clear();
        for (int i = 0; i < mWords.size(); i++) {
            String ch = HanziToPinyin.getFirstPinYinChar(mWords.get(i).getWord());
            if (ch == null || ch.isEmpty() || !Character.isUpperCase(ch.codePointAt(0)))
                ch = "#";
            List<Word> itemModels = mSectionedHashMap.get(ch);
            if (itemModels == null) {
                itemModels = new ArrayList<>();
            }
            itemModels.add(mWords.get(i));
            mSectionedHashMap.put(ch, itemModels);
        }
        calculateSectionPosition();
    }

    private void calculateSectionPosition() {
        Set<String> keySet = mSectionedHashMap.keySet();
        String strings[] = new String[keySet.size()];
        keySet.toArray(strings);
        Arrays.sort(strings);
        int pos = 0;
        for (String title : strings) {
            SectionedRecyclerAdapter.Section section = new SectionedRecyclerAdapter.Section(pos, title);
            mSections.add(section);
            pos += mSectionedHashMap.get(title).size();
        }

        Log.i("eeee", "calculateSectionPosition");
        mLineNumber = pos;
    }

    @Override
    public List<SectionedRecyclerAdapter.Section> getSections() {

        Log.i("eeee", "getSections");
        return mSections;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new BannerViewHolder(mLayoutInflater.inflate(R.layout.recycler_item, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((BannerViewHolder) holder).tvWord.setText(mWords.get(position).getWord());
        ((BannerViewHolder) holder).tvTrans.setText(mWords.get(position).getTrans());
    }

    @Override
    public int getItemCount() {

        Log.i("eeee", "getItemCount");
        return mLineNumber;
    }

    @Override
    public int getItemViewType(int position) {
        return TYPE_BANNER;
    }

    public static class BannerViewHolder extends RecyclerView.ViewHolder {
        TextView tvWord, tvTrans;

        public BannerViewHolder(View itemView) {
            super(itemView);
            tvWord = (TextView) itemView.findViewById(R.id.tv_Word);
            tvTrans = (TextView) itemView.findViewById(R.id.tv_Trans);
        }
    }
}


