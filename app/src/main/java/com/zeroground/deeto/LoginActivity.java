package com.zeroground.deeto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.zeroground.deeto.adapters.LoginPagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {

    LoginPagerAdapter adapter;
    @BindView(R.id.vwpager_login)
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        adapter = new LoginPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
    }
}
