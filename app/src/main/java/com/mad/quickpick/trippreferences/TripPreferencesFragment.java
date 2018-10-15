package com.mad.quickpick.trippreferences;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.Spinner;

import com.mad.quickpick.R;

import butterknife.BindView;

import static com.google.android.gms.common.internal.Preconditions.checkNotNull;

/**
 * A placeholder fragment containing a simple view.
 */
public class TripPreferencesFragment extends Fragment implements TripPreferencesInterface.View {

    private static final String TAG = "TripPreferences";

    @BindView(R.id.preferences_how_much_spinner)
    public Spinner mHowMuchSpinner;

//    @BindView(R.id.preferences_location_selected_tv)
//    public TextView mWhereToTV;

    @BindView(R.id.preferences_eat_checkbox)
    public CheckBox mEatCheckBox;

    @BindView(R.id.preferences_drink_checkbox)
    public CheckBox mDrinkCheckBox;

    @BindView(R.id.preferences_explore_checkbox)
    public CheckBox mExploreCheckBox;

    @BindView(R.id.preferences_relax_checkbox)
    public CheckBox mRelaxCheckBox;

//    @BindView(R.id.preferences_where_to_button)
//    public Button mWhereToButton;

    private static final int REQUEST_CODE_AUTOCOMPLETE = 1;

    private TripPreferencesInterface.Presenter mPresenter;

    public TripPreferencesFragment() {
    }

    public static TripPreferencesFragment newInstance() {
        return new TripPreferencesFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_trip_preferences, container, false);


    }



    @Override
    public void setPresenter(TripPreferencesInterface.Presenter presenter) {
        mPresenter = checkNotNull(presenter);

    }


}
