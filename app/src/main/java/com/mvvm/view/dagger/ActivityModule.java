package com.mvvm.view.dagger;

import android.app.Activity;

import com.mvvm.utils.IntentUtils;

import dagger.Module;
import dagger.Provides;

/**
 * User: 汪乐骏
 * Date: 2016-04-16
 * Time: 23:58
 */
@Module
public class ActivityModule {

    private Activity activity;
    public ActivityModule(Activity activity){
        this.activity = activity;
    }

    @Provides
    public Activity provideActivity(){
        return activity;
    }

    @Provides
    public IntentUtils providesActivityIntentUtils(Activity activity){
        return new IntentUtils(activity);
    }

}
