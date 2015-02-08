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
package com.github.jorgecastilloprz.easymvp.mvp.presenters;

import com.github.jorgecastilloprz.easymvp.mvp.model.Game;

import javax.inject.Inject;

/**
 * @author Jorge Castillo Pérez
 */
public class GameDetailsPresenterImpl implements LifecycleCallbacks, GameDetailsPresenter {

    private View view;
    private Game gameModel;
   
    @Inject
    public GameDetailsPresenterImpl() {}
    
    public void setView(View view) {
        if (view == null) {
            throw new IllegalArgumentException("View must not be null!");
        }
        this.view = view;
    }
    
    public void setGameModel(Game gameModel) {
        if (gameModel == null) {
            throw new IllegalArgumentException("Game model must not be null!");
        }
        this.gameModel = gameModel;
    }
    
    @Override
    public void onStart() {
        view.loadBackgroundImage(gameModel.getImage());
    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onBackgroundLoaded() {
        view.setInterfaceColors();
    }

    public interface View {
        
        void loadBackgroundImage(String imageUrl);
        
        void setInterfaceColors();
    }
}
