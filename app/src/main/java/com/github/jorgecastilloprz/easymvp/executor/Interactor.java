package com.github.jorgecastilloprz.easymvp.executor;

/**
 * Use cases are defined by interactors in this application. Interactors are the execution unit for
 * the system. They extend java standard class {@link Runnable}.
 * *
 * This interface will be used to abstract concrete use cases from the executor logic.
 * *
 * Created by jorge on 11/01/15.
 */
public interface Interactor extends Runnable {
}
