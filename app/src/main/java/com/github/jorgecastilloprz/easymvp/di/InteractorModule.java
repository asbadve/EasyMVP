/*
 * Copyright (C) 2014 Jorge Castillo Pérez
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.jorgecastilloprz.easymvp.di;

import com.github.jorgecastilloprz.easymvp.mvp.interactors.CheckConnectionInteractor;
import com.github.jorgecastilloprz.easymvp.mvp.interactors.CheckConnectionInteractorImpl;
import com.github.jorgecastilloprz.easymvp.mvp.interactors.GetGamesByPageInteractor;
import com.github.jorgecastilloprz.easymvp.mvp.interactors.GetGamesByPageInteractorImpl;
import com.github.jorgecastilloprz.easymvp.mvp.presenters.GameListPresenterImpl;
import com.github.jorgecastilloprz.easymvp.mvp.views.GameListFragment;

import dagger.Module;
import dagger.Provides;

/**
 * Interactor injection module
 *
 * @author Jorge Castillo Pérez
 */
@Module(
        library = true, complete = false
)
public class InteractorModule {
    
    @Provides
    GetGamesByPageInteractor provideGetGamesByPageInteractor(GetGamesByPageInteractorImpl getGamesByPageInteractor) {
        return getGamesByPageInteractor;
    }

    @Provides
    CheckConnectionInteractor provideCheckConnectionInteractor(CheckConnectionInteractorImpl checkConnectionInteractor) {
        return checkConnectionInteractor;
    }
}
