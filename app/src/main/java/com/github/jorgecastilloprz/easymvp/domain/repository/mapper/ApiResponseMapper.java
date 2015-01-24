package com.github.jorgecastilloprz.easymvp.domain.repository.mapper;

import com.github.jorgecastilloprz.easymvp.mvp.model.Game;

import java.util.List;

/**
 * Abstraction to allow different api mappers provided by dependency injection
 *
 * Created by jorge on 24/01/15.
 */
public interface ApiResponseMapper<T> {
    List<Game> mapToGameList(List<T> restModelGameList);
    Game mapToGame(T restGameModel);
}
