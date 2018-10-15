package com.mad.quickpick.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.mad.quickpick.R;
import com.mad.quickpick.trippreferences.TripPreferencesActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;



public class HomeActivity extends AppCompatActivity {

    private HomePresenter mHomePresenter;

    @BindView(R.id.home_fab)
    public FloatingActionButton homeFab;

//    @BindView(R.id.home_toolbar)
//    public Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.home_toolbar);
        setSupportActionBar(toolbar);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.home_fab)
    public void onFabClick(View view) {
        Intent tripIntent = new Intent(this, TripPreferencesActivity.class);
        startActivity(tripIntent);
    }

}
