package com.cqupt.personal.oneapplication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FaBuFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fabu,container,false);
        return view;
    }

    @Override
    protected void onFragmentVisibleChange(boolean isVisible) {
        if(isVisible){
            //执行ui加载
        }else {
            //取消ui加载
        }
    }

    @Override
    protected void onFragmentFirstVisible() {
        //数据下载操作
    }
}
