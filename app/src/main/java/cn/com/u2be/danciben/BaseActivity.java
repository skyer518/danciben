package cn.com.u2be.danciben;

import android.support.v7.app.AppCompatActivity;

import java.util.HashMap;

import cn.com.u2be.danciben.persenter.Persenter;

/**
 * Created by alek on 2016/6/29.
 */
public class BaseActivity extends AppCompatActivity {

    public HashMap<String, Persenter> getPersenterArrayMap() {
        return persenterArrayMap;
    }

    public void setPersenterArrayMap(HashMap<String, Persenter> persenterArrayMap) {
        this.persenterArrayMap = persenterArrayMap;
    }

    protected HashMap<String, Persenter> persenterArrayMap;


}
