package com.szdfc.dfsm.fragment;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.baseandroid.fragment.BaseFragment;
import com.baseandroid.util.CommonUtil;
import com.szdfc.dfsm.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;


public class NewHomeFragment extends BaseFragment {

    @Bind(R.id.home_view_page)
    ViewPager viewPager;

    List<View> viewList = new ArrayList<>();

    PagerAdapter viewPagerAdapter = new PagerAdapter() {
        @Override
        public int getCount() {
            return viewList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position,
                                Object object) {
            container.removeView(viewList.get(position));
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(viewList.get(position));
            return viewList.get(position);
        }
    };

    @Override
    protected void initViews() {

        initViewPager();

    }

    private void initViewPager() {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, CommonUtil.getScreenHeight(wm) / 4);
        viewPager.setLayoutParams(lp);

        viewPager.setAdapter(viewPagerAdapter);
        for (int i = 0; i < 4; i++) {
            LayoutInflater inflater = getActivity().getLayoutInflater();
            View view1 = inflater.inflate(R.layout.item_home_view_page, null);
            viewList.add(view1);
            ImageView imageView = (ImageView) view1.findViewById(R.id.view_img);
            imageView.setBackgroundResource(R.mipmap.bg);
            viewPagerAdapter.notifyDataSetChanged();
        }
    }

    @Override
    protected int getContentView() {
        return R.layout.frag_new_home;
    }
}
