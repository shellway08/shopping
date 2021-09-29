package com.wenwen.shopping.style;

import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.wenwen.shopping.base.BaseFragment;

public class StyleFragment extends BaseFragment {
    private static final String TAG = "StyleFragment";
    private TextView textView;

    @Override
    public View initView() {
        Log.i(TAG,"分类车页面Fragment的UI被创建了");
        textView = new TextView(mContext);
        textView.setTextSize(25);
        textView.setGravity(Gravity.CENTER);
        return textView;
    }

    @Override
    public void initData() {
        super.initData();
        Log.i(TAG,"分类页面Fragment的数据被创建了");
        textView.setText("分类页面");
    }
}
