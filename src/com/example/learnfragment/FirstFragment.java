package com.example.learnfragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FirstFragment extends Fragment {
    TextView mTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
    	//从文件 example_fragment.xml 加载了一个layout 
        View v = inflater.inflate(R.layout.labeled_text_edit, container, true);
        
        View tv = v.findViewById(R.id.msg);
        ((TextView)tv).setText("The fragment saves and restores this text.");

        mTextView = (TextView)v.findViewById(R.id.saved);
        if (savedInstanceState != null) {
            mTextView.setText(savedInstanceState.getCharSequence("text"));
        }
        return v;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putCharSequence("text", mTextView.getText());
    }
}
