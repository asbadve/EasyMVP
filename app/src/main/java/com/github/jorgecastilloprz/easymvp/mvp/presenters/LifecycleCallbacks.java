package com.github.jorgecastilloprz.easymvp.mvp.presenters;

/**
 * Android lifecycle callbacks from activities/fragments are linked to the Presenters by this 
 * behavior interface. Linking callbacks is declared as an optional behavior and not a need for
 * every presenter.
 *
 * @author Jorge Castillo Pérez
 */
public interface LifecycleCallbacks {
    abstract void onStart();
    public abstract void onResume();
    public abstract void onPause();
}
