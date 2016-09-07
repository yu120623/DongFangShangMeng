package com.szdfc.dfsm.news;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.baseandroid.fragment.BaseFragment;
import com.baseandroid.util.ImagesOptionUtil;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.szdfc.dfsm.R;
import com.szdfc.dfsm.http.API;
import com.szdfc.entitylib.NewsListEntitiy;
import com.szdfc.entitylib.ResourceEntity;
import com.szdfc.entitylib.ResultBean;
import com.szdfc.entitylib.ResultListEntity;

import java.text.SimpleDateFormat;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by FreeMason on 2016/9/7.
 */
public class NewsFragment extends BaseFragment {


    @Bind(R.id.news_list)
    RecyclerView newsList;
    private NewsAdapter adapter;
    private List<NewsListEntitiy.ResultBean> resultData;
    private SimpleDateFormat simpleDateFormat;

    @Override
    protected void initViews() {
        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        adapter = new NewsAdapter();
        newsList.setLayoutManager(new LinearLayoutManager(context));
        newsList.setAdapter(adapter);
        loadDataFromServer();
    }

    private void loadDataFromServer() {
        API.getMainAPI().getNewsList(0)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<NewsListEntitiy>() {

                    @Override
                    public void onCompleted() {
                        adapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(NewsListEntitiy resultListEntity) {
                        resultData = resultListEntity.getResult();
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
            NewsListEntitiy.ResultBean news =  resultData.get(position);
            String url1 = news.getNewsResources().get(0).getLocation();
            String url2 = news.getNewsResources().get(1).getLocation();
            String url3 = news.getNewsResources().get(2).getLocation();
            ImageLoader.getInstance().displayImage(url1,holder.newsPic1,ImagesOptionUtil.getDefaultOptions());
            ImageLoader.getInstance().displayImage(url2,holder.newsPic2,ImagesOptionUtil.getDefaultOptions());
            ImageLoader.getInstance().displayImage(url3,holder.newsPic3,ImagesOptionUtil.getDefaultOptions());
            holder.newsTitle.setText(news.getNtitle());
            holder.newsDate.setText(simpleDateFormat.format(news.getNtimePublish()));
        }

        @Override
        public int getItemCount() {
            if(resultData == null)
                return 0 ;
            return resultData.size();
        }
    }

    class NewsViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.news_title)
        TextView newsTitle;
        @Bind(R.id.news_pic1)
        ImageView newsPic1;
        @Bind(R.id.news_pic2)
        ImageView newsPic2;
        @Bind(R.id.news_pic3)
        ImageView newsPic3;
        @Bind(R.id.news_date)
        TextView newsDate;
        public NewsViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

    @Override
    protected int getContentView() {
        return R.layout.act_news;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
