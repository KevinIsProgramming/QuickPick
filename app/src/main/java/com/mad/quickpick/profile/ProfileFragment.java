package com.mad.quickpick.profile;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.SignInButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.mad.quickpick.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class ProfileFragment extends Fragment {



    private ImageView mProfilePictureIv;
    private FirebaseAuth mAuth;
    Unbinder unbinder;

    @BindView(R.id.profile_no_user_layout)
    public LinearLayout mNoUserLayout;

    @BindView(R.id.profile_relative_layout)
    public RelativeLayout mUserLoggedInLayout;

    @BindView(R.id.profile_sign_in_button)
    public SignInButton mSignInButton;

//    @BindView(R.id.profile_progress_bar)
//    public ProgressBar mUserProgressBar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.profile_fragment, null);

        ImageView mProfilePictureIv = view.findViewById(R.id.profile_user_image);
        TextView mUserNameTv = view.findViewById(R.id.profile_user_name);
        TextView mAboutMeTv = view.findViewById(R.id.profile_about_me_paragraph_tv);

        unbinder = ButterKnife.bind(this, view);
        loadProfileFromFirestore();
        return view;
    }

    @OnClick(R.id.profile_sign_in_button)
    public void OpenSignInActivity(){
//        Intent googleSignInIntent = new Intent(getActivity(), GoogleSignInActivity.class);
//        startActivity(googleSignInIntent);
//        mUserLoggedInLayout.setVisibility(View.VISIBLE);
//        Toast.makeText(getContext(), "You are signed in", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.profile_sign_out_button)
    void signOut(){
        FirebaseAuth.getInstance().signOut();
        Toast.makeText(getContext(), "You are signed out", Toast.LENGTH_SHORT).show();
        mUserLoggedInLayout.setVisibility(View.GONE);
        mNoUserLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public ProfileFragment() {

    }

    private void loadProfileFromFirestore() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            mUserLoggedInLayout.setVisibility(View.VISIBLE);
            Toast.makeText(getContext(), "You are signed in", Toast.LENGTH_SHORT).show();

        } else {
            mNoUserLayout.setVisibility(View.VISIBLE);
            Toast.makeText(getContext(), "You are not signed in, Please sign in", Toast.LENGTH_SHORT).show();

        }
    }

}
