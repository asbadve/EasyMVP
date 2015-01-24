package com.github.jorgecastilloprz.easymvp.ui;

import android.content.Context;
import android.content.Intent;

import com.github.jorgecastilloprz.easymvp.di.qualifiers.ActivityContext;

import javax.inject.Inject;

/**
 * Entity used to implement navigation between activities and fragments
 * * * 
 * Created by jorge on 17/01/15.
 */
public class Navigator {
    
    private final Context activityContext;
    
    @Inject
    public Navigator(@ActivityContext Context activityContext) {
        this.activityContext = activityContext;
    }
    
    public void openDetailsActivity() {
        Intent detailsActivityIntent = new Intent(activityContext, DetailsActivity.class);
        activityContext.startActivity(detailsActivityIntent);
    }
}
