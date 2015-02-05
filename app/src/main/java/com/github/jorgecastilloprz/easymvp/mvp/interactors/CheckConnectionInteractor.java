package com.github.jorgecastilloprz.easymvp.mvp.interactors;

import com.github.jorgecastilloprz.easymvp.executor.Interactor;

/**
 * Behavior implemented to create network checking interactors
 *
 * @author Jorge Castillo Pérez
 */
public interface CheckConnectionInteractor extends Interactor {

    void execute(Callback callback);

    interface Callback {

        void onConnectionAvaiable();
        
        void onConnectionError();
    }
}
