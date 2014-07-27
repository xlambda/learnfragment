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
    	//���ļ� example_fragment.xml ������һ��layout 
        View v = inflater.inflate(R.layout.labeled_text_edit, container, true);
        View tv = v.findViewById(R.id.msg);
        ((TextView)tv).setText("The TextView saves and restores this text.");
        //����һ��TextView�ı���ģʽ
        ((TextView)v.findViewById(R.id.saved)).setSaveEnabled(true);
        return v;
    }
}

