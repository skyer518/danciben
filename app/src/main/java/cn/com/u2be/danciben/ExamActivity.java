package cn.com.u2be.danciben;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import cn.com.u2be.danciben.entity.Word;
import cn.com.u2be.danciben.view.ExamView;

public class ExamActivity extends BaseActivity implements ExamView {

    private ViewHolder holder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam);
        holder = new ViewHolder(this);
    }

    @Override
    public void showWord(Word word) {

    }

    static class ViewHolder {
        @InjectView(R.id.tv_Word)
        TextView tvWord;
        @InjectView(R.id.tv_phonePic)
        TextView tvPhonePic;
        @InjectView(R.id.btn_show_trans)
        Button btnShowTrans;
        @InjectView(R.id.tv_Trans)
        TextView tvTrans;
        @InjectView(R.id.tv_position)
        TextView tvPosition;
        @InjectView(R.id.tv_sum)
        TextView tvSum;
        @InjectView(R.id.tv_remember)
        Button tvRemember;
        @InjectView(R.id.tv_forgot)
        Button tvForgot;

        ViewHolder(ExamActivity activity) {
            ButterKnife.inject(this, activity);
        }
    }
}
