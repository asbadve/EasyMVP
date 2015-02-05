package com.github.jorgecastilloprz.easymvp.ui;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import com.github.jorgecastilloprz.easymvp.R;
import java.util.List;


public class MainActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Toolbar myToolbar = (Toolbar) findViewById(R.id.myToolbar);
        setSupportActionBar(myToolbar);
    }

    @Override
    protected List<Object> getModules() {
        return null;
    }
}
