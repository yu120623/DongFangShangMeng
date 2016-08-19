package com.baseandroid.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.baseandroid.R;
import com.baseandroid.util.CommonUtil;


public class BottomButton extends RelativeLayout {
    private Drawable imgDrawable;
    private Drawable imgAdd;
    private ColorStateList textgDrawable;
    private View buttonLayout;
    private ImageView buttonImg;
    private TextView buttonTextView;
    private String text;
    private View tip;
    private ImageView addBtnImg;

    public BottomButton(Context context) {
        super(context);
        init(null);
    }

    public BottomButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    public BottomButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public void init(AttributeSet attrs) {
        buttonLayout = inflate(getContext(), R.layout.bottom_button_item, null);
        buttonImg = (ImageView) buttonLayout.findViewById(R.id.button_img);
        addBtnImg = (ImageView) buttonLayout.findViewById(R.id.add_btn_img);
        buttonTextView = (TextView) buttonLayout.findViewById(R.id.button_text);
        tip = buttonLayout.findViewById(R.id.tip);
        if (attrs != null) {
            TypedArray styled = getContext().obtainStyledAttributes(attrs, R.styleable.BottomButton);
            imgDrawable = styled.getDrawable(R.styleable.BottomButton_buttonImg);
            imgAdd = styled.getDrawable(R.styleable.BottomButton_addButtonImg);
            textgDrawable = styled.getColorStateList(R.styleable.BottomButton_buttonTextColor);
            text = styled.getString(R.styleable.BottomButton_buttonText);
            styled.recycle();
        }
        if (imgAdd != null) {
            addBtnImg.setVisibility(VISIBLE);
        }
        buttonImg.setImageDrawable(imgDrawable);
        addBtnImg.setImageDrawable(imgAdd);
        buttonTextView.setTextColor(textgDrawable);
        buttonTextView.setText(text);
        LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        addView(buttonLayout, params);
    }

    public void setChecked(boolean flag) {
        buttonImg.setSelected(flag);
        buttonTextView.setSelected(flag);
    }

    public void showTip() {
        tip.setVisibility(View.VISIBLE);
    }

    public void hideTip() {
        tip.setVisibility(View.GONE);
    }

}
