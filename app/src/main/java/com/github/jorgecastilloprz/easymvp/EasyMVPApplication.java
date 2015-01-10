package com.github.jorgecastilloprz.easymvp;

import android.app.Application;

import dagger.ObjectGraph;

/**
 * Created by jorge on 10/01/15.
 */
public class EasyMVPApplication extends Application {

    private ObjectGraph objectGraph;
    
    @Override
    public void onCreate() {
        super.onCreate();
    }
}
