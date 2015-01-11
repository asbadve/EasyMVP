package com.github.jorgecastilloprz.easymvp.di;

import com.github.jorgecastilloprz.easymvp.executor.InteractorExecutor;
import com.github.jorgecastilloprz.easymvp.executor.MainThreadExecutor;
import com.github.jorgecastilloprz.easymvp.executor.MainThreadExecutorImpl;
import com.github.jorgecastilloprz.easymvp.executor.ThreadExecutor;

import java.util.concurrent.Executor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by jorge on 11/01/15.
 */

@Module(library = true)
public class ExecutorModule {
    @Provides @Singleton
    InteractorExecutor provideExecutor(ThreadExecutor threadExecutor) {
        return threadExecutor;
    }

    @Provides @Singleton
    MainThreadExecutor provideMainThread(MainThreadExecutorImpl mainThread) {
        return mainThread;
    }
}
