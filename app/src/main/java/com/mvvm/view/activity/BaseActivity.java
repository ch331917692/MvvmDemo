package com.mvvm.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.mvvm.dagger.AppApplication;
import com.mvvm.dagger.AppComponet;
import com.mvvm.view.dagger.ActivityComponet;
import com.mvvm.view.dagger.ActivityModule;
import com.mvvm.view.dagger.DaggerActivityComponet;


/**
 * BaseActivity
 */
public abstract class BaseActivity
//        <V extends ViewDataBinding>
        extends AppCompatActivity {

    private ActivityComponet activityComponet;

//    private V dataBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }



    private void init(){
        activityComponet = DaggerActivityComponet.builder().activityModule(new ActivityModule(this)).build();

//        dataBinding = DataBindingUtil.setContentView(this,inflaterContentView());
        initComponent();
        initView();
        initData();
        setListener();
    }

    public AppComponet getAppComponent(){
        return AppApplication.getsInstance().getAppComponent();
    }

    public ActivityComponet getActivityComponet(){
        return activityComponet;
    }

//    protected abstract int inflaterContentView();

    /**
     * 初始化view
     */
    public abstract void initView();

    /**
     * 初始数据
     */
    public abstract void initData();


    public abstract void initComponent();

    /**
     * 设置监听
     */
    public abstract void setListener();

//    public V getDataBinding(){
//        return dataBinding;
//    }
}

