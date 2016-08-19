package com.szdfc.dfsm.travel;


import android.graphics.Color;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Calendar;

import com.baseandroid.activity.BaseActivity;
import com.szdfc.dfsm.R;

import butterknife.Bind;

/**
 * Created by HGo on 2016/8/1.
 */
public class CalendarActivity extends BaseActivity {
    private int year;
    private int viewYear;
    private int month;
    private int viewMonth;
    private int day;
    private int dayOfMonth;
    private int week;

    protected LayoutInflater inflater;

    CalendarAdapter adapter;
    int index = 0;

    @Bind(R.id.date_list)
    RecyclerView dateList;
    @Bind(R.id.calendar_title)
    TextView title;
    @Bind(R.id.prev)
    ImageView prev;
    @Bind(R.id.next)
    ImageView next;

    @Override
    protected void initViews() {
        adapter = new CalendarAdapter();
        dateList.setLayoutManager(new GridLayoutManager(getApplicationContext(), 7));
        dateList.setAdapter(adapter);
        adapter.notifyDataSetChanged();


        final Calendar calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH) + 1;
        day = calendar.get(Calendar.DATE);

        viewYear = year;
        viewMonth = month;

        dayOfMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DATE, 1);
        week = calendar.get(Calendar.DAY_OF_WEEK) - 1;

        title.setText(year + "年" + month + "月");


        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (index <= 0) {
                    return;
                }
                --index;
                changeView(calendar);

            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (index >= 2) {
                    return;
                }
                ++index;
                changeView(calendar);
            }
        });
    }

    private void changeView(Calendar calendar) {
        viewMonth = month + index;
        if (viewMonth > 12) {
            viewYear++;
            viewMonth = viewMonth - 12;
        } else {
            viewYear = year;
        }
        title.setText(viewYear + "年" + viewMonth + "月");
        dateList.removeAllViews();
        setMonth(calendar, viewMonth);
        adapter.notifyDataSetChanged();
    }

    private void setMonth(Calendar calendar, int month) {
        calendar.set(Calendar.YEAR, viewYear);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DATE, 1);
        week = calendar.get(Calendar.DAY_OF_WEEK) - 1;
    }


    class CalendarAdapter extends RecyclerView.Adapter<CalendarViewHolder> {
        @Override
        public CalendarViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = inflater.inflate(R.layout.item_calendar, parent, false);
            return new CalendarViewHolder(view);
        }

        @Override
        public void onBindViewHolder(CalendarViewHolder holder, int position) {
            if (position < week) return;
            int dayp = position + 1 - week;
            holder.dateText.setText(dayp + "");
            if (dayp == day && viewMonth == month) {
                holder.dateText.setTextColor(Color.RED);
            } else if (dayp < day) {
                holder.itemView.setEnabled(false);
                holder.dateText.setTextColor(Color.GRAY);
            }
            holder.itemView.setTag(dayp);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int d = (int) view.getTag();
//                    Log.w(TAG, "onClick: " + d);
                }
            });
        }

        @Override
        public int getItemCount() {
            return dayOfMonth + week;
        }
    }

    class CalendarViewHolder extends RecyclerView.ViewHolder {
        TextView dateText;

        public CalendarViewHolder(View itemView) {
            super(itemView);
            dateText = (TextView) itemView.findViewById(R.id.text_date);
        }
    }

    @Override
    public int getContent() {
        return R.layout.act_calendar;
    }

    @Override
    public String getActionBarTitle() {
        return "选择日期";
    }
}
