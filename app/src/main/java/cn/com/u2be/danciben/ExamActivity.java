package cn.com.u2be.danciben;

import android.os.Bundle;

import cn.com.u2be.danciben.entity.Word;
import cn.com.u2be.danciben.view.ExamView;

public class ExamActivity extends BaseActivity implements ExamView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam);
    }

    @Override
    public void showWord(Word word) {

    }
}
