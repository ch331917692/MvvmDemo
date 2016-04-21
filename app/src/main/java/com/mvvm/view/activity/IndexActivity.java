package com.mvvm.view.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.mvvm.R;
import com.mvvm.databinding.ActivityIndexBinding;
import com.mvvm.view.dagger.DaggerIndexComponent;
import com.mvvm.viewmodel.IndexViewModel;

import javax.inject.Inject;

/**
 * 启动页
 */
public class IndexActivity extends BaseActivity implements View.OnClickListener{
    //注入UserInfoViewModel
    @Inject
    IndexViewModel indexViewModel;

    ActivityIndexBinding indexBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void initView() {
        indexBinding = DataBindingUtil.setContentView(this,R.layout.activity_index);
    }

    @Override
    public void initComponent() {
        Log.e("CM","-----initComponent-----");
        DaggerIndexComponent.builder()
                .appComponet(getAppComponent())
                .activityComponet(getActivityComponet())
                .build()
                .inject(this);
    }

    @Override
    public void initData() {

    }


    @Override
    public void setListener() {

    }

    @Override
    public void onClick(View v) {

    }
}
