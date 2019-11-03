package com.example.testbuttom.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.example.testbuttom.R;
import com.example.testbuttom.base.BaseActivity;
import com.example.testbuttom.ui.fragment.GwcFragment;
import com.example.testbuttom.ui.fragment.HomeFragment;
import com.example.testbuttom.ui.fragment.ListFragment;
import com.example.testbuttom.ui.fragment.MeFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//    }

    // 声明viewpager，adapter，List
    private ViewPager mViewPage;
    private FragmentPagerAdapter adapter;
    private List<Fragment> mfragment;

    // 声明底部导航栏布局
    private LinearLayout mTabHome;
    private LinearLayout mTabList;
    private LinearLayout mGwc;
    private LinearLayout mMe;

    // 声明按钮
    private ImageButton homebtn;
    private ImageButton listbtn;
    private ImageButton gwcbtn;
    private ImageButton mebtn;

    // 声明碎片
    private HomeFragment mHomeFrag;
    private ListFragment mListFrag;
    private GwcFragment mGwcFrag;
    private MeFragment mMeFrag;

    //声明一个事件监听方法
    private View.OnClickListener onClickListener;

    @Override
    public int getLayoutID() {
        //第一步：获取ViewPager实例

        //初始化
//        initViews();
//        initData();
        return R.layout.activity_main;
    }

    public void initView() {
        mViewPage = findViewById(R.id.viewpage);
        // 实例化布局
        mTabHome = findViewById(R.id.tab_home_layout);
        mTabList = findViewById(R.id.tab_list_layout);
        mGwc = findViewById(R.id.tab_gwc_layout);
        mMe = findViewById(R.id.tab_me_layout);

        // 实例化按钮
        homebtn = findViewById(R.id.tab_home_image);
        listbtn = findViewById(R.id.tab_list_image);
        gwcbtn = findViewById(R.id.tab_gwc_image);
        mebtn = findViewById(R.id.tab_me_image);

        // 实例化碎片
        mHomeFrag = new HomeFragment();
        mListFrag = new ListFragment();
        mGwcFrag = new GwcFragment();
        mMeFrag = new MeFragment();

        // 设置第一个按钮为亮的状态（打开的默认状态）
        homebtn.setImageResource(R.mipmap.analysis_true);

        //初始化事件监听方法
        onClickListener = new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int currentIndex = 0;
                resetImgs();
                switch (v.getId()) {
                    case R.id.tab_home_layout:
                        currentIndex = 0;
                        break;
                    case R.id.tab_list_layout:
                        currentIndex = 1;
                        break;
                    case R.id.tab_gwc_layout:
                        currentIndex = 2;
                        break;
                    case R.id.tab_me_layout:
                        currentIndex = 3;
                        break;
                }
                selectTab(currentIndex);
            }
        };
    }

    public void initData() {
        mfragment = new ArrayList<>();

    }

    private void resetImgs() {
        homebtn.setImageResource(R.mipmap.analysis_false);
        listbtn.setImageResource(R.mipmap.edu_manage_false);
        gwcbtn.setImageResource(R.mipmap.cash_manage_false);
        mebtn.setImageResource(R.mipmap.my_false);
    }

    private void selectTab(int i) {
        switch (i) {
            case (0):
                homebtn.setImageResource(R.mipmap.analysis_true);
                break;
            case (1):
                listbtn.setImageResource(R.mipmap.edu_manage_true);
                break;
            case (2):
                gwcbtn.setImageResource(R.mipmap.cash_manage_true);
                break;
            case (3):
                mebtn.setImageResource(R.mipmap.my_true);
                break;
        }
        // 设置当前点击的Tab对应的界面.点击后切换当前选中fragment
        mViewPage.setCurrentItem(i);
    }

    @Override
    public void initListener() {
        super.initListener();
        // 将四个Fragment放入集合中
        mfragment.add(mHomeFrag);
        mfragment.add(mListFrag);
        mfragment.add(mGwcFrag);
        mfragment.add(mMeFrag);

        // 第二步：初始化适配器
        adapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {//从集合中获取对应位置的Fragment
                return mfragment.get(position);
            }

            @Override
            public int getCount() {//获取集合中Fragment的总数
                return mfragment.size();
            }
        };


        // 第三步：把适配器给viewPaper
        mViewPage.setAdapter(adapter);

        // 第四步：给viewPaper设置事件监听
        mViewPage.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            // 页面滚动事件
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            // 页面选择事件
            @Override
            public void onPageSelected(int position) {
                // 设置对应集合中的Fragment
//                viewPager.setCurrentItem(position);
//                resetImgs();
//                selectTab(position);
                mViewPage.setCurrentItem(position);
                resetImgs();
                selectTab(position);
            }

            // 页面滚动状态改变事件
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        initEvent();
    }

    private void initEvent(){
        mTabHome.setOnClickListener(onClickListener);
        mTabList.setOnClickListener(onClickListener);
        mGwc.setOnClickListener(onClickListener);
        mMe.setOnClickListener(onClickListener);
    }

}
