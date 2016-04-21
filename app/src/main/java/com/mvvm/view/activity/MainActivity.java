package com.mvvm.view.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import com.mvvm.R;
import com.mvvm.databinding.ActivityMainBinding;
import com.mvvm.utils.Constants;
import com.mvvm.view.dagger.DaggerUserComponent;
import com.mvvm.viewmodel.UserInfoViewModel;

import javax.inject.Inject;

/**
 * 主页
 */
public class MainActivity extends BaseActivity implements View.OnClickListener{
    //注入UserInfoViewModel
    @Inject
    UserInfoViewModel userInfoViewModel;
    ActivityMainBinding mainBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void initView() {
        mainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        mainBinding.setUserInfo(userInfoViewModel.getUserInfo());
    }

    @Override
    public void initComponent() {
        DaggerUserComponent.builder()
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
        mainBinding.mainExitBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //退出 修改登录状态
        userInfoViewModel.SPUtils.putBooleanValues(Constants.SP_KEY_LOGIN_STATUS,false);
        userInfoViewModel.intentUtils.turnToNextActivity(LoginActivity.class);
    }
}
