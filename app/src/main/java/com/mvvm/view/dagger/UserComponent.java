package com.mvvm.view.dagger;

import com.mvvm.dagger.AppComponet;
import com.mvvm.dagger.PerActivity;
import com.mvvm.view.activity.LoginActivity;
import com.mvvm.view.activity.MainActivity;
import com.mvvm.view.activity.RegisterActivity;

import dagger.Component;

/**
 * Created by Cmad on 2016/4/21.
 */

@PerActivity
@Component(dependencies = {AppComponet.class,ActivityComponet.class}, modules = UserModule.class)
public interface UserComponent {
    void inject(LoginActivity loginActivity);
    void inject(RegisterActivity registerActivity);
    void inject(MainActivity mainActivity);
}
