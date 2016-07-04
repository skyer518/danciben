package cn.com.u2be.danciben.persenter;

import android.util.Log;

import java.util.List;

import cn.com.u2be.danciben.entity.Word;
import cn.com.u2be.danciben.model.WordModel;
import cn.com.u2be.danciben.model.impl.WordModelSQLiteImpl;
import cn.com.u2be.danciben.view.WordsView;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by alek on 2016/6/29.
 */
public class WordPersenter implements Persenter<WordsView> {

    private WordModel wordModel = new WordModelSQLiteImpl();


    public void LoadWords(final WordsView view) {
        Observable.just(Word.class)
                .map(new Func1<Class<Word>, List<Word>>() {
                    @Override
                    public List<Word> call(Class<Word> wordClass) {
                        Log.i("cccc", Thread.currentThread().getName());
                        return wordModel.getAllWords();
                    }
                })
                .subscribeOn(Schedulers.io()) // 后台线程取数据
                .observeOn(AndroidSchedulers.mainThread()) // 主线程显示数据
                .subscribe(new Action1<List<Word>>() {
                    @Override
                    public void call(List<Word> words) {
                        Log.i("dddd", Thread.currentThread().getName());
                        if (words != null) {
                            view.showData(words);
                        }
                    }
                });


    }

    @Override
    public void onViewAttached(WordsView view) {

    }

    @Override
    public void onViewDetached() {

    }

    @Override
    public void onDestory() {

    }
}
