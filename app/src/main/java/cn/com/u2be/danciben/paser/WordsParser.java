package cn.com.u2be.danciben.paser;

import java.io.InputStream;
import java.util.List;

import cn.com.u2be.danciben.entity.Word;

/**
 * Created by alek on 2016/6/29.
 */
public interface WordsParser {
    /**
     * 解析 单词
     *
     * @param is 文件流
     * @return
     * @throws Exception
     */
    List<Word> parse(InputStream is) throws Exception;

    /**
     * 序列化
     *
     * @param words 单词列表
     * @return
     * @throws Exception
     */
    String serialize(List<Word> words) throws Exception;

}
