package com.idealcn.lazy.fragment.fragment;

import android.content.Context;
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

    public BaseLazyFragment(){
        Log.d("lazy", "BaseLazyFragment: 构造函数");
    }

    //★★★在构造函数之后,onAttach方法前执行.★★★
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        Log.d(TAG, this.getClass().getSimpleName()+" :setUserVisibleHint: "+getUserVisibleHint());
        if (isVisibleToUser){
            loadData();
        }
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d(TAG, this.getClass().getSimpleName()+"   :onAttach: ");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, this.getClass().getSimpleName()+"   :onCreate: ");
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG, this.getClass().getSimpleName()+"   :onActivityCreated: ");
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, this.getClass().getSimpleName()+"   :onCreateView: ");
        return initLayout(inflater,container);
    }

    protected abstract View initLayout(LayoutInflater inflater, ViewGroup container);


    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, this.getClass().getSimpleName()+"   :onStart: ");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, this.getClass().getSimpleName()+"   :onResume: ");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, this.getClass().getSimpleName()+"   :onPause: ");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, this.getClass().getSimpleName()+"   :onStop: ");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, this.getClass().getSimpleName()+"   :onDestroy: ");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, this.getClass().getSimpleName()+"   :onDestroyView: ");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, this.getClass().getSimpleName()+"   :onDetach: ");
    }

    protected abstract void loadData();



}
