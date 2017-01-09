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
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.proyectosdm.beerScanner.R;
import com.proyectosdm.beerScanner.model.User;

import java.util.ArrayList;
import java.util.List;

public class Tabs extends AppCompatActivity {

    // =======================================================
    // No puede hacer nada hasta terminar la accion actual
    // =======================================================

    public Boolean ejecutandoTarea = false;

    // =======================================================
    // Usuario que está usando la aplicación
    // =======================================================

    private User usuarioLogueado; // Pasar de la LoginActivity con un parcelable

    public User getUsuarioLogueado() {
        return usuarioLogueado;
    }

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    private static Tab_1 tab_1;
    private static Tab_2 tab_2;

    public static Tab_1 getTab_1() {
        return tab_1;
    }

    public static Tab_2 getTab_2() {
        return tab_2;
    }

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
            ejecutandoTarea = false;

            this.finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        tab_1 = new Tab_1();
        adapter.addFragment(tab_1, "Búsqueda");
        //adapter.addFragment(new Tab_1(), "Búsqueda");
        tab_2 = new Tab_2();
        adapter.addFragment(tab_2, "Historial");
        //adapter.addFragment(new Tab_2(), "Historial");
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