package com.github.jorgecastilloprz.easymvp.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import butterknife.ButterKnife;

/**
 * Created by jorge on 2/02/15.
 */
public class BaseFragment extends Fragment {

    @Override public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        injectViews(view);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        injectDependencies();
    }

    /**
     * ButterKnife injection
     * @param view
     */
    private void injectViews(View view) {
        ButterKnife.inject(this, view);
    }

    /**
     * Dagger injection using activity graph scope
     */
    private void injectDependencies() {
        ((BaseActivity) getActivity()).inject(this);
    }
}
