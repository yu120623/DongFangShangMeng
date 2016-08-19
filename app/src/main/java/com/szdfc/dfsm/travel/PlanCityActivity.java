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
import com.szdfc.entitylib.CityEntity;

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
 * Created by HGo on 2016/7/25.
 */
public class PlanCityActivity extends BaseActivity {
    @Bind(R.id.city_list)
    RecyclerView cityList;

    @Bind(R.id.city_edit)
    EditText searchEdit;

    @Bind(R.id.side_bar)
    SideBar sideBar;


    List<CityEntity.ResultBean> planList = new ArrayList<>();
    List<CityEntity.ResultBean> planSearchList = new ArrayList<>();
    List<CityEntity.ResultBean> curPlanList = new ArrayList<>();
    CityEntity.ResultBean city;
    CityAdapter adapter;

    int type = 0;

    @OnTextChanged(R.id.city_edit)
    void editChange() {
        planSearchList.clear();
        curPlanList.clear();
        String text = searchEdit.getText().toString();
        if (CommonUtil.isEmpty(text)) {
            curPlanList.addAll(planList);
            adapter.notifyDataSetChanged();
            return;
        }
        for (CityEntity.ResultBean city : planList) {
            if (city.getCity().indexOf(text) != -1) {
                planSearchList.add(city);
            }
        }
        curPlanList.addAll(planSearchList);
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void initViews() {
        showBackBtn();
        type = getIntent().getIntExtra("type", 0);
        city = new CityEntity.ResultBean();
        adapter = new CityAdapter();
        cityList.setLayoutManager(new LinearLayoutManager(context));
        cityList.addItemDecoration(new RecyclerViewDivider(context, 1));
        cityList.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        getPlanCityList();

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


    private void getPlanCityList() {
        API.juHeAPI().getPlanCity("87df352f9bfcca134abb76151936dc27")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<CityEntity>() {
                    @Override
                    public void onCompleted() {
                        showCity(planList);
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(CityEntity cityEntity) {
                        planList.clear();
                        planList.addAll(cityEntity.getResult());
                    }
                });

    }

    private void showCity(List<CityEntity.ResultBean> list) {
        planList = list;
        for (CityEntity.ResultBean city : list) {
            city.setSortLetters(CharacterParser.getInstance().getSelling(city.getCity()).substring(0, 1).toUpperCase());
        }
        Collections.sort(list, city);
        curPlanList.clear();
        curPlanList.addAll(list);
        adapter.notifyDataSetChanged();
    }

    public int getSectionForPosition(int position) {
        return curPlanList.get(position).getSortLetters().charAt(0);
    }

    public int getPositionForSection(int section) {
        for (int i = 0; i < curPlanList.size(); i++) {
            String sortStr = curPlanList.get(i).getSortLetters();
            char firstChar = sortStr.toUpperCase().charAt(0);
            if (firstChar == section) {
                return i;
            }
        }
        return -1;
    }


    class CityAdapter extends RecyclerView.Adapter<CityViewHolder> {
        @Override
        public CityViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = inflater.inflate(R.layout.item_city, parent, false);
            return new CityViewHolder(view);
        }

        @Override
        public void onBindViewHolder(CityViewHolder holder, int position) {
            int section = getSectionForPosition(position);
            if (position == getPositionForSection(section)) {
                holder.tvLetter.setVisibility(View.VISIBLE);
                holder.tvLetter.setText(curPlanList.get(position).getSortLetters());
            } else {
                holder.tvLetter.setVisibility(View.GONE);
            }
            holder.cityName.setText(curPlanList.get(position).getCity());
            holder.itemView.setTag(position);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = (int) view.getTag();
                    Intent intent = new Intent();
                    switch (type) {
                        case 1:
                            intent.putExtra("from", curPlanList.get(position).getCity());
                            break;
                        case 2:
                            intent.putExtra("to", curPlanList.get(position).getCity());
                            break;
                    }
                    setResult(RESULT_OK, intent);
                    finish();
                }
            });
        }

        @Override
        public int getItemCount() {
            return curPlanList.size();
        }

    }

    class CityViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.city_name)
        TextView cityName;
        @Bind(R.id.pinyin)
        TextView tvLetter;

        public CityViewHolder(View itemView) {
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
        return "选择城市";
    }
}
