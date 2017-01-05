package com.proyectosdm.swipe.ui;

import android.support.design.widget.TabLayout;
import android.support.v4.app.*;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.proyectosdm.swipe.R;
import com.proyectosdm.swipe.model.User;

import java.util.ArrayList;
import java.util.List;

public class Tabs extends AppCompatActivity {

    private User usuarioLogueado; // Pasar de la MainActivity con un parcelable

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tabs);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);


    }

    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        // Inflate the menu
        getMenuInflater().inflate(R.menu.menu_tabs, menu);
        MenuItem usuario = menu.findItem(R.id.MenuOpcion1);

        usuario.setTitle("Usuario: " + usuarioLogueado.getLogin());
        usuario.setEnabled(false);

        return true;
    }

   /** @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        return true;
    }*/

    /**private void updateMenuTitles() {
        Menu menu = (Menu) findViewById(R.id.menu) ;
        MenuItem bedMenuItem = menu.findItem(R.id.MenuOpcion1);
        bedMenuItem.setTitle("Usuario: Pepitp");
    }*/

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new Tab_1(), "Inicio");
        adapter.addFragment(new Tab_2(), "TWO");
        //adapter.addFragment(new ThreeFragment(), "THREE");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}