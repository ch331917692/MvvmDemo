package com.mvvm.view.dagger;

import android.app.Activity;

import com.mvvm.model.UserModel;
import com.mvvm.utils.IntentUtils;
import com.mvvm.utils.SPUtils;
import com.mvvm.viewmodel.UserInfoViewModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Cmad on 2016/4/21.
 */
@Module
public class UserModule {

    @Provides
    public UserModel provideUserModel(){
        return new UserModel();
    }

    /**
     * 提供UserInfoViewModel
     * @return UserInfoViewModel
     */
    @Provides
    public UserInfoViewModel provideUserInfoViewModel(Activity context, UserModel userModel, SPUtils SPUtils, IntentUtils intentUtils){
        return new UserInfoViewModel(context,userModel, SPUtils,intentUtils);
    }
}
