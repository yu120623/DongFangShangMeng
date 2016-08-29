package com.szdfc.dfsm.studytour;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.baseandroid.activity.BaseActivity;
import com.baseandroid.util.ImagesOptionUtil;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.szdfc.dfsm.R;
import com.szdfc.dfsm.http.API;
import com.szdfc.entitylib.ResultBean;
import com.szdfc.entitylib.ResultListEntity;
import com.szdfc.entitylib.StudyTourEntity;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by HGo on 2016/8/15.
 */
public class StudyTourActivity extends BaseActivity {
    @Bind(R.id.studytour_list)
    RecyclerView recyclerView;

    StudyTourAdapter adapter;
    List<ResultBean> resultData = new ArrayList<>();

    @Override
    protected void initViews() {
        showBackBtn();

        adapter = new StudyTourAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(adapter);

        loadDataFromServer();
    }

    private void loadDataFromServer() {
        API.getMainAPI().getStudyTourList(0)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ResultListEntity>() {
                    @Override
                    public void onCompleted() {
                        adapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(ResultListEntity resultListEntity) {
                        resultData = resultListEntity.getResult();
                    }

                });

    }

    class StudyTourAdapter extends RecyclerView.Adapter<StudyTourViewHolder> {
        @Override
        public StudyTourViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = inflater.inflate(R.layout.item_studyour, parent, false);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ResultBean resultBean = (ResultBean) view.getTag();
                    Intent intent = new Intent(context,StudyTourDetailActivity.class);
                    intent.putExtra("id",resultBean.getSid()+"");
                    startActivity(intent);
                }
            });
            return new StudyTourViewHolder(view);
        }

        @Override
        public void onBindViewHolder(StudyTourViewHolder holder, int position) {
            ImageLoader.getInstance().displayImage(resultData.get(position).getResourceEntity().getResourceLocation(), holder.img, ImagesOptionUtil.getDefaultOptions());
            holder.title.setText(resultData.get(position).getSname());
            holder.desc.setText(resultData.get(position).getSdesc());
            holder.itemView.setTag(resultData.get(position));
        }

        @Override
        public int getItemCount() {
            return resultData.size();
        }
    }

    class StudyTourViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.sty_img)
        ImageView img;
        @Bind(R.id.sty_title)
        TextView title;
        @Bind(R.id.sty_desc)
        TextView desc;

        public StudyTourViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    @Override
    public int getContent() {
        return R.layout.act_studytour;
    }

    @Override
    public String getActionBarTitle() {
        return "游学";
    }
}
