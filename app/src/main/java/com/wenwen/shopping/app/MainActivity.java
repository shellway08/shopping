package com.wenwen.shopping.app;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import com.wenwen.shopping.R;
import com.wenwen.shopping.base.BaseFragment;
import com.wenwen.shopping.community.CommunityFragment;
import com.wenwen.shopping.home.fragment.HomeFragment;
import com.wenwen.shopping.shoppingcart.ShoppingFragment;
import com.wenwen.shopping.style.StyleFragment;
import com.wenwen.shopping.user.UserFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends FragmentActivity {

    @BindView(R.id.frameLayout)
    FrameLayout frameLayout;
    @BindView(R.id.rg_main)
    RadioGroup rgMain;
    private ArrayList<BaseFragment> fragments = null;
    private int position = 0;
    //缓存的fragment，或者是上一次显示的fragment
    private Fragment tempFragemnt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initFragment();
        initTabListener();

    }

    private void initTabListener() {
        rgMain.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rb_home:
                        position = 0;
                        break;
                    case R.id.rb_type:
                        position = 1;
                        break;
                    case R.id.rb_community:
                        position = 2;
                        break;
                    case R.id.rb_cart:
                        position = 3;
                        break;
                    case R.id.rb_user:
                        position = 4;
                        break;
                    default:break;
                }

                BaseFragment currentfragment = getFragment(position);
                switchFragment(tempFragemnt,currentfragment);
            }
        });

        rgMain.check(R.id.rb_home);
    }

    private BaseFragment getFragment(int position) {
        if(fragments!=null&&fragments.size()>0){
            BaseFragment baseFragment = fragments.get(position);
            return baseFragment;
        }
        return null;
    }

    private void switchFragment(Fragment fromFragment, BaseFragment
            nextFragment) {
        if (tempFragemnt != nextFragment) {
            tempFragemnt = nextFragment;
            if (nextFragment != null) {
                FragmentTransaction transaction =
                        getSupportFragmentManager().beginTransaction();
                //判断 nextFragment 是否添加
                if (!nextFragment.isAdded()) {
                    //隐藏当前 Fragment
                    if (fromFragment != null) {
                        transaction.hide(fromFragment);
                    }
                    transaction.add(R.id.frameLayout, nextFragment).commit();
                } else {
                    //隐藏当前 Fragment
                    if (fromFragment != null) {
                        transaction.hide(fromFragment);
                    }
                    transaction.show(nextFragment).commit();
                }
            }
        } }

    /**
     * 这里注意初始化顺序，根据底部菜单的顺序来
     */
    private void initFragment() {
        fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new StyleFragment());
        fragments.add(new CommunityFragment());
        fragments.add(new ShoppingFragment());
        fragments.add(new UserFragment());
    }


}