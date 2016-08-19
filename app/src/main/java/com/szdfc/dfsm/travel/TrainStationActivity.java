package com.szdfc.dfsm.travel;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.baseandroid.activity.BaseActivity;
import com.baseandroid.recyclerview.RecyclerViewDivider;
import com.baseandroid.util.CharacterParser;
import com.baseandroid.util.CommonUtil;
import com.baseandroid.view.SideBar;
import com.szdfc.dfsm.R;
import com.szdfc.dfsm.http.API;
import com.szdfc.entitylib.TrainStationEntity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnTextChanged;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by HGo on 2016/7/29.
 */
public class TrainStationActivity extends BaseActivity {

    @Bind(R.id.city_list)
    RecyclerView cityList;

    @Bind(R.id.city_edit)
    EditText searchEdit;

    @Bind(R.id.side_bar)
    SideBar sideBar;

    List<TrainStationEntity.ResultBean> list = new ArrayList<>();
    List<TrainStationEntity.ResultBean> searchList = new ArrayList<>();
    List<TrainStationEntity.ResultBean> curList = new ArrayList<>();
    TrainStationEntity.ResultBean station;
    TrainStatAdapter adapter;

    int type = 0;

    @Override
    protected void initViews() {
        showBackBtn();
        type = getIntent().getIntExtra("type", 0);
        station = new TrainStationEntity.ResultBean();
        adapter = new TrainStatAdapter();
        cityList.setLayoutManager(new LinearLayoutManager(context));
        cityList.addItemDecoration(new RecyclerViewDivider(context, 1));
        cityList.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        getTrainStatList();

        sideBar.setOnTouchingLetterChangedListener(new SideBar.OnTouchingLetterChangedListener() {
            @Override
            public void onTouchingLetterChanged(String s) {
                int position = getPositionForSection(s.charAt(0));
                if (position != -1) {
                    cityList.scrollToPosition(position);
                }
            }
        });
    }

    private void getTrainStatList() {
        API.juHeAPI().getTrainStat("1ad4bdb773ff2255372641fe31eed702")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<TrainStationEntity>() {
                    @Override
                    public void onCompleted() {
                        showStation(list);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(TrainStationEntity trainStationEntity) {
                        list.clear();
                        list.addAll(trainStationEntity.getResult());
                    }
                });
    }

    private void showStation(List<TrainStationEntity.ResultBean> statlist) {
        list = statlist;
        for (TrainStationEntity.ResultBean stat : statlist) {
            stat.setSortLetters(CharacterParser.getInstance().getSelling(stat.getSta_name()).substring(0, 1).toUpperCase());
        }
        Collections.sort(statlist, station);
        curList.clear();
        curList.addAll(statlist);
        adapter.notifyDataSetChanged();
    }

    public int getSectionForPosition(int position) {
        return curList.get(position).getSortLetters().charAt(0);
    }

    public int getPositionForSection(int section) {
        for (int i = 0; i < curList.size(); i++) {
            String sortStr = curList.get(i).getSortLetters();
            char firstChar = sortStr.toUpperCase().charAt(0);
            if (firstChar == section) {
                return i;
            }
        }
        return -1;
    }

    @OnTextChanged(R.id.city_edit)
    void editChange() {
        searchList.clear();
        curList.clear();
        String text = searchEdit.getText().toString();
        if (CommonUtil.isEmpty(text)) {
            curList.addAll(list);
            adapter.notifyDataSetChanged();
            return;
        }
        for (TrainStationEntity.ResultBean stat : list) {
            if (stat.getSta_name().indexOf(text) != -1) {
                searchList.add(stat);
            }
        }
        curList.addAll(searchList);
        adapter.notifyDataSetChanged();
    }


    class TrainStatAdapter extends RecyclerView.Adapter<TrainStatViewHolder> {
        @Override
        public TrainStatViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = inflater.inflate(R.layout.item_city, parent, false);
            return new TrainStatViewHolder(view);
        }

        @Override
        public void onBindViewHolder(TrainStatViewHolder holder, int position) {
            int section = getSectionForPosition(position);
            if (position == getPositionForSection(section)) {
                holder.tvLetter.setVisibility(View.VISIBLE);
                holder.tvLetter.setText(curList.get(position).getSortLetters());
            } else {
                holder.tvLetter.setVisibility(View.GONE);
            }
            holder.cityName.setText(curList.get(position).getSta_name());
            holder.itemView.setTag(position);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = (int) view.getTag();
                    Intent intent = new Intent();
                    switch (type) {
                        case 3:
                            intent.putExtra("from", curList.get(position).getSta_name());
                            break;
                        case 4:
                            intent.putExtra("to", curList.get(position).getSta_name());
                            break;
                    }
                    setResult(RESULT_OK, intent);
                    finish();
                }
            });
        }

        @Override
        public int getItemCount() {
            return curList.size();
        }

    }

    class TrainStatViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.city_name)
        TextView cityName;
        @Bind(R.id.pinyin)
        TextView tvLetter;

        public TrainStatViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    @Override
    public int getContent() {
        return R.layout.act_city;
    }

    @Override
    public String getActionBarTitle() {
        return "选择站台";
    }
}
