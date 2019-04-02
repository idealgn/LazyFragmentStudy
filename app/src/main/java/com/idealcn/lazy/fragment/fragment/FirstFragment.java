package com.idealcn.lazy.fragment.fragment;

import android.view.View;

import com.idealcn.lazy.fragment.R;
import com.idealcn.lazy.fragment.base.BaseLazyFragment;

/**
 * Created by ideal-gn on 2017/9/21.
 */

public class FirstFragment extends BaseLazyFragment {

    public static final String TAG = "lazy";
    public FirstFragment(){
//        super();
        log("FirstFragment: 构造函数");
    }



    @Override
    protected void lazyLoadData() {
        log("lazyLoadData: 开始加载FirstFragment的数据");
       // hasCache = true;
//        Toast.makeText(getActivity(), "开始加载FirstFragment的数据", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void initViews(View root) {

    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_first;
    }
}
