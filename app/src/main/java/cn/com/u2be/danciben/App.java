package cn.com.u2be.danciben;

import android.app.Application;
import android.os.Environment;

import org.xutils.DbManager;
import org.xutils.config.DbConfigs;
import org.xutils.ex.DbException;
import org.xutils.x;

import cn.com.u2be.danciben.entity.Word;

/**
 * Created by 明 on 2016/7/3.
 */
public class App extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this); // 初始化 X-utils3

        Const.getInstance().setDaoConfig(new DbManager.DaoConfig()
                .setDbName("danciben")//创建数据库的名称
                .setDbVersion(1)//数据库版本号
                .setDbUpgradeListener(new DbManager.DbUpgradeListener() {
                    @Override
                    public void onUpgrade(DbManager db, int oldVersion, int newVersion) {
                        // TODO: ...
                        // db.addColumn(...);
                        // db.dropTable(...);
                        // ...
                    }
                }));//数据库更新操作

    }


}
