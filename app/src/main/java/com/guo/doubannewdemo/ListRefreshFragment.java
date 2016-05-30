package com.guo.doubannewdemo;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by guo on 2016/5/30.
 */
public class ListRefreshFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener{
    private SwipeRefreshLayout mRefreshLayout;
    private ListView lv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.refresh_layout,container,false);
        mRefreshLayout=(SwipeRefreshLayout)view.findViewById(R.id.refresh_layoutt);
        lv=(ListView)view.findViewById(R.id.lv);
        mRefreshLayout.setOnRefreshListener(this);
        mRefreshLayout.setColorSchemeResources(
                android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);

        lv.setAdapter(new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,getData()));
        return view;

    }
    public List<String> getData(){
        List<String> data=new ArrayList<String>();
        for(int i=0;i<15;i++){
            data.add(i+"");
        }
        return data;
    }

    @Override
    public void onRefresh() {
        mRefreshLayout.setRefreshing(true);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mRefreshLayout.setRefreshing(false);
            }
        },3000);

    }


}
