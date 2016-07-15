package com.szdfc.dfsm;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.baseandroid.activity.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by HGo on 2016/7/11.
 */
public class ExhibitionActivity extends BaseActivity {

    @Bind(R.id.exhibition_recyclerview)
    RecyclerView recyclerView;

    ExhibitionAdapter adapter;

    @Override
    protected void initViews() {
        showBackBtn();
        adapter = new ExhibitionAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(adapter);
    }


    class ExhibitionAdapter extends RecyclerView.Adapter<ExhibitionViewHolder> {

        @Override
        public ExhibitionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = inflater.inflate(R.layout.item_exhibition, parent, false);
            return new ExhibitionViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ExhibitionViewHolder holder, int position) {
        }


        @Override
        public int getItemCount() {
            return 10;
        }
    }

    class ExhibitionViewHolder extends RecyclerView.ViewHolder {

        public ExhibitionViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


    @Override
    public int getContent() {
        return R.layout.act_exhibition;
    }

    @Override
    public String getActionBarTitle() {
        return "展会";
    }
}
