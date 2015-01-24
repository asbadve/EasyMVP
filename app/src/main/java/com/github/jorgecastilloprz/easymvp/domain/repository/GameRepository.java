package com.github.jorgecastilloprz.easymvp.domain.repository;

import com.github.jorgecastilloprz.easymvp.domain.restmodel.GiantBombGameListResponse;
import com.github.jorgecastilloprz.easymvp.domain.restmodel.GiantBombResponse;
import com.github.jorgecastilloprz.easymvp.domain.restmodel.GiantBombSingleGameResponse;
import com.github.jorgecastilloprz.easymvp.domain.restmodel.Result;

/**
 * Created by jorge on 18/01/15.
 */
public interface GameRepository {
    GiantBombGameListResponse obtainGamesByPage(int pageNumber);
    GiantBombSingleGameResponse obtainGameDetailsById(int gameId);
}
