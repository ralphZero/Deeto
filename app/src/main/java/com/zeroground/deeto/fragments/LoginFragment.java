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

import com.zeroground.deeto.LoginActivity;
import com.zeroground.deeto.R;

public class LoginFragment extends Fragment {

    private String title;
    private int page;
    private TextView tvLogo;
    private TextView tvSubtitle,tvSignupNow;
    public static final int FRAG_POS = 0;

    public static LoginFragment newInstance(int page, String title) {
        LoginFragment fragmentFirst = new LoginFragment();
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
        View view = inflater.inflate(R.layout.frag_login,container,false);
        tvLogo = view.findViewById(R.id.tvLogo_l);
        tvSubtitle = view.findViewById(R.id.tvSubtitle_l);
        tvSignupNow = view.findViewById(R.id.tv_signupnow);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvSignupNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((LoginActivity)getActivity()).goToSignup();
            }
        });
    }

    public void animateLogo(){
        tvLogo.setAlpha(0f);
        ObjectAnimator fadeAnim = ObjectAnimator.ofFloat(tvLogo, View.ALPHA, 1f);
        fadeAnim.setDuration(800);
        fadeAnim.start();
    }
}
