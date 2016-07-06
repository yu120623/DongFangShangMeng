package photo.fragment;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.ViewGroup;

import com.baseandroid.R;
import com.baseandroid.fragment.BaseFragment;

import java.util.List;

import photo.view.PhotoImageView;

public class PhotoViewPageFragment extends BaseFragment {
	private ViewPager pager;
	private PhotoAdapter adapter;
	private Integer pageIndex;
	private List<String> urls;

	@Override
	protected void initViews() {
		findViews();
		initData();
	}


	private void findViews() {
		pager = (ViewPager) this.findViewById(R.id.photo_view_page);
	}

	private void initData() {
		pageIndex = this.getArguments().getInt("index", 0);
		urls = this.getArguments().getStringArrayList("urls");
		adapter = new PhotoAdapter();
		pager.setAdapter(adapter);
		if (pageIndex != -1)
			pager.setCurrentItem(pageIndex);
		pager.addOnPageChangeListener(new OnPageChangeListener() {
			@Override
			public void onPageSelected(int index) {

			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {

			}

			@Override
			public void onPageScrollStateChanged(int arg0) {

			}
		});

	}

	class PhotoAdapter extends PagerAdapter {
		@Override
		public int getCount() {
			return urls.size();
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0 == arg1;
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			container.removeView((View) object);
		}

		@Override
		public Object instantiateItem(ViewGroup container, final int position) {
			View view = inflater.inflate(R.layout.page_imager, null, false);
			PhotoImageView imageView = (PhotoImageView) view.findViewById(R.id.photo_img);
			imageView.loadImage(urls.get(position));
			container.addView(view);
			return view;
		}

	}

	@Override
	protected int getContentView() {
		return R.layout.act_photo_view_page;
	}

}
