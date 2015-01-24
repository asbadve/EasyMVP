package com.github.jorgecastilloprz.easymvp;

import com.github.jorgecastilloprz.easymvp.domain.repository.GameRepository;
import com.github.jorgecastilloprz.easymvp.domain.repository.GiantBombRestGameRepository;
import com.github.jorgecastilloprz.easymvp.domain.repository.mapper.GiantBombResponseMapper;
import com.github.jorgecastilloprz.easymvp.mvp.model.Game;

import junit.framework.TestCase;

import java.util.List;

/**
 * Created by jorge on 18/01/15.
 */
public class GiantBombRestGameRepositoryTest extends TestCase {
    
    private GameRepository restGameRepository;
        
    public void testRunnerRestGameRepository() {

        restGameRepository = new GiantBombRestGameRepository(
                "http://www.giantbomb.com/api",
                "07dce392be760422f40d67bc7945d7f1aaac7f4e",
                new GiantBombResponseMapper()
        );
        
        assertNotNull(restGameRepository);
        testObtainGamesByPage();
    }
    
    public void testObtainGamesByPage() {
        List<Game> gamesOnFirstPageResponse = restGameRepository.obtainGamesByPage(1);
        assertNotNull(gamesOnFirstPageResponse);
        assertEquals(10, gamesOnFirstPageResponse.size());
        assertTrue(!gamesOnFirstPageResponse.get(0).getName().equals(""));
    }
}
