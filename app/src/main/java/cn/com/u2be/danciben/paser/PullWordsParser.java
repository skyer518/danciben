package cn.com.u2be.danciben.paser;

import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import cn.com.u2be.danciben.entity.Word;

/**
 * Created by alek on 2016/6/29.
 */
public class PullWordsParser implements WordsParser {

    @Override
    public List<Word> parse(InputStream in) throws Exception {

        List<Word> words = null;
        Word word = null;

        XmlPullParser xmlPullParser = Xml.newPullParser();
        xmlPullParser.setInput(in, "utf-8");

        int eventType = xmlPullParser.getEventType();
        while (eventType != xmlPullParser.END_DOCUMENT) {

            switch (eventType) {
                case XmlPullParser.START_DOCUMENT:
                    words = new ArrayList<>(0);
                    break;
                case XmlPullParser.START_TAG:

                    final String tagName = xmlPullParser.getName();
                    if ("item".equals(tagName)) {
                        word = new Word();
                    } else if ("word".equals(tagName)) {
                        xmlPullParser.next();
                        word.setWord(xmlPullParser.getText());
                    } else if ("trans".equals(tagName)) {
                        xmlPullParser.next();
                        word.setTrans(xmlPullParser.getText());
                    } else if ("phonetic".equals(tagName)) {
                        xmlPullParser.next();
                        word.setPhonetic(xmlPullParser.getText());
                    } else if ("tags".equals(tagName)) {
                        xmlPullParser.next();
                        word.setTags(xmlPullParser.getText());
                    } else if ("progress".equals(tagName)) {
                        xmlPullParser.next();
                        word.setProgress(Integer.parseInt(xmlPullParser.getText()));
                    }
                    break;

                case XmlPullParser.END_TAG:
                    if ("item".equals(xmlPullParser.getName())) {
                        words.add(word);
                        word = null;
                    }
                    break;
            }
            eventType = xmlPullParser.next();
        }

        return words;
    }

    @Override
    public String serialize(List<Word> words) throws Exception {
        return null;
    }

}
