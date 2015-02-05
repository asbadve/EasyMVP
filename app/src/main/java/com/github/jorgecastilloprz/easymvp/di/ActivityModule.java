package com.github.jorgecastilloprz.easymvp.di;

import android.app.Activity;
import android.content.Context;

import com.github.jorgecastilloprz.easymvp.di.qualifiers.ActivityContext;
import com.github.jorgecastilloprz.easymvp.ui.DetailsActivity;
import com.github.jorgecastilloprz.easymvp.ui.MainActivity;
import com.github.jorgecastilloprz.easymvp.ui.adapters.GameStaggeredAdapter;

import dagger.Module;
import dagger.Provides;

/**
 * Dependency injection module used to provide activity scope context and satisfy activity/fragment
 * dependency needs
 *
 * @author Jorge Castillo Pérez
 */

@Module(
        injects = {MainActivity.class, DetailsActivity.class},
        library = true
)
public class ActivityModule {

    private final Activity activityContext;

    public ActivityModule(Activity activityContext) {
        this.activityContext = activityContext;
    }

    @Provides
    @ActivityContext
    Context provideActivityContext() {
        return activityContext;
    }
    
    @Provides
    GameStaggeredAdapter gameAdapterProvider() {
        return new GameStaggeredAdapter();
    }
}
