package com.mvvm.view.dagger;

import com.mvvm.utils.IntentUtils;
import com.mvvm.utils.SPUtils;
import com.mvvm.viewmodel.IndexViewModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Cmad on 2016/4/21.
 */
@Module
public class IndexModule {

    @Provides
    public IndexViewModel providesIndexViewModel(SPUtils SPUtils, IntentUtils intentUtils){
        return new IndexViewModel(SPUtils, intentUtils);
    }

}
