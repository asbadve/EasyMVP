package com.github.jorgecastilloprz.easymvp.domain.repository.mapper;

import com.github.jorgecastilloprz.easymvp.domain.restmodel.GiantBombResponse;
import com.github.jorgecastilloprz.easymvp.domain.restmodel.Platform;
import com.github.jorgecastilloprz.easymvp.domain.restmodel.Result;
import com.github.jorgecastilloprz.easymvp.mvp.model.Game;

import java.util.ArrayList;
import java.util.List;

/**
 * Used to map GiantBomb rest api game responses to {@link Game model}
 *
 * Created by jorge on 24/01/15.
 */
public class GiantBombResponseMapper implements ApiResponseMapper<Result> {

    /**
     * Maps a GiantBomb game list from rest model to app model
     * @param giantBombGameList
     * @return App model game list
     */
    public List<Game> mapToGameList(List<Result> giantBombGameList) {
        
        List<Game> gameList = new ArrayList<Game>();
        for (Result giantBombGameResult : giantBombGameList) {
            gameList.add(mapToGame(giantBombGameResult));
        }
        
        return gameList;
    }

    public Game mapToGame(Result gameResult) {

        ArrayList<String> platForms = new ArrayList<String>();

        for (Platform platform : gameResult.getPlatforms()) {
            platForms.add(platform.getName());
        }

        Game game = new Game(
                gameResult.getName(),
                gameResult.getImage().getMediumUrl(),
                gameResult.getDeck(),
                (gameResult.getDescription() != null) ? gameResult.getDescription() : gameResult.getDeck(),
                gameResult.getOriginalReleaseDate(),
                platForms
        );

        return game;
    }
}
