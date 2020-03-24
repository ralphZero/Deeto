package com.zeroground.deeto;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.zeroground.deeto.adapters.LoginPagerAdapter;
import com.zeroground.deeto.fragments.LoginFragment;
import com.zeroground.deeto.fragments.SignupFragment;

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
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            // This method will be invoked when a new page becomes selected.
            @Override
            public void onPageSelected(int position) {
                Toast.makeText(LoginActivity.this,
                        "Selected page position: " + position, Toast.LENGTH_SHORT).show();
                LoginFragment loginFragment = (LoginFragment) adapter.getRegisteredFragment(0);
                loginFragment.animateLogo(position);
                SignupFragment signupFragment = (SignupFragment)adapter.getRegisteredFragment(1);
                signupFragment.animateLogo(position);
            }

            // This method will be invoked when the current page is scrolled
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                // Code goes here
                //Log.i("vwpager","Position: "+position+" Offset: "+positionOffset+" PixelOffset: "+positionOffsetPixels);
            }

            // Called when the scroll state changes:
            // SCROLL_STATE_IDLE, SCROLL_STATE_DRAGGING, SCROLL_STATE_SETTLING
            @Override
            public void onPageScrollStateChanged(int state) {
                // Code goes here
            }
        });
    }
}
