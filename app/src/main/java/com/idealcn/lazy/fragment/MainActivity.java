package com.idealcn.lazy.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.idealcn.lazy.fragment.fragment.BaseLazyFragment;
import com.idealcn.lazy.fragment.fragment.FirstFragment;
import com.idealcn.lazy.fragment.fragment.ForthFragment;
import com.idealcn.lazy.fragment.fragment.SecondFragment;
import com.idealcn.lazy.fragment.fragment.ThirdFragment;

public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private TextView mTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewPager =  findViewById(R.id.viewPager);
        mTitle = findViewById(R.id.title);

        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                BaseLazyFragment fragment = null;
                switch (position){
                    case 0:
                        fragment = new FirstFragment();
                        break;
                    case 1:
                        fragment = new SecondFragment();
                        break;
                    case 2:
                        fragment = new ThirdFragment();
                        break;
                    case 3:
                        fragment = new ForthFragment();
                        break;
                    default:
                        fragment = new FirstFragment();
                        break;
                }
                fragment.setUseLazyMode(false);
                return fragment;
            }

            @Override
            public int getCount() {
                return 4;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                String title = "title---"+(position+1);

                return title;
            }
        });

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mViewPager.setCurrentItem(position);
                mTitle.setText(mViewPager.getAdapter().getPageTitle(position));
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        mViewPager.setCurrentItem(0);

    }
}
