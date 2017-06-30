package com.king.simplereading.mvp.ui.activity;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import com.blankj.utilcode.util.SPUtils;
import com.king.simplereading.R;
import com.king.simplereading.app.App;
import com.king.simplereading.base.BaseActivity;
import com.king.simplereading.mvp.ui.adapter.HomeFragmentPageAdapter;
import com.king.simplereading.mvp.ui.fragment.AndroidFragment;
import com.king.simplereading.mvp.ui.fragment.HomeFragment;
import com.king.simplereading.mvp.ui.fragment.RightFragment;
import com.king.simplereading.utils.SPConfig;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity
{


    @BindView(R.id.fl_title_menu)
    FrameLayout nvMenu;

    @BindView(R.id.dl_layout)
    DrawerLayout dlLayout;

    @BindView(R.id.toolbar)
    Toolbar tbToolbar;

    @BindView(R.id.rg_home_viewpager_contorl)
    RadioGroup rgHomeViewpagerContorl;

    @BindView(R.id.vp_content)
    ViewPager vpContent;
    @BindView(R.id.view_search)
    MaterialSearchView searchView;

    @Override
    protected int getLayoutId()
    {
        return R.layout.activity_main;
    }

    @Override
    protected void init(Bundle savedInstanceState)
    {
        setToolBar(tbToolbar, "", false);
        initView();
        initData();

    }

    private void initData()
    {
        SPUtils spUtils = SPConfig.getInstance().getSpUtils();
        if (!spUtils.getBoolean("home_list_boolean")) {
            spUtils.put("home_list", "知乎日报&&知乎热门&&知乎主题&&知乎专栏&&");
            spUtils.put("home_list_boolean", true);
        }
    }

    @OnClick({R.id.fl_title_menu,R.id.fl_exit_app,R.id.fl_feedback,R.id.fl_about_us,R.id.fl_setting,R.id.fl_theme_color})
    public void onClick(View v){
        switch (v.getId())
        {
            case R.id.fl_title_menu:
                dlLayout.openDrawer(GravityCompat.START);
                break;
            case R.id.fl_exit_app:
                App.getApplication().exitApp(false);
                break;
            case R.id.fl_feedback:
                break;
            case R.id.fl_about_us:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Material Design Dialog");
                builder.setMessage("这是 android.support.v7.app.AlertDialog 中的样式");
                builder.setNegativeButton("取消", null);
                builder.setPositiveButton("确定", null);
                builder.show();
                break;
            case R.id.fl_setting:
                break;
            case R.id.fl_theme_color:
                break;
        }
    }


    private void initView()
    {
        rgHomeViewpagerContorl.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i)
            {
                switch (i)
                {
                    case R.id.rb_home_pager:
                        vpContent.setCurrentItem(0);
                        break;
                    case R.id.rb_music_pager:
                        vpContent.setCurrentItem(1);
                        break;
                    case R.id.rb_friend_pager:
                        vpContent.setCurrentItem(2);
                        break;
                }
            }
        });

        List<Fragment> mFragmentList = new ArrayList<>();
        mFragmentList.add(new AndroidFragment());
        mFragmentList.add(new HomeFragment());
        mFragmentList.add(new RightFragment());
        vpContent.setAdapter(new HomeFragmentPageAdapter(getSupportFragmentManager(), mFragmentList));
        vpContent.setCurrentItem(1);
        vpContent.addOnPageChangeListener(new ViewPager.OnPageChangeListener()
        {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels)
            {

            }

            @Override
            public void onPageSelected(int position)
            {
                switch (position)
                {
                    case 0:
                        rgHomeViewpagerContorl.check(R.id.rb_home_pager);
                        break;
                    case 1:
                        rgHomeViewpagerContorl.check(R.id.rb_music_pager);
                        break;
                    case 2:
                        rgHomeViewpagerContorl.check(R.id.rb_friend_pager);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state)
            {

            }
        });



    }


}
