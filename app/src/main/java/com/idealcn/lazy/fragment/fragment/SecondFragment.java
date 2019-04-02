package com.idealcn.lazy.fragment.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.idealcn.lazy.fragment.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ideal-gn on 2017/9/21.
 */

public class SecondFragment extends BaseLazyFragment {

    public static final String TAG = "lazy";
    private RecyclerView recyclerView;
    private ListView listView;
    private ArrayAdapter<String> adapter;
    private List<String> dataList = new ArrayList<>();
    public SecondFragment(){
//        super();
        Log.d(TAG, "SecondFragment: 构造函数");
    }


    @Nullable

    @Override
    protected View initLayout(LayoutInflater inflater, ViewGroup container) {
        View content = inflater.inflate(R.layout.fragment_second, container, false);
        recyclerView = content.findViewById(R.id.recyclerView);
        listView = content.findViewById(R.id.listView);
        return content;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, dataList);
        listView.setAdapter(adapter);
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    protected void loadData() {
        Log.d(TAG, "loadData: 开始加载SecondFragment的数据");
//        Toast.makeText(getActivity(), "开始加载SecondFragment的数据", Toast.LENGTH_SHORT).show();
        for (int x = 0; x < 30; x++) {
            dataList.add("data---"+x);
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onResume() {
        super.onResume();


    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        dataList.clear();
        adapter.notifyDataSetChanged();
    }
}
