package com.github.jorgecastilloprz.easymvp.executor;

/**
 * Abstraction used to allow interactor callbacks to be executed in the main UI thread.
 * *
 * Created by jorge on 11/01/15.
 */
public interface MainThreadExecutor {
    void post(final Runnable runnable);
}
