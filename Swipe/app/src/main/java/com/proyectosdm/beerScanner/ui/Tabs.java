package com.proyectosdm.beerScanner.ui;

import android.content.ClipData;
import android.graphics.Typeface;
import android.support.design.widget.TabLayout;
import android.support.v4.app.*;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.proyectosdm.beerScanner.R;
import com.proyectosdm.beerScanner.model.User;

import java.util.ArrayList;
import java.util.List;

public class Tabs extends AppCompatActivity {

    private User usuarioLogueado; // Pasar de la LoginActivity con un parcelable

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    private ClipData.Item apagar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tabs);

        // ================================================

        usuarioLogueado = getIntent().getParcelableExtra("usuario");

        // ================================================

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

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.MenuOpcion2) {
            //Intent intent = new Intent (this, LoginActivity.class);
            //startActivity(intent);
            this.finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {

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