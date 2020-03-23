package com.zeroground.deeto.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.zeroground.deeto.fragments.LoginFragment;
import com.zeroground.deeto.fragments.SignupFragment;

public class LoginPagerAdapter extends FragmentPagerAdapter {
    public static final int NUM_PAGES = 2;

    public LoginPagerAdapter(@NonNull FragmentManager fm) {
        super(fm, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return LoginFragment.newInstance(0, "Login");
            case 1:
                return SignupFragment.newInstance(1, "Sign Up");
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return NUM_PAGES;
    }
}
