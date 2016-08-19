package com.szdfc.dfsm.travel;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.baseandroid.activity.BaseActivity;
import com.baseandroid.util.CommonUtil;
import com.szdfc.dfsm.R;
import com.szdfc.dfsm.http.API;
import com.szdfc.entitylib.PlanEntity;
import com.szdfc.entitylib.TrainEntity;

import butterknife.Bind;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class TravelActivity extends BaseActivity {
    @Bind(R.id.from_btn)
    LinearLayout fromBtn;
    @Bind(R.id.from_text)
    TextView fromText;

    @Bind(R.id.to_btn)
    LinearLayout toBtn;
    @Bind(R.id.to_text)
    TextView toText;

    @Bind(R.id.search_btn)
    Button search;

    @Bind(R.id.travel_img)
    ImageView img;
    @Bind(R.id.select_date)
    RelativeLayout selectDate;

    String start = "";
    String end = "";
    String date = "";

    int actIndex = 0;

    @Override
    protected void initViews() {
        showBackBtn();
        actIndex = getIntent().getIntExtra("index", 0);
        switch (actIndex) {
            case 1:
                toolbar.setTitle("航班查询");
                img.setImageResource(R.mipmap.plan);
                selectDate.setVisibility(View.VISIBLE);
                initBtn();
                break;
            case 2:
                toolbar.setTitle("高铁动车");
                img.setImageResource(R.mipmap.train);
                initBtn1();
                break;
            case 3:
                toolbar.setTitle("大巴直通车");
                img.setImageResource(R.mipmap.bus);
                initBtn2();
                break;
        }

    }

    private void initBtn2() {
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(context, ResultActivity.class);
                intent.putExtra("index", actIndex);
                intent.putExtra("start", start);
                intent.putExtra("end", end);
                intent.putExtra("date", "");
                startActivity(intent);
            }
        });

    }

    private void initBtn1() {
        fromBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(context, TrainStationActivity.class);
                intent.putExtra("type", 3);
                startActivityForResult(intent, 3);
            }
        });

        toBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(context, TrainStationActivity.class);
                intent.putExtra("type", 4);
                startActivityForResult(intent, 4);
            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if (CommonUtil.isEmpty(start) || CommonUtil.isEmpty(end)) {
//                    CommonUtil.showMessage(context, "请选择");
//                }
                Intent intent = new Intent();
                intent.setClass(context, ResultActivity.class);
                intent.putExtra("index", actIndex);
                intent.putExtra("start", start);
                intent.putExtra("end", end);
                intent.putExtra("date", "");

                startActivity(intent);

//                getTrainData();
            }
        });
    }

    private void getTrainData() {
        API.juHeAPI().getTrainList("1ad4bdb773ff2255372641fe31eed702", start, end)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<TrainEntity>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(TrainEntity trainEntity) {
                        trainEntity.getResult();
                    }
                });

    }


    private void getPlanData() {
        API.juHeAPI().getPlanBC(start, end, date, "87df352f9bfcca134abb76151936dc27")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<PlanEntity>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(PlanEntity planEntity) {
                        planEntity.getResult();

                    }
                });
    }

    private void initBtn() {
        fromBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(context, PlanCityActivity.class);
                intent.putExtra("type", 1);
                startActivityForResult(intent, 1);
            }
        });

        toBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(context, PlanCityActivity.class);
                intent.putExtra("type", 2);
                startActivityForResult(intent, 2);
            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getPlanData();
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK)
            if (requestCode == 1) {
                start = data.getStringExtra("from");
                if (!CommonUtil.isEmpty(start)) {
                    fromText.setText(start);
                }
            } else if (requestCode == 2) {
                end = data.getStringExtra("to");
                if (!CommonUtil.isEmpty(end)) {
                    toText.setText(end);
                }
            } else if (requestCode == 3) {
                start = data.getStringExtra("from");
                if (!CommonUtil.isEmpty(start)) {
                    fromText.setText(start);
                }
            } else if (requestCode == 4) {
                end = data.getStringExtra("to");
                if (!CommonUtil.isEmpty(end)) {
                    toText.setText(end);
                }
            }
    }

    @Override
    public int getContent() {
        return R.layout.act_bus;
    }

    @Override
    public String getActionBarTitle() {
        return null;
    }


}
