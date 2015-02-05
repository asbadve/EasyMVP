package com.github.jorgecastilloprz.easymvp.domain.repository;

import com.github.jorgecastilloprz.easymvp.domain.repository.exceptions.ObtainGamesException;
import com.github.jorgecastilloprz.easymvp.mvp.model.Game;

import java.util.List;

/**
 * Created by jorge on 18/01/15.
 */
public interface GameRepository {
    List<Game> obtainGamesByPage(int pageNumber);
}
