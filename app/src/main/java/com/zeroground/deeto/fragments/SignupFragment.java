package com.zeroground.deeto.fragments;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.zeroground.deeto.R;

public class SignupFragment extends Fragment {
    private String title;
    private int page;
    public static final int FRAG_POS = 1;
    private TextView tvLogo,tvSubtitle;

    public static SignupFragment newInstance(int page, String title) {
        SignupFragment fragmentFirst = new SignupFragment();
        Bundle args = new Bundle();
        args.putInt("pageNo", page);
        args.putString("pageTitle", title);
        fragmentFirst.setArguments(args);
        return fragmentFirst;
    }

    // Store instance variables based on arguments passed
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = getArguments().getInt("pageNo", 0);
        title = getArguments().getString("pageTitle");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_signup,container,false);
        tvLogo = view.findViewById(R.id.tvLogo_s);
        tvSubtitle = view.findViewById(R.id.tvSubtitle_s);
        return view;
    }

    public void animateLogo(int position){
        if(position==FRAG_POS){
            ObjectAnimator fadeAnim = ObjectAnimator.ofFloat(tvLogo, View.ALPHA, 1f);
            fadeAnim.start();
        }else{
            ObjectAnimator fadeAnim = ObjectAnimator.ofFloat(tvLogo, View.ALPHA, 0f);
            fadeAnim.start();
        }
    }
}
