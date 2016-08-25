package com.szdfc.dfsm.businessschool;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.baseandroid.activity.BaseActivity;
import com.baseandroid.util.CommonUtil;
import com.baseandroid.view.InScrollViewGridView;
import com.szdfc.dfsm.R;
import com.szdfc.dfsm.http.API;
import com.szdfc.entitylib.BussinessSchoolDetailEntity;

import butterknife.Bind;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.schedulers.Schedulers;

/**
 * Created by FreeMason on 2016/8/25.
 */
public class BusinessSchoolDetailActivity extends BaseActivity {
    @Bind(R.id.web_view)
    WebView webView;
    @Bind(R.id.resource_grid)
    InScrollViewGridView resourceGrid;

    @Override
    protected void initViews() {
        showBackBtn();
        String id = this.getIntent().getStringExtra("id");
        API.getMainAPI().businessSchoolFindOne(id)
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        showProgress();
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<BussinessSchoolDetailEntity>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(BussinessSchoolDetailEntity b) {
                        show(b);
                    }
                });
    }

    private void show(final BussinessSchoolDetailEntity b) {
        hideProgressStatusLayout();
        webView.getSettings().setDefaultTextEncodingName("utf-8");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            webView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.TEXT_AUTOSIZING);
        } else {
            webView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);
        }
        webView.loadData(CommonUtil.getHtmlData(b.getResult().getBshare()), "text/html; charset=utf-8", "utf-8");
        resourceGrid.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                if (b.getResult().getResourceEntities() == null)
                    return 0;
                return b.getResult().getResourceEntities().size();
            }

            @Override
            public Object getItem(int i) {
                return null;
            }

            @Override
            public long getItemId(int i) {
                return 0;
            }

            @Override
            public View getView(int i, View view, ViewGroup viewGroup) {
                final BussinessSchoolDetailEntity.ResultBean.ResourceEntitiesBean r = b.getResult().getResourceEntities().get(i);
                view = inflater.inflate(R.layout.item_download, viewGroup, false);
                TextView name = (TextView) view.findViewById(R.id.download_name);
                name.setText(r.getResourceName());
                name.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Uri uri = Uri.parse(r.getResourceLocation());
                        Intent it = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(it);
                    }
                });
                return view;
            }
        });
    }

    @Override
    public int getContent() {
        return R.layout.act_business_school_detail;
    }

    @Override
    public String getActionBarTitle() {
        return "商学院详细";
    }
}
