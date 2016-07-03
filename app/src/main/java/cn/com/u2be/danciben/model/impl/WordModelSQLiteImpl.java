package cn.com.u2be.danciben.model.impl;

import org.xutils.DbManager;
import org.xutils.ex.DbException;
import org.xutils.x;

import java.util.List;

import cn.com.u2be.danciben.Const;
import cn.com.u2be.danciben.entity.Word;
import cn.com.u2be.danciben.model.WordModel;

/**
 * Created by 明 on 2016/7/3.
 */
public class WordModelSQLiteImpl implements WordModel {

    private DbManager db;

    public WordModelSQLiteImpl() {
        db = x.getDb(Const.getInstance().getDaoConfig());
    }


    @Override
    public List<Word> getAllWords() {
        try {
            return db.findAll(Word.class);
        } catch (DbException e) {
            return null;
        }
    }

    @Override
    public List<Word> getReviseWords() {
        try {
            return db.findAll(Word.class);
        } catch (DbException e) {
            return null;
        }
    }

    @Override
    public List<Word> getWordsByGroupId() {
        try {
            return db.findAll(Word.class);
        } catch (DbException e) {
            return null;
        }
    }

    @Override
    public void saveWord(Word word) {
        try {
            db.save(word);
        } catch (DbException e) {
            e.printStackTrace();
        }
    }
}
