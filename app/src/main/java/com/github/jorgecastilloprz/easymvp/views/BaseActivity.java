package com.github.jorgecastilloprz.easymvp.views;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.github.jorgecastilloprz.easymvp.EasyMVPApplication;
import com.github.jorgecastilloprz.easymvp.di.ActivityModule;

import java.util.List;

import butterknife.ButterKnife;
import dagger.ObjectGraph;

/**
 * BaseActivity will be extended by every activity in the app, and it hides
 * common logic for concrete activities, like initial dependency and view injects
 * <p/>
 * Created by jorge on 10/01/15.
 */
public abstract class BaseActivity extends ActionBarActivity {

    private ObjectGraph activityScopeGraph;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        injectDependencies();
        injectViews();
    }

    /**
     * Concrete modules needed to generate activity scope graph. They will be added by descendant 
     * activities.
     *  
     * @return
     */
    protected abstract List<Object> getModules();

    /**
     * Activity scope graph injection shortcut
     *
     * @param entityToGetInjected will satisfy its dependencies by this method
     */
    public void inject(Object entityToGetInjected) {
        activityScopeGraph.inject(entityToGetInjected);
    }

    /**
     * Used to
     */
    private void injectDependencies() {
        EasyMVPApplication easyMVPApplication = (EasyMVPApplication) getApplication();

        List<Object> activityScopeModules = getModules();
        activityScopeModules.add(new ActivityModule(this));
        activityScopeGraph = easyMVPApplication.buildGraphWithAditionalModules(activityScopeModules);
        inject(this);
    }

    private void injectViews() {
        ButterKnife.inject(this);
    }
}
