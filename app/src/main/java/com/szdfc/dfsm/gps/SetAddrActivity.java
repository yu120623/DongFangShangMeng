package com.szdfc.dfsm.gps;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.amap.api.services.help.Inputtips;
import com.amap.api.services.help.InputtipsQuery;
import com.amap.api.services.help.Tip;
import com.baseandroid.activity.BaseActivity;
import com.baseandroid.recyclerview.RecyclerViewDivider;
import com.baseandroid.util.CommonUtil;
import com.szdfc.dfsm.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * Created by HGo on 2016/8/10.
 */
public class SetAddrActivity extends BaseActivity implements Inputtips.InputtipsListener, TextWatcher {

    private static final String TAG = "SetAddrAct";
    EditText keyword;
    TextView search;

    @Bind(R.id.tip_list)
    RecyclerView recyclerView;

    List<Tip> tiplist = new ArrayList<>();

    TipsAdapter adapter;

    @Override
    protected void initViews() {
        showBackBtn();
        adapter = new TipsAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.addItemDecoration(new RecyclerViewDivider(context, 1));
        recyclerView.setAdapter(adapter);
    }


    class TipsAdapter extends RecyclerView.Adapter<TipsViewHolder> {
        @Override
        public TipsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = inflater.inflate(R.layout.item_tip, parent, false);
            return new TipsViewHolder(view);
        }

        @Override
        public void onBindViewHolder(TipsViewHolder holder, final int position) {
            holder.tipName.setText(tiplist.get(position).getName());
            holder.tipAddr.setText(tiplist.get(position).getAddress());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent();
                    intent.putExtra("name", tiplist.get(position).getName());
                    intent.putExtra("lat", tiplist.get(position).getPoint().getLatitude());
                    intent.putExtra("lng", tiplist.get(position).getPoint().getLongitude());
                    setResult(RESULT_OK, intent); //intent为A传来的带有Bundle的intent，当然也可以自己定义新的Bundle
                    finish();
                }
            });
        }

        @Override
        public int getItemCount() {
            return tiplist.size();
        }
    }

    class TipsViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.tip_name)
        TextView tipName;
        @Bind(R.id.tip_addr)
        TextView tipAddr;

        public TipsViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    @Override
    public int getContent() {
        return R.layout.act_setaddr;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search, menu);
        MenuItem menuItem = menu.findItem(R.id.time_filter);
        keyword = (EditText) menuItem.getActionView().findViewById(R.id.search_edit_addr);
        search = (TextView) menuItem.getActionView().findViewById(R.id.search);
        keyword.addTextChangedListener(this);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public String getActionBarTitle() {
        return null;
    }

    @Override
    public void onGetInputtips(List<Tip> tipList, int rCode) {
        if (rCode == 1000) {// 正确返回
            tiplist = tipList;
//            List<String> listString = new ArrayList<String>();
//            for (int i = 0; i < tipList.size(); i++) {
//                listString.add(tipList.get(i).getName());
//                Log.w(TAG, "name: " + tipList.get(i).getName() + "," + tipList.get(i).getPoint() + "," + tipList.get(i).getDistrict());
//            }
            adapter.notifyDataSetChanged();
        } else {
            Log.w(TAG, "onGetInputtips: " + this + "," + rCode);
        }

    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        String newText = charSequence.toString().trim();
        if (!CommonUtil.isEmpty(newText)) {
            InputtipsQuery inputquery = new InputtipsQuery(newText, keyword.getText().toString());
            Inputtips inputTips = new Inputtips(SetAddrActivity.this, inputquery);
            inputTips.setInputtipsListener(this);
            inputTips.requestInputtipsAsyn();
        }
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }
}
