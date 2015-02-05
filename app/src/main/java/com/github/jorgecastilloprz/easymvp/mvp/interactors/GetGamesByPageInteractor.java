package com.github.jorgecastilloprz.easymvp.mvp.interactors;

import com.github.jorgecastilloprz.easymvp.executor.Interactor;
import com.github.jorgecastilloprz.easymvp.mvp.model.Game;

import java.util.List;

/**
 * This behaviour defines a get games by page generic logic. Interactors are executed by 
 * InteractorExecutor.
 *
 * @author Jorge Castillo Pérez
 */
public interface GetGamesByPageInteractor extends Interactor {
    
    void execute(int pageNumber, Callback callback);
    
    interface Callback {
        
        void onGamePageLoaded(List<Game> games);
        
        void onGettingGamesError(String errorMessage);
    }
}
