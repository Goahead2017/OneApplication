package com.cqupt.personal.oneapplication;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;

import com.cqupt.personal.oneapplication.Fragment.DaiBanFragment;
import com.cqupt.personal.oneapplication.Fragment.FaBuFragment;
import com.cqupt.personal.oneapplication.Fragment.HaoYouFragment;
import com.cqupt.personal.oneapplication.Fragment.YiBanFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager pager;
    private MyFragmentPagerAdapter adapter;

    private FaBuFragment faBuFragment;
    private DaiBanFragment daiBanFragment;
    private YiBanFragment yiBanFragment;
    private HaoYouFragment haoYouFragment;

    //存储fragment实例
    private List<Fragment>fragList;

    private RadioGroup radioGroup;

    //存储radiobutton的id
    private int []buttons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        initViewPager();
    }

    //设置ViewPager
    private void initViewPager() {
        pager.setAdapter(adapter);
        pager.setCurrentItem(0);
        //设置radiobutton和ViewPager的相关监听事件
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.bt_fabu:
                        pager.setCurrentItem(0);
                        break;
                    case R.id.bt_daiban:
                        pager.setCurrentItem(1);
                        break;
                    case R.id.bt_yiban:
                        pager.setCurrentItem(2);
                        break;
                    case R.id.bt_haoyou:
                        pager.setCurrentItem(3);
                        break;
                }
            }
        });
        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                radioGroup.check(buttons[position]);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    //初始化,获取各个实例对象
    private void init() {
        pager = findViewById(R.id.pager);

        radioGroup = findViewById(R.id.radio_group);

        buttons = new int[]{R.id.bt_fabu,R.id.bt_daiban,R.id.bt_yiban,R.id.bt_haoyou};

        faBuFragment = new FaBuFragment();
        daiBanFragment = new DaiBanFragment();
        yiBanFragment = new YiBanFragment();
        haoYouFragment = new HaoYouFragment();

        fragList = new ArrayList<>();
        fragList.add(faBuFragment);
        fragList.add(daiBanFragment);
        fragList.add(yiBanFragment);
        fragList.add(haoYouFragment);
        adapter = new MyFragmentPagerAdapter(getSupportFragmentManager(),fragList);
    }
}
