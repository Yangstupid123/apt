package com.example.testbuttom.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public abstract class BaseFragment extends Fragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return View.inflate(getContext(), getLayoutID(), null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        initListener();

    }

    /**
     * 初始化view
     */
    public void initView(View view) {
    }

    /**
     * 添加监听事件
     */
    public void initListener() {
    }

    /**
     * 获取布局id
     *
     * @return Layout ID
     */
    public abstract int getLayoutID();

    /**
     * 初始化数据
     */
    public void initData() {
    }
}
