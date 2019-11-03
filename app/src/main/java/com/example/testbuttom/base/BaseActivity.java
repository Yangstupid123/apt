package com.example.testbuttom.base;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutID());
        initData();
        initView();
        initListener();
    }

    /**
     * 初始化监听
     */
    public void initListener() {
    }

    /**
     * 数据初始化
     */
    public void initData() {
    }

    /**
     * 做view的初始化操作
     */
    public void initView(){

    }

    /**
     * 获取布局id
     *
     * @return layout ID
     */
    public abstract int getLayoutID();

    /**
     * toast
     */
    public void myToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }
}
