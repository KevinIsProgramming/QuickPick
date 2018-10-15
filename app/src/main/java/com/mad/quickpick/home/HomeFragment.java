package com.mad.quickpick.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.mad.quickpick.R;
import com.mad.quickpick.test.CurrentLocationNearByPlacesActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static com.google.android.gms.common.internal.Preconditions.checkNotNull;


/**
 * A placeholder fragment containing a simple view.
 */
public class HomeFragment extends Fragment implements HomeInterface.View{

    private HomeInterface.Presenter mPresenter;

    public HomeFragment() {
        //Requires empty public constructor
    }

    Unbinder unbinder;

    @BindView(R.id.get_started_button)
    public Button getStartedButton;


    public static HomeFragment newInstance(){
        return new HomeFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View homeView = inflater.inflate(R.layout.fragment_home, container, false);

        unbinder = ButterKnife.bind(this, homeView);

        return homeView;
    }

    @Override
    public void setPresenter(HomeInterface.Presenter presenter) {
        mPresenter = checkNotNull(presenter);
    }

    @OnClick(R.id.get_started_button)
    void startTest(){
        Intent testIntent = new Intent(getActivity(), CurrentLocationNearByPlacesActivity.class);
        startActivity(testIntent);
    }
}
