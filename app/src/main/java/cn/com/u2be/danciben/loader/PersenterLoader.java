package cn.com.u2be.danciben.loader;

import android.content.Context;
import android.content.Loader;
import android.util.ArrayMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import cn.com.u2be.danciben.persenter.Persenter;

/**
 * Created by alek on 2016/6/29.
 */
public class PersenterLoader<T extends Persenter> extends Loader<ArrayMap<String, Persenter>> {

    private HashMap<String, Persenter> persenterArrayMap;

    public PersenterLoader(Context context, HashMap<String, Persenter> persenterArrayMap) {
        super(context);
        this.persenterArrayMap = persenterArrayMap;
    }


    @Override
    protected void onStartLoading() {
        super.onStartLoading();

        if (persenterArrayMap == null) {
            // 创建 persenterArrayMap
        }

    }

    @Override
    protected void onReset() {
        super.onReset();
        if (persenterArrayMap == null)
            return;
        final Iterator<Map.Entry<String, Persenter>> iterator = persenterArrayMap.entrySet().iterator();
        while (iterator.hasNext()) {
            final Map.Entry<String, Persenter> next = iterator.next();
            next.getValue().onDestory();
        }
        persenterArrayMap = null;

    }
}
