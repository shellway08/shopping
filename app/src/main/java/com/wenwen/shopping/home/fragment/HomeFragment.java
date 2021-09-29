package com.wenwen.shopping.home.fragment;

import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.wenwen.shopping.base.BaseFragment;

public class HomeFragment extends BaseFragment {
    private static final String TAG = "HomeFragment";
    private TextView textView;

    @Override
    public View initView() {
        Log.i(TAG,"主页面Fragment的UI被创建了");
        textView = new TextView(mContext);
        textView.setTextSize(25);
        textView.setGravity(Gravity.CENTER);
        return textView;
    }

    @Override
    public void initData() {
        super.initData();
        Log.i(TAG,"主页面Fragment的数据被创建了");
        textView.setText("主页面");
    }
}
