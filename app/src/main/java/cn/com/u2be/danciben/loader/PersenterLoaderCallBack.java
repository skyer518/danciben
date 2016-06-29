package cn.com.u2be.danciben.loader;

import android.app.LoaderManager;
import android.content.Loader;
import android.os.Bundle;

import java.util.HashMap;

import cn.com.u2be.danciben.BaseActivity;
import cn.com.u2be.danciben.persenter.Persenter;

/**
 * Created by alek on 2016/6/29.
 */

public class PersenterLoaderCallBack implements LoaderManager.LoaderCallbacks<HashMap<String, Persenter>> {

    private HashMap<String, Persenter> persenterArrayMap;
    private BaseActivity context;

    public PersenterLoaderCallBack(BaseActivity context, HashMap<String, Persenter> persenterArrayMap) {
        this.persenterArrayMap = persenterArrayMap;
        this.context = context;
    }

    @Override
    public Loader<HashMap<String, Persenter>> onCreateLoader(int id, Bundle args) {
        return new PersenterLoader(context, persenterArrayMap);
    }

    @Override
    public void onLoadFinished(Loader<HashMap<String, Persenter>> loader, HashMap<String, Persenter> data) {
        context.setPersenterArrayMap(data);
    }

    @Override
    public void onLoaderReset(Loader<HashMap<String, Persenter>> loader) {
        persenterArrayMap = null;
    }
}