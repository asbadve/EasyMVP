package com.github.jorgecastilloprz.easymvp.di;

import com.github.jorgecastilloprz.easymvp.mvp.presenters.GameListPresenter;
import com.github.jorgecastilloprz.easymvp.mvp.presenters.GameListPresenterImpl;
import com.github.jorgecastilloprz.easymvp.mvp.views.GameListFragment;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Satisfies presenter dependent classes with concrete presenter implementations
 *
 * @author Jorge Castillo Pérez
 */

@Module(
        injects = {GameListFragment.class},
        library = true, complete = false
)
public class PresenterModule {

    @Provides @Singleton GameListPresenter gameListPresenterProvider(GameListPresenterImpl gameListPresenter) {
        return gameListPresenter;
    }
}
