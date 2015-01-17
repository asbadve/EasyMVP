package com.github.jorgecastilloprz.easymvp.di;

import android.content.Context;
import android.view.LayoutInflater;

import com.github.jorgecastilloprz.easymvp.EasyMVPApplication;

import dagger.Module;
import dagger.Provides;

/**
 * Created by jorge on 10/01/15.
 */

@Module(
        includes = {
                ExecutorModule.class
        },
        injects = {
                EasyMVPApplication.class
        },
        library = true)
public class RootModule {

    private final Context appContext;

    public RootModule(Context appContext) {
        this.appContext = appContext;
    }

    @Provides
    Context provideApplicationContext() {
        return appContext;
    }

    @Provides
    LayoutInflater provideLayoutInflater() {
        return LayoutInflater.from(appContext);
    }
}
