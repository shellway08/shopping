package com.wenwen.shopping.user;

import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.wenwen.shopping.base.BaseFragment;

public class UserFragment extends BaseFragment {
    private static final String TAG = "UserFragment";
    private TextView textView;

    @Override
    public View initView() {
        Log.i(TAG,"个人中心页面Fragment的UI被创建了");
        textView = new TextView(mContext);
        textView.setTextSize(25);
        textView.setGravity(Gravity.CENTER);
        return textView;
    }

    @Override
    public void initData() {
        super.initData();
        Log.i(TAG,"个人中心页面Fragment的数据被创建了");
        textView.setText("个人中心页面");
    }
}
