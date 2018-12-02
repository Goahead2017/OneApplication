package com.cqupt.personal.oneapplication.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cqupt.personal.oneapplication.Fragment.BaseFragment;
import com.cqupt.personal.oneapplication.R;

public class YiBanFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_yiban,container,false);
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
