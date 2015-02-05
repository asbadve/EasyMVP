package com.github.jorgecastilloprz.easymvp.executor;

/**
 * Interactors are the execution unit for the system, and they represent the use cases.
 *
 * This interface will be used to abstract concrete use cases from the executor logic.
 *
 * Created by jorge on 11/01/15.
 */
public interface Interactor {
    void run();
}
