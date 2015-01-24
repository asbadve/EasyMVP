package com.github.jorgecastilloprz.easymvp.di;

import com.github.jorgecastilloprz.easymvp.domain.repository.GameRepository;
import com.github.jorgecastilloprz.easymvp.domain.repository.MockGameRepository;
import com.github.jorgecastilloprz.easymvp.domain.repository.RestGameRepository;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Dagger module for repository injects
 * * *
 * Created by jorge on 18/01/15.
 */

@Module(
        injects = {RestGameRepository.class},
        complete = false, library = true)
public class RepositoryModule {

    private final String giantBombApiKey = "07dce392be760422f40d67bc7945d7f1aaac7f4e";

    @Provides
    @Named("api_key")
    public String provideApiKey() {
        return giantBombApiKey;
    }

    @Provides
    @Named("api_base_url")
    public String provideApiBaseUrl() {
        return "http://www.giantbomb.com/api";
    }

    @Provides
    public GameRepository provideGameRepository(@Named("api_base_url") String endPoint) {
        return new RestGameRepository(endPoint);
    }

    @Provides
    @Named("mock_api")
    public GameRepository provideGameRepository() {
        return new MockGameRepository();
    }
}
