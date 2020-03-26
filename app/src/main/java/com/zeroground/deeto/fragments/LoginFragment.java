package com.zeroground.deeto.fragments;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.zeroground.deeto.DeetoActivity;
import com.zeroground.deeto.LoginActivity;
import com.zeroground.deeto.R;

public class LoginFragment extends Fragment {

    private String title;
    private int page, statusBarHeight;
    private TextView tvLogo;
    private View view_l;
    private TextView tvSubtitle,tvSignupNow;
    private LinearLayout btnLayout;
    private Button btnLoginGoogle;

    public static LoginFragment newInstance(int page, String title) {
        LoginFragment fragmentFirst = new LoginFragment();
        Bundle args = new Bundle();
        args.putInt("pageNo", page);
        args.putString("pageTitle", title);
        fragmentFirst.setArguments(args);
        return fragmentFirst;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = getArguments().getInt("pageNo", 0);
        title = getArguments().getString("pageTitle");
        statusBarHeight = ((LoginActivity)getActivity()).getStatusBarHeight();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_login,container,false);
        tvLogo = view.findViewById(R.id.tvLogo_l);
        tvSubtitle = view.findViewById(R.id.tvSubtitle_l);
        tvSignupNow = view.findViewById(R.id.tv_signupnow);
        view_l = view.findViewById(R.id.view_l);
        btnLayout = view.findViewById(R.id.ll_loginBtn);
        btnLoginGoogle = view.findViewById(R.id.btn_login_google);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view_l.setPadding(0,statusBarHeight,0,0);
        welcomeAnim();
        tvSignupNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((LoginActivity)getActivity()).goToSignup();
            }
        });
        btnLoginGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), DeetoActivity.class);
                getActivity().startActivity(intent);
                getActivity().finish();
            }
        });
    }

    public void animateLogo(){
        //views init
        tvLogo.setAlpha(0f);
        tvSubtitle.setAlpha(0f);
        tvLogo.setTranslationX(200);
        btnLayout.setAlpha(0f);
        btnLayout.setTranslationY(200);
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
        //Title animator
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

    public void welcomeAnim(){
        tvLogo.setAlpha(0f);
        tvSubtitle.setAlpha(0f);
        AnimatorSet set = new AnimatorSet();
        set.playSequentially(
                ObjectAnimator.ofFloat(tvLogo,View.ALPHA,1f).setDuration(600),
                ObjectAnimator.ofFloat(tvSubtitle,View.ALPHA,1f).setDuration(600)
        );
        set.start();
    }
}
