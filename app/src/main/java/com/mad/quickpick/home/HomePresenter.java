package com.mad.quickpick.home;

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



}
