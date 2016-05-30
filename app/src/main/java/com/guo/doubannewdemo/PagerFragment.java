package com.guo.doubannewdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by guo on 2016/5/30.
 */
public class PagerFragment extends Fragment {
    private int pageNum;
    private TextView tv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View pager=inflater.inflate(R.layout.pager_fragment_layout,container,false);
        tv=(TextView)pager.findViewById(R.id.tv);
        Bundle bundle=getArguments();
        pageNum=bundle.getInt("page_num");
        tv.setText(""+pageNum);
        return pager;
    }
}
