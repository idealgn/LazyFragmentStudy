package com.idealcn.lazy.fragment.fragment;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by ideal-gn on 2017/9/21.
 */

public abstract class BaseLazyFragment extends Fragment {

    public static final String TAG  = "lazy";
    /*view是否创建*/
    protected boolean isViewCreated = false;
    /*是否开启懒加载,默认开启*/
    protected boolean useLazyMode = true;
    /*是否开启log*/
    protected  boolean openLog = false;

    public BaseLazyFragment(){
        log("BaseLazyFragment: 构造函数");
    }

    public void setUseLazyMode(boolean useLazyMode){
        this.useLazyMode = useLazyMode;
    }

    public void setOpenLog(boolean openLog){
        this.openLog = openLog;
    }

    //★★★在构造函数之后,onAttach方法前执行.★★★
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
       log("setUserVisibleHint: "+getUserVisibleHint());
        if (isVisibleToUser&&isViewCreated&&useLazyMode){
            loadData();
        }
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        log("onAttach");
    }



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       log(" onCreate");
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        log("onCreateView");
        final View root = initLayout(inflater, container);
        if (null!=root){
            isViewCreated = true;
        }
        return root;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        log("onViewCreated");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
       log(" onActivityCreated ");
       if (useLazyMode){
           if (isViewCreated&&getUserVisibleHint()){
               log("   :onActivityCreated: 开始加载数据 ");
               loadData();
           }
       }else {
           if (isViewCreated){
               log("   :onActivityCreated: 开始加载数据 ");
               loadData();
           }
       }

    }


    /**
     *  恢复之前的状态
     * @param savedInstanceState
     */
    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        log("onViewStateRestored");
    }

    protected abstract View initLayout(LayoutInflater inflater, ViewGroup container);


    @Override
    public void onStart() {
        super.onStart();
        log("onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        log("onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        log("onPause");
    }

    /**
     * 保存当前状态
     * @param outState
     */
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        log("onSaveInstanceState");
    }

    @Override
    public void onStop() {
        super.onStop();
        log("onStop");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        log("onDestroy");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        log("onDestroyView");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        log("onDetach");
        this.isViewCreated = false;
    }



    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        log("onHiddenChanged： "+hidden);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        log("onConfigurationChanged");
    }

    @Override
    public void onMultiWindowModeChanged(boolean isInMultiWindowMode) {
        super.onMultiWindowModeChanged(isInMultiWindowMode);
    }

    @Override
    public void onPictureInPictureModeChanged(boolean isInPictureInPictureMode) {
        super.onPictureInPictureModeChanged(isInPictureInPictureMode);
    }

    @Override
    public void onAttachFragment(Fragment childFragment) {
        super.onAttachFragment(childFragment);
    }



    protected abstract void loadData();

    protected void log(String methodName){
        if (openLog)
        Log.d(TAG, this.getClass().getSimpleName()+"   : "+methodName);
    }

}
