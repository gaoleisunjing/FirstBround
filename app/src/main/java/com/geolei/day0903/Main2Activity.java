package com.geolei.day0903;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

import Pageradapter.MyFragment1StatePageAdapter;
import fragment.MyFragment1;
import fragment.MyFragment2;
import fragment.MyFragment3;
import fragment.MyFragment4;

public class Main2Activity extends FragmentActivity implements RadioGroup.OnCheckedChangeListener {


    ViewPager viewPager;
    RadioGroup radiogroup;
    List<Fragment> datas;
    MyFragment1StatePageAdapter fragmentAdapter;
    //NoScrollViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        initView();
        initData();
        initAdapter();
        initListener();


    }

    private void initListener() {
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
//            for (int i = 0; i <radiogroup.getChildCount(); i++) {
//
//            }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        viewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;//禁止viewPager的左右移动，但是可以通过点击实现滑动

            }
        });


    }


    private void initAdapter() {
        fragmentAdapter = new MyFragment1StatePageAdapter(getSupportFragmentManager(), datas);
        viewPager.setAdapter(fragmentAdapter);
    }

    private void initData() {
        datas = new ArrayList<>();
//        MyFragment1 fragment1 = new MyFragment1();
//        MyFragment2 fragment2 = new MyFragment2();
//        MyFragment3 fragment3 = new MyFragment3();
        MyFragment4 fragment4 = new MyFragment4();

//        datas.add(fragment1);
//        datas.add(fragment2);
//        datas.add(fragment3);
        datas.add(fragment4);

    }

    private void initView() {
        viewPager = (ViewPager) findViewById(R.id.viewPagerId);
        radiogroup = (RadioGroup) findViewById(R.id.radioGroupId);
        radiogroup.setOnCheckedChangeListener(this);

//        viewPager=new NoScrollViewPager(getApplicationContext());
//        LinearLayout layout=new LinearLayout(getApplicationContext());
//        DisplayMetrics displayMetrics = new DisplayMetrics();//获取屏幕像素信息
//        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
//        int width=displayMetrics.widthPixels;
//        int height=displayMetrics.heightPixels-45;
//        viewPager.setLayoutParams(new ViewGroup.LayoutParams(width,height));
//        layout.addView(viewPager);
    }


    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i) {

            case R.id.radio1Id:
                viewPager.setCurrentItem(0);

                break;
            case R.id.radio2Id:
                viewPager.setCurrentItem(1);
                break;
            case R.id.radio3Id:
                viewPager.setCurrentItem(2);
                break;
            case R.id.radio4Id:
                viewPager.setCurrentItem(3);
                break;
            default:
                break;

        }
    }
}
