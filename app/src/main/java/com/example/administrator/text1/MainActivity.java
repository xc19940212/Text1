package com.example.administrator.text1;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    @ViewInject(R.id.toolbar)
    private Toolbar toolbar;
    @ViewInject(R.id.tabs)
    private TabLayout tabs;
    @ViewInject(R.id.content)
    private ViewPager viewPager;
    private List<Fragment> pages;
    private List<String> titles;
    @ViewInject(R.id.drawer_Layout)
    private DrawerLayout drawerLayout;
    @ViewInject(R.id.navigation)
    private NavigationView navigationView;
    //新建菜单时调用的系统方法
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.setting_menu,menu);
        return true;
    }
    //菜单的点击监听
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu1:
                changeTheme(R.style.Theme1);

                break;
            case R.id.menu2:
                changeTheme(R.style.Theme2);

                break;
            case R.id.menu3:
                changeTheme(R.style.Theme3);

                break;
            case R.id.submenu:
                Toast.makeText(this, "submenu", Toast.LENGTH_SHORT).show();
            break;
        }

        return true;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent=getIntent();
        int theme = intent.getIntExtra("theme", -1);
        if(theme !=-1){
            setTheme(theme);
        }
        setContentView(R.layout.activity_main);
        x.view().inject(this);
        pages=new ArrayList<Fragment>();
        titles=new ArrayList<String>();
        pages.add(new Page1Fragment());
        pages.add(new Page2Fragment());
        pages.add(new Page3Fragment());
        titles.add("军事");
        titles.add("体育");
        titles.add("八卦");
        toolbar.setTitle("我是标题");
        toolbar.setSubtitle("我是第二标题");
        toolbar.setLogo(R.mipmap.ic_launcher);

        toolbar.setNavigationIcon(R.drawable.ic_all_out_black_24dp);
        setSupportActionBar(toolbar);

        MyViewPagerAdapter adapter=new MyViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        tabs.setupWithViewPager(viewPager);

        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string
                .open,R.string.close);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int index=0;
                switch (item.getItemId()){
                    case R.id.group_menu1:
                        index=0;
                        break;
                    case R.id.group_menu2:
                        index=1;
                        break;
                    case R.id.group_menu3:
                        index=2;
                        break;
                }
                viewPager.setCurrentItem(index);
                drawerLayout.closeDrawers();
                return true;
            }
        });

    }

    class MyViewPagerAdapter extends FragmentPagerAdapter{

        public MyViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return pages.get(position);
        }

        @Override
        public int getCount() {
            return pages.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles.get(position);
        }
    }
    private void  changeTheme(int theme){

        Intent intent=new Intent(this,MainActivity.class);
        intent.putExtra("theme",theme);
        startActivity(intent);
        overridePendingTransition(0,0);
    }
}
