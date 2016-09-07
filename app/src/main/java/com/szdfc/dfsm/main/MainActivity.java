package com.szdfc.dfsm.main;

import android.support.v4.view.ViewPager;
import android.view.View;

import com.baseandroid.activity.BaseActivity;
import com.baseandroid.view.BottomButton;
import com.ogaclejapan.smarttablayout.utils.v13.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v13.FragmentPagerItems;
import com.szdfc.dfsm.R;
import com.szdfc.dfsm.fragment.ExhibitionFragment;
import com.szdfc.dfsm.fragment.HomeFragment;
import com.szdfc.dfsm.fragment.MeFragment;
import com.szdfc.dfsm.fragment.NewHomeFragment;
import com.szdfc.dfsm.news.NewsFragment;

import butterknife.Bind;

public class MainActivity extends BaseActivity {
    @Bind(R.id.content_view_pager)
    ViewPager viewPager;//首页三个fragment容器

    @Bind(R.id.home_btn)
    BottomButton homeBtn;

    @Bind(R.id.exhibition_btn)
    BottomButton exhibitionBtn;


    @Bind(R.id.news_btn)
    BottomButton newsBtn;

    @Bind(R.id.me_btn)
    BottomButton meBtn;


    @Override
    protected void initViews() {
        toolbar.setVisibility(View.GONE);
        initButton();
        initFragment();
    }

    private void initButton() {
        homeBtn.setChecked(true);
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeBtn(0);
                viewPager.setCurrentItem(0);
            }
        });
        exhibitionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeBtn(1);
                viewPager.setCurrentItem(1);
            }
        });
        newsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeBtn(2);
                viewPager.setCurrentItem(2);
            }
        });
        meBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeBtn(3);
                viewPager.setCurrentItem(3);
            }
        });
    }

    //切换底部按钮
    private void changeBtn(int position) {
        switch (position) {
            case 0:
                homeBtn.setChecked(true);
                exhibitionBtn.setChecked(false);
                meBtn.setChecked(false);
                newsBtn.setChecked(false);
                getSupportActionBar().hide();
                break;
            case 1:
                exhibitionBtn.setChecked(true);
                homeBtn.setChecked(false);
                meBtn.setChecked(false);
                newsBtn.setChecked(false);
                getSupportActionBar().hide();
                break;
            case 2:
                exhibitionBtn.setChecked(false);
                homeBtn.setChecked(false);
                meBtn.setChecked(false);
                newsBtn.setChecked(true);
                getSupportActionBar().hide();
                break;
            case 3:
                meBtn.setChecked(true);
                homeBtn.setChecked(false);
                exhibitionBtn.setChecked(false);
                newsBtn.setChecked(false);
                getSupportActionBar().hide();
                break;
        }
    }


    private void initFragment() {
        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getFragmentManager(), FragmentPagerItems.with(this)
                .add("", NewHomeFragment.class)
                .add("", ExhibitionFragment.class)
                .add("", NewsFragment.class)
                .add("", MeFragment.class)
                .create());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                changeBtn(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


    @Override
    public int getContent() {
        return R.layout.activity_main;
    }

    @Override
    public String getActionBarTitle() {
        return null;
    }
}
