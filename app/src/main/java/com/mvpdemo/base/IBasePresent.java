package com.mvpdemo.base;

/**
 * 类描述：
 * 创建人：王建党
 * 创建时间：2018/2/8 15:03
 */

public class IBasePresent<P extends BaseContract.BaseView> implements BaseContract.BasePresenter<BaseContract.BaseView> {
    public P mvpView;

    @Override
    public void attachMVPView(BaseContract.BaseView view) {
        this.mvpView = (P) view;
        mvpView.setPresenter(this);//给P的子类赋值
    }

    @Override
    public void detachMVPView() {
        if (mvpView != null)
            mvpView = null;
    }

    @Override
    public boolean isAttachMVPView() {
        return mvpView != null;
    }
}
