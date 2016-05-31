package com.example.taozi.uidemo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

import com.example.taozi.uidemo.adapter.MenuListAdapter;
import com.example.taozi.uidemo.bean.MenuBean;
import com.example.taozi.uidemo.fragment.NewsListItemFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  {

    private Toolbar toolbar;
    private DrawerLayout drawer;
    private ListView menuList;
    private ActionBarDrawerToggle mDrawerToggle;
    private FragmentManager fragmentManager;
    private MenuListAdapter menuAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        drawer = (DrawerLayout) findViewById(R.id.drawer);


        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        mDrawerToggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.open, R.string.close);
        mDrawerToggle.syncState();
        drawer.setDrawerListener(mDrawerToggle);


        menuList = (ListView) findViewById(R.id.menu_list);

        menuAdapter = new MenuListAdapter(this);
        menuList.setAdapter(menuAdapter);


        fragmentManager = getSupportFragmentManager();
        NewsListItemFragment fragment = (NewsListItemFragment) fragmentManager.findFragmentById(R.id.container);
        if (fragment == null) {

            fragmentManager.beginTransaction().add(R.id.container,new NewsListItemFragment()).
                    commitAllowingStateLoss();
        }

    }

}

