package com.github.jorgecastilloprz.easymvp.domain.repository;

import com.github.jorgecastilloprz.easymvp.mvp.model.Game;

import java.util.List;

import retrofit.RestAdapter;

/**
 * Created by jorge on 18/01/15.
 */
public class RestGameRepository implements GameRepository {
    
    private final String endPoint;
    private RetrofitGiantBombService retrofitGiantBombService;
    
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
    public List<Game> obtainGamesByPage(int pageNumber) {
        return null;
    }

    @Override
    public Game obtainGameDetailsById(int gameId) {
        return null;
    }
}
