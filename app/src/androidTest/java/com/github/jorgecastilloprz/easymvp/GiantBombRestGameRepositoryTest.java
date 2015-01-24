package com.github.jorgecastilloprz.easymvp;

import com.github.jorgecastilloprz.easymvp.di.RepositoryModule;
import com.github.jorgecastilloprz.easymvp.domain.repository.GameRepository;
import com.github.jorgecastilloprz.easymvp.domain.repository.RestGameRepository;
import com.github.jorgecastilloprz.easymvp.domain.restmodel.GiantBombGameListResponse;
import com.github.jorgecastilloprz.easymvp.domain.restmodel.GiantBombSingleGameResponse;

import junit.framework.TestCase;

import dagger.ObjectGraph;

/**
 * Created by jorge on 18/01/15.
 */
public class GiantBombRestGameRepositoryTest extends TestCase {
    
    private GameRepository restGameRepository;
        
    public void testRunnerRestGameRepository() {

        restGameRepository = new RestGameRepository("http://www.giantbomb.com/api");
        ObjectGraph repositoryGraph = ObjectGraph.create(new RepositoryModule());
        repositoryGraph.inject(restGameRepository);
        
        assertNotNull(restGameRepository);
        testObtainGamesByPage();
    }
    
    public void testObtainGamesByPage() {
        GiantBombGameListResponse gamesOnFirstPageResponse = restGameRepository.obtainGamesByPage(1);
        assertEquals(10, (int) gamesOnFirstPageResponse.getNumberOfPageResults());

        testObtainSingleGame();
    }
    
    public void testObtainSingleGame() {
        GiantBombSingleGameResponse singleGameResponse = restGameRepository.obtainGameDetailsById(1);
        assertNotNull(singleGameResponse);
        assertNotNull(singleGameResponse.getResult());
        assertTrue(singleGameResponse.getResult().getId() > 0);
    }
}
