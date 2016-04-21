package com.mvvm.dagger;

import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.mvvm.utils.SPUtils;
import com.mvvmdao.greendao.DaoMaster;
import com.mvvmdao.greendao.DaoSession;

import dagger.Module;
import dagger.Provides;

/**
 * AppMoudel
 * User: 汪乐骏
 * Date: 2016-04-16
 * Time: 13:20
 */
@Module
public class AppModule {
    private Application application;

    public AppModule(Application application){
        this.application=application;
    }

    @PerApp
    @Provides
    public Context provideContext(){
        return application;
    }

    /****GreenDao 数据库初始化************/
    @PerApp
    @Provides
    public SQLiteDatabase provideSQLiteDatabase(){
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(application,"userinfo-db",null);
        return helper.getWritableDatabase();
    }

    @PerApp
    @Provides
    public DaoMaster providesDaoMaster(SQLiteDatabase sqLiteDatabase){
        return new DaoMaster(sqLiteDatabase);
    }

    @PerApp
    @Provides
    public DaoSession providesDaoSession(DaoMaster daoMaster){
        return  daoMaster.newSession();
    }

    @Provides
    public SPUtils providesSP(){
        return new SPUtils(application);
    }



}
