package com.github.jorgecastilloprz.easymvp.mvp.interactors;

import com.github.jorgecastilloprz.easymvp.domain.repository.GameRepository;
import com.github.jorgecastilloprz.easymvp.domain.repository.exceptions.ObtainGamesException;
import com.github.jorgecastilloprz.easymvp.executor.InteractorExecutor;
import com.github.jorgecastilloprz.easymvp.executor.MainThread;
import com.github.jorgecastilloprz.easymvp.mvp.model.Game;

import java.util.List;

import javax.inject.Inject;

/**
 * Use case designed to obtain a page of games from the repository by a given page number. It notifies 
 * the results to the presenter using a MainThread implementation.
 *
 * @author Jorge Castillo Pérez
 */
public class GetGamesByPageInteractorImpl implements GetGamesByPageInteractor {
    
    private InteractorExecutor executor;
    private MainThread mainThread;
    private GameRepository gameRepository;
    
    private int pageNumber;
    private Callback callback;
    
    @Inject
    GetGamesByPageInteractorImpl(InteractorExecutor executor, MainThread mainThread, GameRepository gameRepository) {
        this.executor = executor;
        this.mainThread = mainThread;
        this.gameRepository = gameRepository;
    }

    @Override
    public void execute(int pageNumber, Callback callback) {
        if (callback == null) {
            throw new IllegalArgumentException("Callback must not be null or response would not be able to be notified.");
        }
        this.callback = callback;
        this.pageNumber = pageNumber;
        executor.run(this);
    }
    
    @Override
    public void run() {
        try {
            List<Game> games = gameRepository.obtainGamesByPage(pageNumber);
            notifyGamesLoaded(games);
        }
        catch (ObtainGamesException exception) {
            notifyPetitionError(exception.getMessage());
        }
    }
    
    private void notifyGamesLoaded(final List<Game> games) {
        mainThread.post(new Runnable() {
            @Override
            public void run() {
                callback.onGamePageLoaded(games);
            }
        });
    }

    private void notifyPetitionError(final String message) {
        mainThread.post(new Runnable() {
            @Override
            public void run() {
                callback.onGettingGamesError(message);
            }
        });
    }
}
