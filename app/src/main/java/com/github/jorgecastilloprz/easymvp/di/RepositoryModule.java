package com.github.jorgecastilloprz.easymvp.di;

import com.github.jorgecastilloprz.easymvp.domain.repository.GameRepository;
import com.github.jorgecastilloprz.easymvp.domain.repository.GiantBombRestGameRepository;
import com.github.jorgecastilloprz.easymvp.domain.repository.MockGameRepository;
import com.github.jorgecastilloprz.easymvp.domain.repository.mapper.ApiResponseMapper;
import com.github.jorgecastilloprz.easymvp.domain.repository.mapper.GiantBombResponseMapper;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Dagger module for repository injects
 * * *
 * Created by jorge on 18/01/15.
 */

@Module(
        injects = {GiantBombRestGameRepository.class},
        complete = false, library = true)
public class RepositoryModule {

    private final String apiKey = "07dce392be760422f40d67bc7945d7f1aaac7f4e";
    private final String apiBaseUrl = "http://www.giantbomb.com/api";

    @Provides
    @Named("api_key")
    public String provideApiKey() {
        return apiKey;
    }

    @Provides
    @Named("api_base_url")
    public String provideApiBaseUrl() {
        return apiBaseUrl;
    }
    
    @Provides
    @Singleton
    public ApiResponseMapper provideApiResponseMapper() {
        return new GiantBombResponseMapper();
    } 

    @Provides
    public GameRepository provideGameRepository(@Named("api_base_url") String apiBaseUrl, @Named("api_key") String apiKey, ApiResponseMapper responseMapper) {
        return new GiantBombRestGameRepository(apiBaseUrl, apiKey, responseMapper);
    }

    @Provides
    @Named("mock_api")
    public GameRepository provideMockGameRepository() {
        return new MockGameRepository();
    }
}
