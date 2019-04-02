package com.idealcn.lazy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.idealcn.lazy.fragment.R;
import com.idealcn.lazy.fragment.base.BaseFragment;
import com.idealcn.lazy.fragment.normal.NormalFirstFragment;
import com.idealcn.lazy.fragment.normal.NormalForthFragment;
import com.idealcn.lazy.fragment.normal.NormalSecondFragment;
import com.idealcn.lazy.fragment.normal.NormalThirdFragment;

import java.util.ArrayList;
import java.util.List;

public class NormalActivity extends AppCompatActivity {

    final List<BaseFragment> fragmentList = new ArrayList<>();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal);
     final TextView title =  findViewById(R.id.textView);

        fragmentList.add(new NormalFirstFragment());
        fragmentList.add(new NormalSecondFragment());
        fragmentList.add(new NormalThirdFragment());
        fragmentList.add(new NormalForthFragment());

       final ViewPager viewPager =  findViewById(R.id.normalPager);
       viewPager.setAdapter(fragmentPagerAdapter);


        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
            title.setText(fragmentPagerAdapter.getPageTitle(position));
                viewPager.setCurrentItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    FragmentPagerAdapter fragmentPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return fragmentList.get(position).getClass().getSimpleName();
        }
    };

    FragmentStatePagerAdapter fragmentStatePagerAdapter = new FragmentStatePagerAdapter(getSupportFragmentManager()) {
        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return fragmentList.get(position).getClass().getSimpleName();
        }
    };
}
