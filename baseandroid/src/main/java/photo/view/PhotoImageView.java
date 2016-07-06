package photo.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.baseandroid.R;
import com.baseandroid.util.CommonUtil;
import com.baseandroid.view.NumberProgressBar;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.imageaware.ImageViewAware;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.nostra13.universalimageloader.core.listener.ImageLoadingProgressListener;
import com.nostra13.universalimageloader.utils.DiskCacheUtils;

import uk.co.senab.photoview.PhotoView;
import uk.co.senab.photoview.PhotoViewAttacher;


//显示图片，能够放大缩小.网络图片显示加载进度条
public class PhotoImageView extends RelativeLayout {
	private NumberProgressBar downloadImgProgressBar;
	private LayoutInflater inflater;
	private PhotoView imageView;
	private PhotoViewAttacher mAttacher;
	private int rotation = 0;
	public PhotoImageView(Context context) {
		super(context);
		init();
		initView();
	}

	public PhotoImageView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
		initView();
	}

	public PhotoImageView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
		initView();
	}
	
	public void init(){
		inflater = LayoutInflater.from(getContext());
		setBackgroundColor(Color.BLACK);
	}

	private void initView() {
		addImageView();
		addProgressBar();
		//addRotationBtn();
	}



	private void addImageView() {		
		imageView = new PhotoView(getContext());
		LayoutParams layoutParams = new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT); 
		imageView.setLayoutParams(layoutParams);
		addView(imageView);
	}

	private void addProgressBar() {
		downloadImgProgressBar = (NumberProgressBar) inflater.inflate(R.layout.download_img_progress_bar, null,false);
		LayoutParams layoutParams = new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT); 
		layoutParams.setMargins(20, 20, 20, 0);
		layoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
		downloadImgProgressBar.setLayoutParams(layoutParams);	
		addView(downloadImgProgressBar);
	}
	
	public void hideProgressBar(){
		downloadImgProgressBar.setVisibility(View.GONE);
	}

	public ImageView getImageView() {
		return imageView;
	}
	
	public void setProgress(int progress){
		downloadImgProgressBar.setProgress(progress);
	}

	public void loadImage(String url){
		if(DiskCacheUtils.findInCache(url, ImageLoader.getInstance().getDiskCache()) != null){
			hideProgressBar();
		}
		ImageLoader.getInstance().displayImage(url, new ImageViewAware(imageView), null, null, new ImageLoadingListener() {
			@Override
			public void onLoadingStarted(String s, View view) {

			}

			@Override
			public void onLoadingFailed(String s, View view, FailReason failReason) {

			}

			@Override
			public void onLoadingComplete(String s, View view, Bitmap bitmap) {
				hideProgressBar();
			}

			@Override
			public void onLoadingCancelled(String s, View view) {

			}
		}, new ImageLoadingProgressListener() {
			@Override
			public void onProgressUpdate(String s, View view, int current, int total) {
				int progress = CommonUtil.getProgress(current, total);
				setProgress(progress);
				if (progress >= 100)
					hideProgressBar();
			}
		});
	}
	
}
