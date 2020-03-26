package com.zeroground.deeto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.zeroground.deeto.models.CurvedBottomNavigationView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DeetoActivity extends AppCompatActivity {

    @BindView(R.id.fl_main)
    FrameLayout frameLayout;
    @BindView(R.id.curvedNavigationView)
    CurvedBottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deeto);
        ButterKnife.bind(this);

        bottomNavigationView.getmPaint().setColor(getResources().getColor(R.color.colorWhitish));
    }
}
