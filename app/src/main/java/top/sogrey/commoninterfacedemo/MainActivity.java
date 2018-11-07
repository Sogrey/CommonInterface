package top.sogrey.commoninterfacedemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.design.widget.TabLayout;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

import top.sogrey.commoninterface.BaseFragment;
import top.sogrey.commoninterface.interfaceFuns.FunctionManager;
import top.sogrey.commoninterface.interfaceFuns.FunctionWithParamsAndResult;
import top.sogrey.commoninterface.interfaceFuns.FunctionWithoutParamsAndResult;
import top.sogrey.commoninterfacedemo.fregments.BlankFragment;
import top.sogrey.commoninterfacedemo.fregments.BlankFragment2;
import top.sogrey.commoninterfacedemo.fregments.BlankFragment3;

public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private ArrayList<String> listTitles;
    private ArrayList<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        mTabLayout = (TabLayout) findViewById(R.id.tabLayout);

        initData();


    }

    private void initData() {
        listTitles = new ArrayList<>();
        fragments = new ArrayList<>();

        listTitles.add("推荐");
        listTitles.add("热点");
        listTitles.add("视频");

        BlankFragment blankFragment = new BlankFragment();
        BlankFragment2 blankFragment2 = new BlankFragment2();
        BlankFragment3 blankFragment3 = new BlankFragment3();

        fragments.add(blankFragment);
        fragments.add(blankFragment2);
        fragments.add(blankFragment3);

        //mTabLayout.setTabMode(TabLayout.SCROLL_AXIS_HORIZONTAL);//设置tab模式，当前为系统默认模式
        for (int i = 0; i < listTitles.size(); i++) {
            mTabLayout.addTab(mTabLayout.newTab().setText(listTitles.get(i)));//添加tab选项
        }

        FragmentPagerAdapter mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }

            //ViewPager与TabLayout绑定后，这里获取到PageTitle就是Tab的Text
            @Override
            public CharSequence getPageTitle(int position) {
                return listTitles.get(position);
            }
        };
        mViewPager.setAdapter(mAdapter);

        mTabLayout.setupWithViewPager(mViewPager);//将TabLayout和ViewPager关联起来。
        mTabLayout.setTabsFromPagerAdapter(mAdapter);//给Tabs设置适配器
    }

    public void setFunctions(String tag) {
        FragmentManager fm = getSupportFragmentManager();
        BaseFragment fragment = (BaseFragment) fm.findFragmentByTag(tag);
        FunctionManager fManager = FunctionManager.getInstance();
        if (fragment != null)
            fragment.setmFunctionManager(fManager.addFunction(new FunctionWithoutParamsAndResult(BlankFragment.INTERFACE) {
                @Override
                public void function() {
                    Toast.makeText(MainActivity.this, "BlankFragment 2 mainActivity success.", Toast.LENGTH_LONG).show();
                }
            }).addFunction(new FunctionWithParamsAndResult<String,String>(BlankFragment2.INTERFACE) {
                @Override
                public String function(String[] params) {
                    return params+" success.";
                }
            }));
    }
}