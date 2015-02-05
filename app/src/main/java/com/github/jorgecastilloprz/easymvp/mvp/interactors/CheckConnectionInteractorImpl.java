package com.github.jorgecastilloprz.easymvp.mvp.interactors;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.github.jorgecastilloprz.easymvp.executor.InteractorExecutor;
import com.github.jorgecastilloprz.easymvp.executor.MainThread;

import javax.inject.Inject;

/**
 * Connection status use case interactor. Uses injected Android ConnectivityManager to get the
 * info and reports it to the presenter using an injected MainThread implementation.
 *
 * @author Jorge Castillo Pérez
 */
public class CheckConnectionInteractorImpl implements CheckConnectionInteractor {

    private InteractorExecutor executor;
    private ConnectivityManager connectivityManager;
    private MainThread mainThread;

    private Callback callback;
    
    @Inject
    CheckConnectionInteractorImpl(InteractorExecutor executor, MainThread mainThread, ConnectivityManager connectivityManager) {
        this.executor = executor;
        this.mainThread = mainThread;
        this.connectivityManager = connectivityManager;
    }

    @Override
    public void execute(Callback callback) {
        if (callback == null) {
            throw new IllegalArgumentException("Callback must not be null or response would not be able to be notified.");
        }
        this.callback = callback;
        executor.run(this);
    }
    
    @Override
    public void run() {
        NetworkInfo activeNetwork = connectivityManager.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting();
        
        if (isConnected) {
            notifyOnConnectionAvaiable();   
        } else {
            notifyOnConnectionError();
        }
    }

    private void notifyOnConnectionAvaiable() {
        mainThread.post(new Runnable() {
            @Override
            public void run() {
                callback.onConnectionAvaiable();     
            }
        });
    }

    private void notifyOnConnectionError() {
        mainThread.post(new Runnable() {
            @Override
            public void run() {
                callback.onConnectionError();
            }
        });
    }
}
