package com.github.jorgecastilloprz.easymvp.executor;

/**
 * Used to define the interactor execution behavior. Other entities could act as interactor
 * executors just by implementing this interface and his very own execution logic.
 * *
 * Created by jorge on 11/01/15.
 */
public interface InteractorExecutor {
    void run(Interactor interactor);
}
