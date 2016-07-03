package cn.com.u2be.danciben.persenter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import cn.com.u2be.danciben.entity.Word;
import cn.com.u2be.danciben.model.WordModel;
import cn.com.u2be.danciben.model.impl.WordModelSQLiteImpl;
import cn.com.u2be.danciben.paser.PullWordsParser;
import cn.com.u2be.danciben.paser.WordsParser;
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
                        return wordModel.getAllWords();
                    }
                })
                .observeOn(Schedulers.newThread())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<List<Word>>() {
                    @Override
                    public void call(List<Word> words) {
                        if (words != null)
                            view.showData(words);
                    }
                });
//        String filename = "/assets/word.xml";
//        Observable.just(filename)
//                .map(new Func1<String, List<Word>>() {
//                    @Override
//                    public List<Word> call(String filename) {
//                        InputStream stream = null;
//                        try {
//                            stream = getClass().getResourceAsStream(filename);
//                            WordsParser parser = new PullWordsParser();
//                            return parser.parse(stream);
//                        } catch (FileNotFoundException e) {
//                            e.printStackTrace();
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                        } finally {
//                            if (stream != null) {
//                                try {
//                                    stream.close();
//                                } catch (IOException e) {
//                                    e.printStackTrace();
//                                }
//                            }
//                        }
//                        return null;
//                    }
//                })
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Action1<List<Word>>() {
//                    @Override
//                    public void call(List<Word> words) {
//                        wiew.showData(words);
//                    }
//                });


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
