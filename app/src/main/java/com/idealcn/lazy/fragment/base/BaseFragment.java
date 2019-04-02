package com.idealcn.lazy.fragment.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 正常的fragment
 */
public abstract class BaseFragment extends Fragment {
    /*view是否创建*/
    protected boolean isViewCreated = false;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View root = inflater.inflate(getLayout(), container, false);
        if (null!=root){
            isViewCreated = true;
            initViews(root);
        }
        return root;
    }

    /**
     * 初始化view
     * @param root 根布局
     */
    protected abstract void initViews(View root);

    protected abstract int getLayout();

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        loadData();
    }

    protected abstract void loadData();

}
