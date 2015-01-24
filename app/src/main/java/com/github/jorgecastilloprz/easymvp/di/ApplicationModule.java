package com.github.jorgecastilloprz.easymvp.di;

import android.content.Context;
import android.view.LayoutInflater;

import dagger.Module;
import dagger.Provides;

/**
 * Created by jorge on 22/01/15.
 */
@Module(library = true)
public class ApplicationModule {

    private final Context appContext;

    public ApplicationModule(Context appContext) {
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
