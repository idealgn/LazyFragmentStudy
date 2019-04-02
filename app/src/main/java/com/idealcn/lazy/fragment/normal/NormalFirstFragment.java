package com.idealcn.lazy.fragment.normal;

import android.view.View;

import com.idealcn.lazy.fragment.R;
import com.idealcn.lazy.fragment.base.BaseFragment;

public class NormalFirstFragment extends BaseFragment {
    @Override
    protected void initViews(View root) {

    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_first;
    }

    @Override
    protected void loadData() {
        System.out.println("NormalFirstFragment--------------------loadData");
    }
}
