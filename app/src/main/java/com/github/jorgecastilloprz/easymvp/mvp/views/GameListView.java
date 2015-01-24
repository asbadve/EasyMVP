package com.github.jorgecastilloprz.easymvp.mvp.views;

/**
 * View behavior implemented by GameListFragment. Used to allow loading animations and model 
 * drawing
 * *
 * Created by jorge on 24/01/15.
 */
public interface GameListView {
    void displayLoadingAnimation();
    void hideLoadingAnimation();
}
