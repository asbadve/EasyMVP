package com.github.jorgecastilloprz.easymvp.domain.restmodel;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jorge on 24/01/15.
 */
public class GiantBombGameListResponse extends GiantBombResponse {

    @Expose
    private List<Result> results = new ArrayList<Result>();
    
    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }
}
