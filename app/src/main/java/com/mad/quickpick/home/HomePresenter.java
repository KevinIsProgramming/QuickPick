package com.mad.quickpick.home;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;

import static com.google.android.gms.common.internal.Preconditions.checkNotNull;

public class HomePresenter implements HomeInterface.Presenter {

    private final HomeInterface.View mHomeView;

    public HomePresenter(@NonNull HomeInterface.View homeView) {
        mHomeView = checkNotNull(homeView, "homeView cannot be null!");

        mHomeView.setPresenter(this);
    }

    @Override
    public void start() {
    }

    public void startIntent(Activity activity, Class c) {
        Intent intent = new Intent(activity, c);
        activity.startActivity(intent);
    }

    @Override
    public void loadTripPreferences() {
//        Intent tripIntent = new Intent(HomeActivity.this(), TripPreferencesActivity.class);
//        startActivity(tripIntent);
    }
}
