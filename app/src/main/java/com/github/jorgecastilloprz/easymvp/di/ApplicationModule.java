package com.github.jorgecastilloprz.easymvp.di;

import android.content.Context;
import android.net.ConnectivityManager;
import android.view.LayoutInflater;

import com.github.jorgecastilloprz.easymvp.EasyMVPApplication;

import dagger.Module;
import dagger.Provides;

/**
 * Dagger module used to inject application context and generic Android sdk needs
 *
 * @author Jorge Castillo Pérez
 */
@Module(
        includes = {ExecutorModule.class, InteractorModule.class, PresenterModule.class, RepositoryModule.class},
        injects = {EasyMVPApplication.class},
        library = true
)
public class ApplicationModule {

    private final Context appContext;

    public ApplicationModule(Context appContext) {
        this.appContext = appContext;
    }

    @Provides Context provideApplicationContext() {
        return appContext;
    }

    @Provides LayoutInflater provideLayoutInflater() {
        return LayoutInflater.from(appContext);
    }
    
    @Provides ConnectivityManager provideConnectivityManager() {
        return (ConnectivityManager) appContext.getSystemService(Context.CONNECTIVITY_SERVICE);
    }
}