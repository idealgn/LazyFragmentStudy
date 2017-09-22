package com.idealcn.lazy.fragment.fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.idealcn.lazy.fragment.R;

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
    protected View initLayout(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.fragment_third,container,false);
    }

    @Override
    protected void loadData() {
        Log.d(TAG, "loadData: 开始加载ThirdFragment的数据");
//        Toast.makeText(getActivity(), "开始加载ThirdFragment的数据", Toast.LENGTH_SHORT).show();
    }
}
