package com.mvpdemo.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.Window;

/**
 * 类描述：
 * 创建人：王建党
 * 创建时间：2018/2/8 14:46
 */

public abstract class MVPActivity<T extends IBasePresent> extends FragmentActivity implements BaseContract.BaseView {
    public T iBasePresent;//谁需要谁实现,然后绑定

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
    }

    public void attachMVPView() {
        if (iBasePresent != null) {
            iBasePresent.attachMVPView(this);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (iBasePresent != null) {
            iBasePresent.detachMVPView();
        }
    }
}
