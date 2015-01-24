package com.github.jorgecastilloprz.easymvp.domain.repository;

import com.github.jorgecastilloprz.easymvp.domain.repository.exceptions.ObtainGamesException;
import com.github.jorgecastilloprz.easymvp.domain.restmodel.GiantBombGameListResponse;
import com.github.jorgecastilloprz.easymvp.domain.restmodel.GiantBombResponse;
import com.github.jorgecastilloprz.easymvp.domain.restmodel.GiantBombSingleGameResponse;
import com.github.jorgecastilloprz.easymvp.domain.restmodel.Result;

import javax.inject.Inject;
import javax.inject.Named;

import retrofit.RestAdapter;
import retrofit.RetrofitError;

/**
 * Created by jorge on 18/01/15.
 */
public class RestGameRepository implements GameRepository {

    private final String JSON_FORMAT = "json";
    private final String endPoint;
    private RetrofitGiantBombService retrofitGiantBombService;
    
    @Inject
    @Named("api_key")
    String apiKey;
    
    public RestGameRepository(String endPoint) {
        this.endPoint = endPoint;
        init();
    }
    
    private void init() {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(endPoint)
                .build();

        retrofitGiantBombService = restAdapter.create(RetrofitGiantBombService.class);
    }
    
    @Override
    public GiantBombGameListResponse obtainGamesByPage(int pageNumber) throws ObtainGamesException {
        
        try {
            GiantBombGameListResponse obtainedGames = retrofitGiantBombService.obtainGamesByPage(apiKey, JSON_FORMAT, pageNumber * 10, 10);
            return obtainedGames;
        }
        catch (RetrofitError retrofitError) {
            ObtainGamesException obtainGamesException = new ObtainGamesException(retrofitError.getMessage());
            obtainGamesException.setStackTrace(retrofitError.getStackTrace());
            throw obtainGamesException;
        }
    }

    @Override
    public GiantBombSingleGameResponse obtainGameDetailsById(int gameId) throws ObtainGamesException {
        
        try {
            GiantBombSingleGameResponse gameDetailsResult = retrofitGiantBombService.obtainGameDetailsById(apiKey, gameId, JSON_FORMAT);
            return gameDetailsResult;    
        }
        catch (RetrofitError retrofitError) {
            ObtainGamesException obtainGamesException = new ObtainGamesException(retrofitError.getMessage());
            obtainGamesException.setStackTrace(retrofitError.getStackTrace());
            throw obtainGamesException;
        }
    }
}
