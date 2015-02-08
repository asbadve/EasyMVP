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
package com.github.jorgecastilloprz.easymvp.mvp.views;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.Toolbar;
import android.transition.Slide;
import android.view.Window;
import android.widget.ImageView;

import com.github.jorgecastilloprz.easymvp.R;
import com.github.jorgecastilloprz.easymvp.mvp.model.Game;
import com.github.jorgecastilloprz.easymvp.mvp.presenters.GameDetailsPresenterImpl;
import com.github.jorgecastilloprz.easymvp.ui.BaseActivity;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.List;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Delegates all its presentation logic into the GameDetailsPresenter. Game model needs to be passed 
 * to it at the beginning.
 *
 * @author Jorge Castillo Pérez
 */
public class DetailsActivity extends BaseActivity implements GameDetailsPresenterImpl.View {

    public static final String GAME_EXTRA = "com.github.jorgecastilloprz.easymvp.gameExtra";
    public static final String SHARED_IMAGE_EXTRA = "sharedImage";

    @Inject GameDetailsPresenterImpl gameDetailsPresenter;
    
    @InjectView(R.id.detailsToolbar)
    Toolbar toolbar;
    @InjectView(R.id.backgroundImage)
    ImageView bgImage;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        setContentView(R.layout.activity_details);
        super.onCreate(savedInstanceState);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        excludeItemsFromTransitionIfLollipop();
        setImageTransition();
        
        Game game = Parcels.unwrap(getIntent().getExtras().getParcelable(GAME_EXTRA));

        setPresenterView();
        setPresenterGameModel(game);
    }

    private void setPresenterView() {
        gameDetailsPresenter.setView(this);
    }

    private void setPresenterGameModel(Game game) {
        gameDetailsPresenter.setGameModel(game);
    }
    
    @Override
    protected void onStart() {
        super.onStart();
        gameDetailsPresenter.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        gameDetailsPresenter.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        gameDetailsPresenter.onPause();
    }

    private void excludeItemsFromTransitionIfLollipop() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Slide transition = new Slide();
            transition.excludeTarget(android.R.id.statusBarBackground, true);
            transition.excludeTarget(R.id.detailsToolbar, true);
            getWindow().setEnterTransition(transition);
            getWindow().setReturnTransition(transition);
        }
    }

    private void setImageTransition() {
        final ImageView image = (ImageView) findViewById(R.id.backgroundImage);
        ViewCompat.setTransitionName(image, SHARED_IMAGE_EXTRA);
    }

    /**
     * Load bg image and notify presenter to react
     * @param imageUrl
     */
    @Override
    public void loadBackgroundImage(String imageUrl) {
        Picasso.with(this).load(imageUrl).into(bgImage, new Callback() {
            @Override public void onSuccess() {
                gameDetailsPresenter.onBackgroundLoaded();
            }

            @Override public void onError() {}
        });
    }

    @Override
    public void setInterfaceColors() {
        Bitmap bitmap = ((BitmapDrawable) bgImage.getDrawable()).getBitmap();
        Palette.generateAsync(bitmap, new Palette.PaletteAsyncListener() {
            public void onGenerated(Palette palette) {
                setInterfaceColors(palette);
            }
        });
    }

    /**
     * We use palette to calculate the color palette to be used in main interface widgets (status
     * bar, toolbar). Default app colors are passed to palette methods for cases when it is not
     * capable of generating the colors because of low contrast on image.
     * @param palette
     */
    private void setInterfaceColors(Palette palette) {
        int primaryDark = getResources().getColor(R.color.fab_primary_pressed);
        int primary = getResources().getColor(R.color.fab_primary);
        toolbar.setBackgroundColor(palette.getMutedColor(primary));
        setStatusBarcolorIfLollipop(getWindow(), palette.getDarkMutedColor(primaryDark));
    }

    private void setStatusBarcolorIfLollipop(Window window, int color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(color);
        }
    }
    
    @Override
    protected List<Object> getModules() {
        return null;
    }
}
