package cn.com.u2be.danciben.persenter;


import cn.com.u2be.danciben.view.View;

/**
 * Created by alek on 2016/6/29.
 */
public interface Persenter<T extends View> {

    void onViewAttached(T view);

    void onViewDetached();

    void onDestory();
}
