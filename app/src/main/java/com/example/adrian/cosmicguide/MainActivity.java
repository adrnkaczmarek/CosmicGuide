package com.example.adrian.cosmicguide;

import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.adrian.cosmicguide.Earth.EarthFragment;
import com.example.adrian.cosmicguide.Universe.UniverseFragment;

public class MainActivity extends AppCompatActivity {

    private static final int NUM_PAGES = 2;

    private ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        CollectionPagerAdapter adapter = new CollectionPagerAdapter(getSupportFragmentManager());
        pager = (ViewPager) findViewById(R.id.main_swiper);
        pager.setAdapter( adapter );

        TabLayout tabs = (TabLayout) findViewById(R.id.pager_tabs);
        tabs.setupWithViewPager(pager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public class CollectionPagerAdapter extends FragmentPagerAdapter{

        public CollectionPagerAdapter(FragmentManager ft){
            super(ft);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment = position == 0 ? (new EarthFragment()) : (new UniverseFragment());
            return fragment;
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return position==0 ? MainActivity.this.getResources().getString(R.string.earth)
                    : MainActivity.this.getResources().getString(R.string.universe);
        }
    }
}
