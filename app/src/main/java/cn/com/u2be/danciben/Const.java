package cn.com.u2be.danciben;

import org.xutils.DbManager;

/**
 * Created by 明 on 2016/7/3.
 */
public class Const {

    private static Const instance;


    public static Const getInstance() {
        if (instance == null)
            instance = new Const();
        return instance;
    }


    private DbManager.DaoConfig daoConfig;

    public DbManager.DaoConfig getDaoConfig() {
        return daoConfig;
    }

    public void setDaoConfig(DbManager.DaoConfig daoConfig) {
        this.daoConfig = daoConfig;
    }

    public void destory() {
        instance = null;
    }
}
