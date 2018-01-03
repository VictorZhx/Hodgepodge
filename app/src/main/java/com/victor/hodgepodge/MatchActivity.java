package com.victor.hodgepodge;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.MenuItem;

import com.victor.hodgepodge.base.BaseActivity;
import com.victor.hodgepodge.home.HomeFragment;
import com.victor.hodgepodge.personal.PersonalFragment;
import com.victor.hodgepodge.sightvision.SightVisionFragment;

/**
 * Created by victor on 17-8-17.
 */

public class MatchActivity extends BaseActivity {
    private static final String TAG = "MatchActivity";

    private BottomNavigationView navigationView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, " onCreate--> : ");
        navigationView = (BottomNavigationView) findViewById(R.id.navigation);
//        Log.i(TAG, " onCreate --> : ");
//        MatchFood matchFood = new MatchFood();
//        matchFood.init();
//        matchFood.matchFoodByMaterial();

        initClick();
        initNavigation();


        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        fragmentTransaction.add(R.id.main_content, SightVisionFragment.FragmentInstance.getInstance()).commit();


    }

    private void initNavigation() {

        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {

                    case R.id.navigation_home:


                        if (!SightVisionFragment.FragmentInstance.getInstance().isAdded()) {
                            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                            fragmentTransaction.replace(R.id.main_content, SightVisionFragment.FragmentInstance.getInstance()).commit();

                        }

                        break;

                    case R.id.navigation_dashboard:

                        if (!HomeFragment.FragmentInstance.getInstance().isAdded()) {
                            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                            fragmentTransaction.replace(R.id.main_content, HomeFragment.FragmentInstance.getInstance()).commit();

                        }
                        break;

                    case R.id.navigation_notifications:

                        if (!PersonalFragment.FragmentInstance.getInstance().isAdded()) {
                            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                            fragmentTransaction.replace(R.id.main_content, PersonalFragment.FragmentInstance.getInstance()).commit();

                        }
                        break;
                }
                return false;
            }
        });
    }

    private void initClick() {
    }


}
