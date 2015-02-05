package com.github.jorgecastilloprz.easymvp.executor;

import android.os.Handler;
import android.os.Looper;

import javax.inject.Inject;

/**
 * {@link MainThread} implementation. Will make
 * interactor Callbacks able to get executed in the Android UI thread*
 * * *
 * Created by jorge on 11/01/15.
 */
public class MainThreadImpl implements MainThread {

    private Handler handler;

    @Inject
    MainThreadImpl() {
        this.handler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void post(Runnable runnable) {
        handler.post(runnable);
    }
}
