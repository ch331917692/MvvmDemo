package com.mvvm.view.dagger;

import android.app.Activity;

import com.mvvm.utils.IntentUtils;

import dagger.Component;


@Component(modules = {ActivityModule.class})
public interface ActivityComponet {
    Activity getActivity();

    IntentUtils getACIntentUtils();
}
