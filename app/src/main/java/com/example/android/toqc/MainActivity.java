package com.example.android.toqc;

import android.os.Build;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.android.toqc.fragments.ShowCategoryFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initToolbar();
        if (savedInstanceState == null && Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new ShowCategoryFragment())
                    .commit();
        }
    }

    @Override
    public void onEnterAnimationComplete() {
        super.onEnterAnimationComplete();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, new ShowCategoryFragment())
                .commit();
    }

       private void initToolbar() {
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(R.mipmap.ic_icon);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }
}
