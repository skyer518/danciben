package cn.com.u2be.danciben.model;

import java.util.List;

import cn.com.u2be.danciben.entity.Word;

/**
 * Created by 明 on 2016/7/3.
 */
public interface WordModel {

    List<Word> getAllWords();

    List<Word> getReviseWords();

    List<Word> getWordsByGroupId();


    void saveWord(Word word);


}
