package com.github.jorgecastilloprz.easymvp.di;

import com.github.jorgecastilloprz.easymvp.mvp.interactors.CheckConnectionInteractor;
import com.github.jorgecastilloprz.easymvp.mvp.interactors.CheckConnectionInteractorImpl;
import com.github.jorgecastilloprz.easymvp.mvp.interactors.GetGamesByPageInteractor;
import com.github.jorgecastilloprz.easymvp.mvp.interactors.GetGamesByPageInteractorImpl;
import com.github.jorgecastilloprz.easymvp.mvp.presenters.GameListPresenterImpl;
import com.github.jorgecastilloprz.easymvp.mvp.views.GameListFragment;

import dagger.Module;
import dagger.Provides;

/**
 * Interactor injection module
 *
 * @author Jorge Castillo Pérez
 */
@Module(
        injects = {GameListPresenterImpl.class},
        library = true, complete = false
)
public class InteractorModule {
    
    @Provides
    GetGamesByPageInteractor provideGetGamesByPageInteractor(GetGamesByPageInteractorImpl getGamesByPageInteractor) {
        return getGamesByPageInteractor;
    }

    @Provides
    CheckConnectionInteractor provideCheckConnectionInteractor(CheckConnectionInteractorImpl checkConnectionInteractor) {
        return checkConnectionInteractor;
    }
}
