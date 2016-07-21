package weather.newer.com.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import java.util.ArrayList;
import java.util.List;

public class Main3Activity extends AppCompatActivity {

    TabLayout tabLayout;
    Toolbar toolbar;
    ViewPager viewPagerNext;
    TabAdapter tabAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        viewPagerNext = (ViewPager) findViewById(R.id.viewPagerNext);
        tabAdapter =new TabAdapter(getSupportFragmentManager());
        viewPagerNext.setAdapter(tabAdapter);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        //使用Toolbar 代替actionbar
        setSupportActionBar(toolbar);
       getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //*getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_face_24dp);*/
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        // TabLayout和ViewPager双向、交互联动。
        tabLayout.setupWithViewPager(viewPagerNext);
//        //滚动模式
//        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
//        //设置下面线条的高度
//        tabLayout.setSelectedTabIndicatorHeight(8);
//        //设置线条的颜色
//        tabLayout.setSelectedTabIndicatorColor(Color.BLUE);

        tabLayout.addTab(tabLayout.newTab().setText("娱乐"));
        tabLayout.addTab(tabLayout.newTab().setText("体育"));
        tabLayout.addTab(tabLayout.newTab().setText("军事"));


    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.next, menu);
        return super.onCreateOptionsMenu(menu);
    }
    class TabAdapter extends FragmentPagerAdapter {


        List<Fragment> fragmentList =new ArrayList<>();
        String[] title ={"新闻","游戏","科技"};

        public TabAdapter(FragmentManager fm) {
            super(fm);
            fragmentList.add(new NewFragment());
            fragmentList.add(new GameFragment());
            fragmentList.add(new TechFragment());
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return title[position];
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }
    }

}

