package com.szdfc.dfsm.news;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.baseandroid.activity.BaseActivity;
import com.baseandroid.recyclerview.RecyclerViewDivider;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.szdfc.dfsm.R;
import com.szdfc.dfsm.http.API;
import com.szdfc.entitylib.NewsEntity;
import com.szdfc.entitylib.ThinkTankEntity;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by HGo on 2016/8/12.
 */
public class NewsActivity extends BaseActivity {

    @Bind(R.id.news_list)
    RecyclerView recyclerView;

    NewsAdapter adapter;

    private List<NewsEntity.ResultBean> resultData = new ArrayList<>();


    @Override
    protected void initViews() {
        showBackBtn();

        adapter = new NewsAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.addItemDecoration(new RecyclerViewDivider(context, 1));
        recyclerView.setAdapter(adapter);

        loadDataFromServer();

    }

    private void loadDataFromServer() {
        API.getMainAPI().getNews(0)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<NewsEntity>() {

                    @Override
                    public void onCompleted() {
                        adapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(NewsEntity newsEntity) {
                        resultData = newsEntity.getResult();
                    }
                });
    }


    class NewsAdapter extends RecyclerView.Adapter<NewsViewHolder> {
        @Override
        public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = inflater.inflate(R.layout.item_news, parent, false);
            return new NewsViewHolder(view);
        }

        @Override
        public void onBindViewHolder(NewsViewHolder holder, int position) {
            holder.newsTitle.setText(resultData.get(position).getNtitle());
            holder.newDate.setText(resultData.get(position).getNtimePublish() + "");
            ImageLoader.getInstance().displayImage(resultData.get(position).getResourceEntity().getResourceLocation(), holder.newsPic);
        }

        @Override
        public int getItemCount() {
            return resultData.size();
        }
    }

    class NewsViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.news_pic)
        ImageView newsPic;
        @Bind(R.id.news_title)
        TextView newsTitle;
        @Bind(R.id.news_date)
        TextView newDate;

        public NewsViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    @Override
    public int getContent() {
        return R.layout.act_news;
    }

    @Override
    public String getActionBarTitle() {
        return "新闻资讯";
    }
}
