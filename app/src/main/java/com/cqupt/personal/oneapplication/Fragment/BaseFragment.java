package com.cqupt.personal.oneapplication.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

/**
 * Fragment基类，封装了懒加载的实现
 */

public abstract class BaseFragment extends Fragment{

    //判断fragment是否为可见状态
    private boolean isFragmentVisible;
    //判断是否要使用view的复用,默认是开启的,防止使用ViewPager出现重复创建view的问题
    private boolean isReuseView;
    //判断fragment是否是第一次加载,只有是第一次加载的时候才会去下载数据
    private boolean isFirstVisible;
    private View rootView;

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (rootView == null){
            return;
        }
        if(isFirstVisible && isVisibleToUser){
            onFragmentFirstVisible();
            isFirstVisible = false;
        }
        if(isVisibleToUser){
            onFragmentVisibleChange(true);
            isFragmentVisible = true;
            return;
        }
        if(isFragmentVisible){
            isFragmentVisible = false;
            onFragmentVisibleChange(false);
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initVariable();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        if(rootView == null){
            rootView = view;
            if(getUserVisibleHint()){
                if(isFirstVisible){
                    onFragmentFirstVisible();
                    isFirstVisible = false;
                }
                onFragmentVisibleChange(true);
                isFirstVisible = true;
            }
        }
        super.onViewCreated(isReuseView?rootView:view,savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        initVariable();
    }

    private void initVariable() {
        isFirstVisible = true;
        isFragmentVisible = false;
        rootView = null;
        isReuseView = true;
    }

    //提供是否调用view的方法
    protected void reuseView(boolean isReuse){
        isReuseView = isReuse;
    }

    /**去除setUserVisibleHint()在多余的场景回调,保证只在fragment的可见状态发生改变的时候才回调
     *@param isVisible true     不可见 -> 可见
     *                  false    可见 -> 不可见
     */
    protected void onFragmentVisibleChange(boolean isVisible){

    }

    //只有在fragment第一次加载的时候执行类似下载数据的操作,防止数据重复下载
    protected void onFragmentFirstVisible(){

    }

    //显示当前fragment的状态
    protected boolean isFragmentVisible(){
        return isFragmentVisible;
    }
}
