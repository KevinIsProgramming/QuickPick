package com.mad.quickpick.trippreferences;

import android.app.Activity;

import com.mad.quickpick.BasePresenter;
import com.mad.quickpick.BaseView;

public interface TripPreferencesInterface {

    interface View extends BaseView<TripPreferencesInterface.Presenter>{

    }

    interface Presenter extends BasePresenter {
        void startIntent(Activity activity, Class c);

        void openAutocompleteActivity();
    }
}
