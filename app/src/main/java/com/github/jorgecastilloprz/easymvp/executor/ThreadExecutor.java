package com.github.jorgecastilloprz.easymvp.executor;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

/**
 * Interactor dispatcher. Contains the initial executor setup.
 * Using {@link java.util.concurrent.ThreadPoolExecutor} as the executor implementation.
 * *
 * Created by jorge on 11/01/15.
 */
public class ThreadExecutor implements InteractorExecutor {

    private static final int CORE_POOL_SIZE = 3;
    private static final int MAX_POOL_SIZE = 5;
    private static final int KEEP_ALIVE_TIME = 120;
    private static final TimeUnit TIME_UNIT = TimeUnit.SECONDS;
    private static final BlockingQueue<Runnable> WORK_QUEUE = new LinkedBlockingQueue<Runnable>();

    private ThreadPoolExecutor threadPoolExecutor;

    @Inject
    ThreadExecutor() {
        threadPoolExecutor = new ThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE, KEEP_ALIVE_TIME, TIME_UNIT, WORK_QUEUE);
    }

    @Override
    public void run(Interactor interactor) {
        if (interactor == null) {
            throw new IllegalArgumentException("Interactor must not be null");
        }

        threadPoolExecutor.submit(interactor);
    }
}
