package com.github.jorgecastilloprz.easymvp.domain.repository;

import com.github.jorgecastilloprz.easymvp.domain.restmodel.GiantBombGameListResponse;
import com.github.jorgecastilloprz.easymvp.domain.restmodel.GiantBombResponse;
import com.github.jorgecastilloprz.easymvp.domain.restmodel.GiantBombSingleGameResponse;
import com.github.jorgecastilloprz.easymvp.domain.restmodel.Result;

import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by jorge on 18/01/15.
 */
public interface RetrofitGiantBombService {
    @GET("/games")
    GiantBombGameListResponse obtainGamesByPage(@Query("api_key") String apiKey, @Query("format") String format,
                           @Query("offset") int offset, @Query("limit") int limit);

    @GET("/game/{id}")
    GiantBombSingleGameResponse obtainGameDetailsById(@Query("api_key") String apiKey, @Path("id") int id, @Query("format") String format);
}
