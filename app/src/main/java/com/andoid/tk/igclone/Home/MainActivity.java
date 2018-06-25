package com.andoid.tk.igclone.Home;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.andoid.tk.igclone.R;
import com.andoid.tk.igclone.Utils.BottomNavigationBarHelper;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private static final int ACTIVITY_NUM = 0;

    private Context mContext = MainActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate: starting");

        setupBottomNavigation();
        setupViewPager();
    }

    private void setupViewPager(){
        Log.d(TAG, "setupViewPager: setting up top navigation tab");
        
        SectionPagerAdapter adapter = new SectionPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new CameraFragment());
        adapter.addFragment(new HomeFragment());
        adapter.addFragment(new MessagesFragment());

        ViewPager viewPager = findViewById(R.id.container);
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_ig_camera);
        tabLayout.getTabAt(1).setIcon(R.drawable.ig_header);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_ig_send);
        
    }

    private void setupBottomNavigation(){
        Log.d(TAG, "setupBottomNavigation: setting up bottom navigation");
        BottomNavigationViewEx bottomNavigationViewEx = findViewById(R.id.bottomNavViewBar);
        BottomNavigationBarHelper.setupBottomNavigationView(bottomNavigationViewEx);
        BottomNavigationBarHelper.enableNavigation(mContext,bottomNavigationViewEx);
        //Highlight Activating Menu Icon
        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);

    }
    
}
