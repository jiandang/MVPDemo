package com.mvpdemo.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

import com.mvpdemo.R;
import com.mvpdemo.base.BaseContract;
import com.mvpdemo.base.MVPActivity;
import com.mvpdemo.base.MVPFragment;
import com.mvpdemo.left.LeftFragment;
import com.mvpdemo.right.RightFragment;
import com.mvpdemo.right.RightPresenterImpl;


/**
 * 类描述：
 * 创建人：王建党
 * 创建时间：2018/2/8 14:46
 */

public class HomeActivity extends MVPActivity<HomePresenterImpl> implements View.OnClickListener {
    private View mHome_bottom_tab1, mHome_bottom_tab2;
    private final String LEFT = "left", RIGHT = "right";
    private FragmentManager mFragmentManager;
    private RightPresenterImpl mRightPresenterImpl;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_layout);
        initview();
    }

    private void initview() {
        mFragmentManager = getSupportFragmentManager();
        mHome_bottom_tab1 = findViewById(R.id.home_bottom_tab1);
        mHome_bottom_tab2 = findViewById(R.id.home_bottom_tab2);
        mHome_bottom_tab1.findViewById(R.id.iv_icon).setBackgroundResource(
                R.drawable.home_bottom_show_iv_selector);
        mHome_bottom_tab2.findViewById(R.id.iv_icon).setBackgroundResource(
                R.drawable.home_bottom_me_iv_selector);
        ((TextView) mHome_bottom_tab1.findViewById(R.id.tv_text)).setText("左边");
        ((TextView) mHome_bottom_tab2.findViewById(R.id.tv_text)).setText("右边");
        mHome_bottom_tab1.setOnClickListener(this);
        mHome_bottom_tab2.setOnClickListener(this);
        mHome_bottom_tab1.setSelected(true);
        switchContent(LEFT);
    }

    private void bottomChangeSelected(View selectedView) {
        mHome_bottom_tab1.setSelected(false);
        mHome_bottom_tab2.setSelected(false);
        selectedView.setSelected(true);
    }

    private void switchContent(String tag) {
        MVPFragment fragment = null;
        if (LEFT.equals(tag)) {
            bottomChangeSelected(mHome_bottom_tab1);
            fragment = (MVPFragment) mFragmentManager.findFragmentByTag(tag);
            if (fragment == null) {
                fragment = new LeftFragment();
            }
        } else if (RIGHT.equals(tag)) {
            bottomChangeSelected(mHome_bottom_tab2);
            fragment = (MVPFragment) mFragmentManager.findFragmentByTag(tag);
            if (fragment == null) {
                fragment = new RightFragment();
                mRightPresenterImpl = new RightPresenterImpl();
                mRightPresenterImpl.attachMVPView((RightFragment)fragment);
            }
        }
        if (mFragmentManager != null && fragment != null) {
            if (fragment.isAdded()) {
                return;
            }
            mFragmentManager.beginTransaction()
                    .replace(R.id.home_container, fragment, tag).addToBackStack(tag)
                    .commitAllowingStateLoss();
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_BACK) {
            finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.home_bottom_tab1:
                if (!mHome_bottom_tab1.isSelected()) {
                    switchContent(LEFT);
                }
                break;
            case R.id.home_bottom_tab2:
                if (!mHome_bottom_tab2.isSelected()) {
                    switchContent(RIGHT);
                }
                break;

            default:
                break;
        }
    }

    @Override
    public void setPresenter(BaseContract.BasePresenter presenter) {
    }
}
