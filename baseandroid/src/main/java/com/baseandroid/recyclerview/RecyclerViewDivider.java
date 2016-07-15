package com.baseandroid.recyclerview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.baseandroid.R;
import com.baseandroid.util.CommonUtil;

/**
 * Created by FreeMason on 2016/7/8.
 */
public class RecyclerViewDivider extends RecyclerView.ItemDecoration {
    private Drawable mDivider;
    private Context context;
    private int height;
    public RecyclerViewDivider(Context context,int heightDP){
        this(context,heightDP,R.drawable.list_divider);
    }

    public RecyclerViewDivider(Context context,int heightDP,int dividerDrawable){
        mDivider = ActivityCompat.getDrawable(context,dividerDrawable);
        this.height = heightDP;
        this.context = context;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.bottom = CommonUtil.dip2px(context, height);
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        final int left = parent.getPaddingLeft();
        final int right = parent.getWidth() - parent.getPaddingRight();
        final int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            final View child = parent.getChildAt(i);
            android.support.v7.widget.RecyclerView v = new android.support.v7.widget.RecyclerView(parent.getContext());
            final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child
                    .getLayoutParams();
            final int top = child.getBottom() + params.bottomMargin;
            final int bottom = top + mDivider.getIntrinsicHeight();
            mDivider.setBounds(left, top, right, bottom);
            mDivider.draw(c);
        }
    }
}
