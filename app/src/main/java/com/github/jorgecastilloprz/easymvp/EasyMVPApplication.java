package com.github.jorgecastilloprz.easymvp;

import android.app.Application;

import com.github.jorgecastilloprz.easymvp.di.RootModule;

import java.util.List;

import dagger.ObjectGraph;

/**
 * Created by jorge on 10/01/15.
 */
public class EasyMVPApplication extends Application {

    private ObjectGraph objectGraph;

    @Override
    public void onCreate() {
        super.onCreate();
        initDependencyInjection();
    }

    /**
     * Object graph injection shortcut for injectable classes
     *
     * @param object instance to get injected
     */
    public void inject(Object object) {
        objectGraph.inject(object);
    }

    /**
     * Used to obtain a new graph with aditional modules from a concrete scope.
     * Original graph does not get modified by this method
     *
     * @param modules to be added
     * @return
     */
    public ObjectGraph buildGraphWithAditionalModules(List<Object> modules) {
        if (modules == null) {
            throw new IllegalArgumentException(
                    "You can't plus a null module, review your getModules() implementation");
        }
        return objectGraph.plus(modules.toArray());
    }

    private void initDependencyInjection() {
        objectGraph = ObjectGraph.create(new RootModule(this));
        objectGraph.inject(this);
        objectGraph.injectStatics();
    }
}
