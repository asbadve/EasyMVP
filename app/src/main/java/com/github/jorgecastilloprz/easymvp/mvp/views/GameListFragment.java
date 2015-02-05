package com.github.jorgecastilloprz.easymvp.mvp.views;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.github.jorgecastilloprz.easymvp.R;
import com.github.jorgecastilloprz.easymvp.mvp.model.Game;
import com.github.jorgecastilloprz.easymvp.mvp.presenters.GameListPresenterImpl;
import com.github.jorgecastilloprz.easymvp.ui.BaseFragment;
import com.github.jorgecastilloprz.easymvp.ui.adapters.GameStaggeredAdapter;
import com.melnykov.fab.FloatingActionButton;

import java.util.List;

import javax.inject.Inject;

import butterknife.InjectView;

/**
 * Holds a Game List into a {@link RecyclerView} component ported by appCompat v7 library. User can 
 * click on FAB to refresh the list*. Views and dependencies are injected in BaseFragment through 
 * the activity scope graph
 *
 * Created by jorge on 24/01/15.
 */
public class GameListFragment extends BaseFragment implements GameStaggeredAdapter.OnItemClickListener, GameListPresenterImpl.View {

    @Inject Context activityContext;
    @Inject GameListPresenterImpl gameListPresenter;
    @Inject
    GameStaggeredAdapter gameAdapter;

    @InjectView(R.id.fab) FloatingActionButton fabButton;
    @InjectView(R.id.gameRecyclerView) RecyclerView gameRecyclerView;
    
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_game_list, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initGameRecyclerView();
        setPresenterView();
        gameListPresenter.onStart();
    }

    private void initGameRecyclerView() {
        
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        staggeredGridLayoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS);
        gameRecyclerView.setLayoutManager(staggeredGridLayoutManager);
        
        gameAdapter.setOnItemClickListener(this);
        gameRecyclerView.setAdapter(gameAdapter);
    }

    private void setPresenterView() {
        gameListPresenter.setView(this);
    }

    /**
     * Ask for new games on start
     */
    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        gameListPresenter.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        gameListPresenter.onPause();
    }

    @Override
    public void onItemClick(View view, Game game) {
        gameListPresenter.onGameClick();
    }


    @Override
    public void drawGames(List<Game> games) {
        gameAdapter.setGameCollection(games);
        gameAdapter.notifyDataSetChanged();
        fabButton.attachToRecyclerView(gameRecyclerView);
    }

    @Override
    public void displayConnectionError() {
        Toast.makeText(activityContext, getString(R.string.connection_error), Toast.LENGTH_LONG).show();
    }

    @Override
    public void displayGettingGamesError(String errorMessage) {
        Toast.makeText(activityContext, getString(R.string.connection_error), Toast.LENGTH_LONG).show();
    }

    @Override
    public void showGameDetails() {

    }

    @Override
    public void displayLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
