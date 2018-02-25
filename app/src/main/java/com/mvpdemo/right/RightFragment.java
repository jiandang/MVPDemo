package com.mvpdemo.right;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.mvpdemo.R;
import com.mvpdemo.base.BaseContract;
import com.mvpdemo.base.MVPFragment;


public class RightFragment extends MVPFragment<RightPresenterImpl> implements RightViewImpl {
    private ProgressDialog mProgressDialog;
    private TextView m_right_tv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frag_right, null);
        m_right_tv = v.findViewById(R.id.tv_right);
        mProgressDialog = new ProgressDialog(getActivity());
        mProgressDialog.setTitle("提示");
        mProgressDialog.setMessage("正在加载中...");
        mProgressDialog.show();
        mIBasePresenter.getData();
        return v;
    }

    @Override
    public void setPresenter(BaseContract.BasePresenter presenter) {
        this.mIBasePresenter = (RightPresenterImpl) presenter;
    }

    @Override
    public void showData(String data) {
        mProgressDialog.dismiss();
        Toast.makeText(getActivity(), data, Toast.LENGTH_SHORT).show();
        m_right_tv.setText(data);
    }
}
