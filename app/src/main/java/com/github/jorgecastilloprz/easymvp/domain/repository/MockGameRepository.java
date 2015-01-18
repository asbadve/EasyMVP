package com.github.jorgecastilloprz.easymvp.domain.repository;

import com.github.jorgecastilloprz.easymvp.mvp.model.Game;

import java.util.List;

/**
 * Created by jorge on 18/01/15.
 */
public class MockGameRepository implements GameRepository {
    @Override
    public List<Game> obtainGamesByPage(int pageNumber) {
        return null;
    }

    @Override
    public Game obtainGameDetailsById(int gameId) {
        return null;
    }
}
