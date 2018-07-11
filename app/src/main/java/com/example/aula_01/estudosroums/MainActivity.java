package com.example.aula_01.estudosroums;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import android.widget.FrameLayout;


public class MainActivity extends AppCompatActivity {

    private FrameLayout fragment1;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    BlankFragment fragment = new BlankFragment();
                    gerenciadorFragments(fragment);
                    return true;
                case R.id.navigation_dashboard:
                    Fragment2 fragment2 = new Fragment2();
                    gerenciadorFragments(fragment2);

                    return true;
                case R.id.navigation_notifications:
                    Fragment3 fragment3 = new Fragment3();
                    gerenciadorFragments(fragment3);

                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragment1 =(FrameLayout)findViewById(R.id.fragment1);
        BottomNavigationView potato = (BottomNavigationView) findViewById(R.id.navigation);
        potato.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }

    public void gerenciadorFragments (Fragment fragment){

        FragmentManager fragmentManager = getSupportFragmentManager();
        //estou pegando o fragmento Dinamico//
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //Estou realizando a transação entre as fragments//
        fragmentTransaction.add(R.id.fragment1,fragment);
        fragmentTransaction.commit();

    }

}
