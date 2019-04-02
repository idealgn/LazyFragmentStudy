package com.idealcn.lazy.fragment.fragment;

import android.util.Log;
import android.view.View;

import com.idealcn.lazy.fragment.R;
import com.idealcn.lazy.fragment.base.BaseLazyFragment;

/**
 * Created by ideal-gn on 2017/9/21.
 */

public class ThirdFragment extends BaseLazyFragment {

    public static final String TAG = "lazy";
    public ThirdFragment(){
//        super();
        Log.d(TAG, "ThirdFragment: 构造函数");
    }


    @Override
    protected void initViews(View root) {

    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_third;
    }


    @Override
    protected void lazyLoadData() {
        Log.d(TAG, "lazyLoadData: 开始加载ThirdFragment的数据");
      //  hasCache = true;
//        Toast.makeText(getActivity(), "开始加载ThirdFragment的数据", Toast.LENGTH_SHORT).show();
    }
}
