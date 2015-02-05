package com.github.jorgecastilloprz.easymvp.di;

import com.github.jorgecastilloprz.easymvp.executor.InteractorExecutor;
import com.github.jorgecastilloprz.easymvp.executor.MainThread;
import com.github.jorgecastilloprz.easymvp.executor.MainThreadImpl;
import com.github.jorgecastilloprz.easymvp.executor.ThreadExecutor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by jorge on 11/01/15.
 */
@Module(library = true)
public class ExecutorModule {

    @Provides
    @Singleton
    InteractorExecutor provideExecutor(ThreadExecutor threadExecutor) {
        return threadExecutor;
    }

    @Provides
    @Singleton
    MainThread provideMainThread(MainThreadImpl mainThread) {
        return mainThread;
    }
}
