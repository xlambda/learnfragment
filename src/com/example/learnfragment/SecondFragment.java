package com.example.learnfragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SecondFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
    	//从文件 example_fragment.xml 加载了一个layout 
        View v = inflater.inflate(R.layout.labeled_text_edit, container, true);
        View tv = v.findViewById(R.id.msg);
        ((TextView)tv).setText("The TextView saves and restores this text.");
        //另外一种TextView的保存模式
        ((TextView)v.findViewById(R.id.saved)).setSaveEnabled(true);
        return v;
    }
}

