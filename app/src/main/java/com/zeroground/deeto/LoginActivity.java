package com.zeroground.deeto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import com.zeroground.deeto.adapters.LoginPagerAdapter;
import com.zeroground.deeto.fragments.LoginFragment;
import com.zeroground.deeto.fragments.SignupFragment;
import com.zeroground.deeto.models.LockableViewPager;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {

    LoginPagerAdapter adapter;
    @BindView(R.id.vwPager)
    LockableViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        adapter  = new LoginPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        viewPager.setSwipeable(false);
    }

    public void goToSignup(){
        viewPager.setCurrentItem(1,true);
        SignupFragment signupFragment = (SignupFragment)adapter.getRegisteredFragment(1);
        signupFragment.animateLogo();
    }

    public void goToLogin(){
        viewPager.setCurrentItem(0,true);
        LoginFragment loginFragment = (LoginFragment)adapter.getRegisteredFragment(0);
        loginFragment.animateLogo();
    }

    public int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    @Override
    public void onBackPressed() {
        if(viewPager.getCurrentItem()==1)
            goToLogin();
        else
            super.onBackPressed();
    }
}
