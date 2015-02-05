package com.github.jorgecastilloprz.easymvp.mvp.presenters;

import com.github.jorgecastilloprz.easymvp.mvp.interactors.CheckConnectionInteractor;
import com.github.jorgecastilloprz.easymvp.mvp.interactors.GetGamesByPageInteractor;
import com.github.jorgecastilloprz.easymvp.mvp.model.Game;
import com.github.jorgecastilloprz.easymvp.mvp.views.LoadingView;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Implements obtaining games presentation logic.
 *
 * @author Jorge Castillo Pérez
 */
@Singleton
public class GameListPresenterImpl implements LifecycleCallbacks, GameListPresenter {
    
    private View view;
    
    private CheckConnectionInteractor checkConnectionInteractor;
    private GetGamesByPageInteractor getGamesByPageInteractor;
    
    @Inject GameListPresenterImpl(CheckConnectionInteractor checkConnectionInteractor, GetGamesByPageInteractor getGamesByPageInteractor) {
        this.checkConnectionInteractor = checkConnectionInteractor;
        this.getGamesByPageInteractor = getGamesByPageInteractor;
    }

    public void setView(View view) {
        if (view == null) {
            throw new IllegalArgumentException("View must not be null!");
        }
        
        this.view = view;
    }

    @Override
    public void onStart() {
        checkConnectionError();
    }

    /**
     * Dispatchs CheckConnection interactor logic and declares callback for reacting to results
     */
    private void checkConnectionError() {
        checkConnectionInteractor.execute(new CheckConnectionInteractor.Callback() {
            @Override
            public void onConnectionAvaiable() {
                getGamesForPage(1);
            }

            @Override
            public void onConnectionError() {
                view.displayConnectionError();
            }
        });
    }

    /**
     * Dispatchs GetGamesByPage interactor logic and declares callback for reacting to results
     *
     * @param pageNumber to load
     */
    private void getGamesForPage(int pageNumber) {
        getGamesByPageInteractor.execute(pageNumber, new GetGamesByPageInteractor.Callback() {

            @Override
            public void onGamePageLoaded(List<Game> games) {
                view.drawGames(games);
            }

            @Override
            public void onGettingGamesError(String errorMessage) {
                view.displayGettingGamesError(errorMessage);
            }
        });
    }

    @Override
    public void onResume() {
        //Empty
    }

    @Override
    public void onPause() {
        //Empty
    }

    @Override
    public void onGameClick() {
        view.showGameDetails();
    }

    /**
     * View used to decouple game list view implementation from model and vice versa
     */
    public interface View extends LoadingView {

        void drawGames(List<Game> games);
        
        void displayConnectionError();
        
        void displayGettingGamesError(String errorMessage);
        
        void showGameDetails();
    }
}
