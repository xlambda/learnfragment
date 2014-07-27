package com.example.learnfragment;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getFragmentManager();
        
        //��������д�������Activity�а�ť��Ӽ����¼�,����Fragment����ʾ������
        addShowHideListener(R.id.frag1hide, fm.findFragmentById(R.id.fragment1));
        addShowHideListener(R.id.frag2hide, fm.findFragmentById(R.id.fragment2));
    }

    void addShowHideListener(int buttonId, final Fragment fragment) {
    	//��ȡactivity�е�button
        final Button button = (Button)findViewById(buttonId);
        button.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                /*ΪFragment���õ��뵭��Ч����Android��������ʾ����������������Դ��android�ڲ���Դ���������ֶ����塣*/
                ft.setCustomAnimations(android.R.animator.fade_in,
                        android.R.animator.fade_out); 
                
                if (fragment.isHidden()) {
                    ft.show(fragment);
                    button.setText("����");
                } else {
                    ft.hide(fragment);
                    button.setText("��ʾ");
                }
                ft.commit();
            }
        });
    }
}
