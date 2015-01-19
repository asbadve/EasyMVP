package com.github.jorgecastilloprz.easymvp;

import com.github.jorgecastilloprz.easymvp.domain.repository.GameRepository;
import com.github.jorgecastilloprz.easymvp.domain.repository.RestGameRepository;

import junit.framework.TestCase;

/**
 * Created by jorge on 18/01/15.
 */
public class RestGameRepositoryTest extends TestCase {
    
    public void testCreateRestGameRepository() {

        String api_key = "07dce392be760422f40d67bc7945d7f1aaac7f4e";
        
        GameRepository restGameRepository = new RestGameRepository("http://www.giantbomb.com/api");
    }
}
