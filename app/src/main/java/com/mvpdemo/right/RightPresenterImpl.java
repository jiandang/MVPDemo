package com.mvpdemo.right;

import android.os.Handler;

import com.mvpdemo.base.IBasePresent;


/**
 * 类描述：
 * 创建人：王建党
 * 创建时间：2018/2/9 11:09
 */

public class RightPresenterImpl extends IBasePresent<RightViewImpl> {

    public void getData() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(isAttachMVPView()){
                    mvpView.showData("获取数据成功");
                }
            }
        }, 3000);
    }
}
