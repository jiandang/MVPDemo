package com.mvpdemo.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * 类描述：
 * 创建人：王建党
 * 创建时间：2018/2/8 16:39
 */

public class MVPFragment<P extends IBasePresent> extends Fragment {
    public P mIBasePresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mIBasePresenter != null) {
            mIBasePresenter.detachMVPView();
        }
    }
}
