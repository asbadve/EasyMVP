package com.github.jorgecastilloprz.easymvp.di;

import android.app.Activity;
import android.content.Context;

import com.github.jorgecastilloprz.easymvp.di.qualifiers.ActivityContext;

import dagger.Module;
import dagger.Provides;

/**
 * Dependency injection module used to provide activity scope dependencies
 * Created by jorge on 11/01/15.
 */

@Module(library = true)
public class ActivityModule {

    private final Activity activityContext;

    public ActivityModule(Activity activityContext) {
        this.activityContext = activityContext;
    }

    @Provides
    @ActivityContext
    Context provideActivityContext() {
        return activityContext;
    }
}
