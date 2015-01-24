package com.github.jorgecastilloprz.easymvp.domain.repository;

import com.github.jorgecastilloprz.easymvp.domain.restmodel.GiantBombResponse;

import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by jorge on 18/01/15.
 */
public interface RetrofitGiantBombService {
    @GET("/games")
    GiantBombResponse obtainGamesByPage(@Query("api_key") String apiKey, @Query("format") String format,
                           @Query("offset") int offset, @Query("limit") int limit);
}
