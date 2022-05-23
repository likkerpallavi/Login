package com.example.roommate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public class home extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomnav;
    FrameLayout frames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        bottomnav=findViewById(R.id.bott);
        frames=findViewById(R.id.frame);

        bottomnav.setOnNavigationItemSelectedListener(this);
        bottomnav.setSelectedItemId(R.id.home);
            }
    homena firstFragment = new homena();
    explore secondFragment = new explore();
    mytrips thirdFragment = new mytrips();
    profile fifthFragement=new profile();
    notifications fourthFragment=new notifications();

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.home:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame, firstFragment).commit();
                return true;

            case R.id.explore:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame, secondFragment).commit();
                return true;

            case R.id.mytrips:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame, thirdFragment).commit();
                return true;
            case R.id.notifi:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame, fourthFragment).commit();
                return true;

            case R.id.profile:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame, fifthFragement).commit();
                return true;

        }
        return false;
    }


    private void replace(Fragment fragment) {
        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame,fragment);
        transaction.commit();

    }
}