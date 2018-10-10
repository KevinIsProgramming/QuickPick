package com.mad.quickpick.home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.mad.quickpick.R;
import com.mad.quickpick.profile.ProfileActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static com.google.android.gms.common.internal.Preconditions.checkNotNull;

public class HomeFragment extends Fragment implements HomeInterface.View{

    private HomeInterface.Presenter mPresenter;

    @BindView(R.id.get_started_button)
    public Button mGetStartedButton;

    @BindView(R.id.my_places_button)
    public Button mMyPlacesButton;

    Unbinder unbinder;

    public HomeFragment() {

    }

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
    }

    @Override
    public void setPresenter(@NonNull HomeInterface.Presenter presenter) {
        mPresenter = checkNotNull(presenter);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.home_fragment, null);

        unbinder = ButterKnife.bind(this, mView);

        return mView;
    }

    @OnClick(R.id.get_started_button)
    public void onGetStartedClicked(){
        mPresenter.startIntent(getActivity(), ProfileActivity.class);
    }

    @OnClick(R.id.my_places_button)
    public void onMyPlacesClicked(){
        mPresenter.startIntent(getActivity(), ProfileActivity.class);
    }


//    @Override
//    public void onClick(View view) {
//        switch (view.getId()){
//            case R.id.get_started_button:
////                Intent tripIntent = new Intent(getActivity(), TripPreferencesActivity.class);
////                startActivity(tripIntent);
//                mPresenter.startIntent(getActivity(), TripPreferencesActivity.class);
//                break;
//            case R.id.my_places_button:
////                Intent loginIntent = new Intent(getActivity(), GoogleSignInActivity.class);
////                startActivity(loginIntent);
//                break;
//
//        }
//    }
}
