package com.mvvm.view.dagger;

import com.mvvm.dagger.AppComponet;
import com.mvvm.dagger.PerActivity;
import com.mvvm.view.activity.IndexActivity;

import dagger.Component;

/**
 * Created by Cmad on 2016/4/21.
 */
@PerActivity
@Component(dependencies = { AppComponet.class, ActivityComponet.class}, modules = IndexModule.class)
public interface IndexComponent{
    void inject(IndexActivity indexActivity);
}
