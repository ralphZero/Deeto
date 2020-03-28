package com.zeroground.deeto;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.zeroground.deeto.fragments.AccountFragment;
import com.zeroground.deeto.fragments.HomeFragment;
import com.zeroground.deeto.fragments.MessagesFragment;
import com.zeroground.deeto.fragments.WishlistFragment;
import com.zeroground.deeto.models.CurvedBottomNavigationView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DeetoActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.fl_main)
    FrameLayout frameLayout;
    @BindView(R.id.bottomNavigationBar)
    BottomNavigationView bottomNavigationView;
    @BindView(R.id.bottomAppBar)
    BottomAppBar bottomAppBar;

    FragmentTransaction fts;
    HomeFragment homeFragment;
    WishlistFragment wishlistFragment;
    MessagesFragment messagesFragment;
    AccountFragment accountFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deeto);
        ButterKnife.bind(this);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        homeFragment = HomeFragment.newInstance(1,"home");
        wishlistFragment = WishlistFragment.newInstance(2,"wishlist");
        messagesFragment = MessagesFragment.newInstance(3,"messages");
        accountFragment = AccountFragment.newInstance(4,"account");

        loadFragment(homeFragment);

    }

    public Boolean loadFragment(Fragment fragment){
        if(fragment != null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(frameLayout.getId(), fragment)
                    .commit();
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment;
        switch (menuItem.getItemId()){
            case R.id.ic_bnv_home:
                fragment = homeFragment;
                break;
            case R.id.ic_bnv_favorites:
                fragment = wishlistFragment;
                break;
            case R.id.ic_bnv_messages:
                fragment = messagesFragment;
                break;
            case R.id.ic_bnv_user:
                fragment = accountFragment;
                break;
            default:
                fragment = null;
                break;
        }
        return loadFragment(fragment);
    }
}
