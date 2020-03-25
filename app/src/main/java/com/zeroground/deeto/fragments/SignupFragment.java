package com.zeroground.deeto.fragments;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;

import com.zeroground.deeto.LoginActivity;
import com.zeroground.deeto.R;

import butterknife.ButterKnife;

public class SignupFragment extends Fragment {
    private String title;
    private int page,statusBarHeight;
    public static final int FRAG_POS = 1;
    private TextView tvLogo,tvSubtitle;
    private Toolbar toolbar;


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
        setHasOptionsMenu(true);
        page = getArguments().getInt("pageNo", 0);
        title = getArguments().getString("pageTitle");
        statusBarHeight = ((LoginActivity)getActivity()).getStatusBarHeight();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_signup,container,false);
        toolbar = view.findViewById(R.id.toolbar_signup);
        tvLogo = view.findViewById(R.id.tvLogo_s);
        tvSubtitle = view.findViewById(R.id.tvSubtitle_s);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        toolbar.setPadding(0,statusBarHeight,0,0);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    public void animateLogo(){
        tvLogo.setAlpha(0f);
        ObjectAnimator fadeAnim = ObjectAnimator.ofFloat(tvLogo, View.ALPHA, 1f);
        fadeAnim.setDuration(800);
        fadeAnim.start();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
       if(item.getItemId() == android.R.id.home){
           ((LoginActivity)getActivity()).goToLogin();
           return true;
       }
       return false;
    }
}
