package com.mad.quickpick.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.mad.quickpick.R;

public class ForumsFragment extends Fragment implements View.OnClickListener{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.forums_fragment, null);

        CardView mGeneralCV = mView.findViewById(R.id.forums_general);
        CardView mOffTopicCV = mView.findViewById(R.id.forums_offtopic);
        CardView mBugCV = mView.findViewById(R.id.forums_bugs);

        mGeneralCV.setOnClickListener(this);
        mOffTopicCV.setOnClickListener(this);
        mBugCV.setOnClickListener(this);

        return mView;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.forums_general:
                Toast.makeText(getActivity(),"General Forum!",Toast.LENGTH_SHORT).show();
                break;
            case R.id.forums_offtopic:
                Toast.makeText(getActivity(),"Off Topic Forum!",Toast.LENGTH_SHORT).show();
                break;
            case R.id.forums_bugs:
                Toast.makeText(getActivity(),"Bug Reporting Forum!",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
