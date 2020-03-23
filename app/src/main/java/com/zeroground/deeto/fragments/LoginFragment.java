package com.zeroground.deeto.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.zeroground.deeto.R;

public class LoginFragment extends Fragment {

    private String title;
    private int page;

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
        return inflater.inflate(R.layout.frag_login,container,false);
    }
}
