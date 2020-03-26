package com.zeroground.deeto.fragments;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
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
    private LinearLayout btnLayout;
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
        btnLayout = view.findViewById(R.id.ll_btnSignup);
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
        //views init
        tvLogo.setAlpha(0f);
        tvSubtitle.setAlpha(0f);
        tvLogo.setTranslationX(-200);
        btnLayout.setTranslationY(200);
        btnLayout.setAlpha(0f);
        //Logo anim
        ObjectAnimator moveAnim = ObjectAnimator.ofFloat(tvLogo,View.TRANSLATION_X,0);
        moveAnim.setDuration(400);
        moveAnim.setInterpolator(new DecelerateInterpolator());
        //logo animator
        AnimatorSet logoSet = new AnimatorSet();
        logoSet.playTogether(
                ObjectAnimator.ofFloat(tvLogo, View.ALPHA, 1f).setDuration(400),
                moveAnim
        );
        //Subtitle anim
        ObjectAnimator subtitleFade = ObjectAnimator.ofFloat(tvSubtitle,View.ALPHA,1f).setDuration(500);
        //title animator
        AnimatorSet titleSet = new AnimatorSet();
        titleSet.play(logoSet).with(subtitleFade);
        //BTN Layout anim
        ObjectAnimator y_tr = ObjectAnimator.ofFloat(btnLayout,View.TRANSLATION_Y,0);
        y_tr.setDuration(500);
        y_tr.setInterpolator(new DecelerateInterpolator());
        //btn animator
        AnimatorSet btnLaySet = new AnimatorSet();
        btnLaySet.playTogether(
                y_tr,
                ObjectAnimator.ofFloat(btnLayout,View.ALPHA,1f).setDuration(400)
        );
        //Main Set
        AnimatorSet mainSet = new AnimatorSet();
        mainSet.play(titleSet).before(btnLaySet);
        mainSet.start();
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
