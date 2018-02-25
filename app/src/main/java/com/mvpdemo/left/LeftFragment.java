package com.mvpdemo.left;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.mvpdemo.R;
import com.mvpdemo.base.MVPFragment;

public class LeftFragment extends MVPFragment<LeftPresenterImpl> {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frag_left, null);
        EditText tv = (EditText) v.findViewById(R.id.edit_input);
        tv.setText(getActivity().getClass().getSimpleName() + "");
        return v;
    }
}
