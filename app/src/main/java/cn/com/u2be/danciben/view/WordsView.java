package cn.com.u2be.danciben.view;

import java.util.List;

import cn.com.u2be.danciben.entity.Word;

/**
 * Created by alek on 2016/6/29.
 * 单词列表视图
 */
public interface WordsView extends View {

    void showData(List<Word> words);

}
