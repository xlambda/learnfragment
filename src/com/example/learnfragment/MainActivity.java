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
        
        //下面的两行代码是在Activity中按钮添加监听事件,控制Fragment的显示和隐藏
        addShowHideListener(R.id.frag1hide, fm.findFragmentById(R.id.fragment1));
        addShowHideListener(R.id.frag2hide, fm.findFragmentById(R.id.fragment2));
    }

    void addShowHideListener(int buttonId, final Fragment fragment) {
    	//获取activity中的button
        final Button button = (Button)findViewById(buttonId);
        button.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                /*为Fragment设置淡入淡出效果，Android开发网提示这里这两个动画资源是android内部资源无需我们手动定义。*/
                ft.setCustomAnimations(android.R.animator.fade_in,
                        android.R.animator.fade_out); 
                
                if (fragment.isHidden()) {
                    ft.show(fragment);
                    button.setText("隐藏");
                } else {
                    ft.hide(fragment);
                    button.setText("显示");
                }
                ft.commit();
            }
        });
    }
}
